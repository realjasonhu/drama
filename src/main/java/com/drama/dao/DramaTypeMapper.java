package com.drama.dao;

import com.drama.pojo.DramaType;

public interface DramaTypeMapper {

    int insert(DramaType record);

    int insertSelective(DramaType record);
}