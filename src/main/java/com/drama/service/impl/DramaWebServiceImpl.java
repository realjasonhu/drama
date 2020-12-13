package com.drama.service.impl;

import com.drama.core.ApiResponse;
import com.drama.core.DramaUtil;
import com.drama.dao.DramaInfoMapper;
import com.drama.dao.DramaTitleMapper;
import com.drama.pojo.DramaInfo;
import com.drama.pojo.DramaTitle;
import com.drama.service.DramaWebService;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service(value = "dramaWebService")
public class DramaWebServiceImpl implements DramaWebService {

    @Resource
    private DramaInfoMapper dramaInfoMapper;

    @Resource
    private DramaTitleMapper dramaTitleMapper;

    @Override
    public void saveDrama(DramaInfo info, String ip) {
        info.setId(DramaUtil.generateUUID()).setCreateTime(new Date()).setSetIp(ip);
        dramaInfoMapper.insertSelective(info);

    }

    @Override
    public List<Map<String, Object>> queryDramaListData(Map<String, Object> params) {
        List<Map<String, Object>> list = dramaInfoMapper.queryDramaListData(params);
        list.forEach(map -> {
            map.put("id", MapUtils.getString(map, "id"));
        });
        return list;
    }
}
