package com.drama.service.impl;


import com.drama.service.DramaClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "dramaClientService")
public class DramaClientServiceImpl implements DramaClientService {

    @Override
    public List<Map<String, Object>> queryDramaClientListData(Map<String, Object> params) {
        return null;
    }
}
