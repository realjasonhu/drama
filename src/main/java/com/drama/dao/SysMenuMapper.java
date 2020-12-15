package com.drama.dao;

import com.drama.pojo.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuMapper {

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<Map<String, Object>> querySysMenuListData(Map<String, Object> params);
}