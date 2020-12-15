package com.drama.service.impl;

import com.drama.core.DramaUtil;
import com.drama.core.PropertiesUtil;
import com.drama.dao.DramaInfoMapper;
import com.drama.pojo.DramaInfo;
import com.drama.service.DramaWebService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service(value = "dramaWebService")
@Slf4j
public class DramaWebServiceImpl implements DramaWebService {

    @Resource
    private DramaInfoMapper dramaInfoMapper;

    @Override
    public void saveDrama(DramaInfo info, String ip) {
        info.setId(DramaUtil.generateUUID()).setCreateTime(new Date()).setSetIp(ip);
        dramaInfoMapper.insertSelective(info);

    }

    @Override
    public void deleteDrama(Map<String, Object> params) {
        dramaInfoMapper.deleteByPrimaryKey(MapUtils.getLong(params, "id"));
    }

    @Override
    public Map<String, Object> queryDramaListData(Map<String, Object> params) {
        int rows = MapUtils.getInteger(params, "limit", 10), pageNumber = MapUtils.getInteger(params, "offset", 0) / rows + 1;
        Page page = PageHelper.startPage(pageNumber, rows, true);
        List<Map<String, Object>> list = Optional.ofNullable(dramaInfoMapper.queryDramaListData(params)).map(l -> {
            l.forEach(map -> {

            });
            return l;
        }).orElse(Lists.newArrayList());
        Map<String, Object> result = Maps.newHashMap();
        result.put("total", page.getTotal());
        result.put("rows", list);
        return result;
    }
}
