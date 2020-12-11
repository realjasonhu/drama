package com.drama.service;

import java.util.List;
import java.util.Map;

public interface DramaClientService {

    List<Map<String, Object>> queryDramaClientListData(Map<String, Object> params);
}
