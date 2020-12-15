package com.drama.service.impl;

import com.drama.dao.SysMenuMapper;
import com.drama.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Hu JunJie
 * @date 2020/12/15 18:50
 * @since
 */
@Service(value = "sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<Map<String, Object>> querySysMenuListData(Map<String, Object> params) {
        return sysMenuMapper.querySysMenuListData(params);
    }
}
