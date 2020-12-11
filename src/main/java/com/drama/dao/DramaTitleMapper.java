package com.drama.dao;

import com.drama.pojo.DramaTitle;

public interface DramaTitleMapper {

    int insert(DramaTitle record);

    int insertSelective(DramaTitle record);
}