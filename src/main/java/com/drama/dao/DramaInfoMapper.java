package com.drama.dao;

import com.drama.pojo.DramaInfo;

import java.util.List;
import java.util.Map;

public interface DramaInfoMapper {

    int insert(DramaInfo record);

    int insertSelective(DramaInfo record);

    List<Map<String, Object>> queryDramaListData(Map<String, Object> params);
}