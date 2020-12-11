package com.drama.dao;

import com.drama.pojo.SysMenu;

public interface SysMenuMapper {

    int insert(SysMenu record);

    int insertSelective(SysMenu record);
}