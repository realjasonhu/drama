package com.drama.service;

import com.drama.pojo.DramaInfo;

import java.util.List;
import java.util.Map;

public interface DramaWebService {

    void saveDrama(DramaInfo info, String ip);

    List<Map<String, Object>> queryDramaListData(Map<String, Object> params);
}
