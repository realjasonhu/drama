package com.drama.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.drama.core.DramaUtil;
import com.drama.core.PropertiesUtil;
import com.drama.dao.DramaInfoMapper;
import com.drama.pojo.DramaInfo;
import com.drama.service.DramaWebService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.ByteStreams;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

@Service(value = "dramaWebService")
@Slf4j
public class DramaWebServiceImpl implements DramaWebService {

    @Resource
    private DramaInfoMapper dramaInfoMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void saveDrama(DramaInfo info, HttpServletRequest request) {

        if (Objects.nonNull(info.getId())) {
            info.setUpdateTime(new Date()).setUpdateIp(DramaUtil.getIPAddress(request));

            uploadFile(info, (MultipartHttpServletRequest) request);

            dramaInfoMapper.updateSelective(info);

            return;
        }

        info.setId(DramaUtil.generateUUID()).setCreateTime(new Date()).setSetIp(DramaUtil.getIPAddress(request));

        uploadFile(info, (MultipartHttpServletRequest) request);


        dramaInfoMapper.insertSelective(info);
    }

    private DramaInfo uploadFile(DramaInfo info, MultipartHttpServletRequest request) {
        MultipartFile uploadFile = request.getFile("picture");
        if (Objects.isNull(uploadFile))
            return info;
        InputStream is = null;
        OutputStream os = null;
        try {
            String uploadPath = PropertiesUtil.getConfiguraionProperty("upload.url", null);
            File dir = new File(uploadPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String fileName = new StringBuilder(info.getId().toString()).append("_").append(uploadFile.getOriginalFilename()).toString();
            File file = new File(new StringBuilder(uploadPath).append("/").append(fileName).toString());
            is = uploadFile.getInputStream();
            os = new FileOutputStream(file);
            os.write(ByteStreams.toByteArray(is));
            info.setPictureUrl(new StringBuilder(PropertiesUtil.getConfiguraionProperty("upload.relative.url", null)).append("/").append(fileName).toString());
        } catch (IOException e) {
            log.error("上传图片失败:params={},e={}", JSONUtils.toJSONString(info), e);
        } finally {
            try {
                if (Objects.nonNull(is))
                    is.close();
                if (Objects.nonNull(os))
                    os.close();
            } catch (IOException e) {
                log.error("关闭文件流失败");
            }
        }

        return info;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void deleteDrama(Map<String, Object> params) {
        dramaInfoMapper.deleteByPrimaryKey(MapUtils.getLong(params, "id"));
    }

    @Override
    public Map<String, Object> queryDramaListData(Map<String, Object> params) {
        int rows = MapUtils.getInteger(params, "limit", 10), pageNumber = MapUtils.getInteger(params, "offset", 0) / rows + 1;
        Page page = PageHelper.startPage(pageNumber, rows, true);
        List<Map<String, Object>> list = Optional.ofNullable(dramaInfoMapper.queryDramaListData(params)).map(l -> {
            l.forEach(map -> map.put("picture_url", new StringBuilder(PropertiesUtil.getConfiguraionProperty("realm.name", null)).append(MapUtils.getString(map, "picture_url"))));
            return l;
        }).orElse(Lists.newArrayList());
        Map<String, Object> result = Maps.newHashMap();
        result.put("total", page.getTotal());
        result.put("rows", list);
        return result;
    }
}
