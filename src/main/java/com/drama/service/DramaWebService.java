package com.drama.service;

import java.util.List;
import java.util.Map;

public interface DramaWebService {

    void saveDrama(Map<String, Object> params, String ip);

    List<Map<String, Object>> queryDramaListData(Map<String, Object> params);
}
