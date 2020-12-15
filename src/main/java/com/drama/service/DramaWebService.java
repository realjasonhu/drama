package com.drama.service;

import com.drama.pojo.DramaInfo;

import java.util.List;
import java.util.Map;

public interface DramaWebService {

    void saveDrama(DramaInfo info, String ip);

    void deleteDrama(Map<String, Object> params);

    Map<String, Object> queryDramaListData(Map<String, Object> params);
}
