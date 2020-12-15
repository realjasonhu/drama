package com.drama.service.impl;

import com.drama.core.DramaUtil;
import com.drama.core.PropertiesUtil;
import com.drama.dao.DramaInfoMapper;
import com.drama.pojo.DramaInfo;
import com.drama.service.DramaWebService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
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
    public List<Map<String, Object>> queryDramaListData(Map<String, Object> params) {
        List<Map<String, Object>> list = Optional.ofNullable(dramaInfoMapper.queryDramaListData(params)).map(l -> {
            l.forEach(map -> {

            });
            return l;
        }).orElse(Lists.newArrayList());
        return list;
    }
}
