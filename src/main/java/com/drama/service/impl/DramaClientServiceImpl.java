package com.drama.service.impl;


import com.drama.dao.DramaInfoMapper;
import com.drama.service.DramaClientService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service(value = "dramaClientService")
public class DramaClientServiceImpl implements DramaClientService {

    @Resource
    private DramaInfoMapper dramaInfoMapper;

    @Override
    public List<Map<String, Object>> queryDramaClientListData(Map<String, Object> params) {
        PageHelper.startPage(MapUtils.getInteger(params, "page", 1), MapUtils.getInteger(params, "rows", 20));
        List<Map<String, Object>> list = dramaInfoMapper.queryDramaListData(params);
        return list;
    }
}
