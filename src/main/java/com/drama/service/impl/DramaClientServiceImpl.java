package com.drama.service.impl;


import com.drama.core.PropertiesUtil;
import com.drama.dao.DramaInfoMapper;
import com.drama.service.DramaClientService;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service(value = "dramaClientService")
public class DramaClientServiceImpl implements DramaClientService {

    @Resource
    private DramaInfoMapper dramaInfoMapper;

    @Override
    public List<Map<String, Object>> queryDramaClientListData(Map<String, Object> params) {
        List<Map<String, Object>> list = Optional.ofNullable(dramaInfoMapper.queryDramaListData(params)).map(l -> {
            l.forEach(map -> {
                String pictureUrl = MapUtils.getString(map, "picture_url");
                if (StringUtils.isNotEmpty(pictureUrl))
                    map.put("picture_url", new StringBuilder(PropertiesUtil.getConfiguraionProperty("realm.name", null)).append(pictureUrl).toString());
            });
            return l;
        }).orElse(Lists.newArrayList());
        return list;
    }
}
