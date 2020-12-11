package com.drama.dao;

import com.drama.pojo.DramaInfo;

public interface DramaInfoMapper {

    int insert(DramaInfo record);

    int insertSelective(DramaInfo record);
}