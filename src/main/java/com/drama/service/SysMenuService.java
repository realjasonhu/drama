package com.drama.service;

import java.util.List;
import java.util.Map;

/**
 * @author Hu JunJie
 * @date 2020/12/15 18:50
 * @since
 */
public interface SysMenuService {

    List<Map<String, Object>> querySysMenuListData(Map<String, Object> params);
}
