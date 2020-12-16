package com.drama.service;

import com.drama.pojo.DramaInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface DramaWebService {

    void saveDrama(DramaInfo info, HttpServletRequest request);

    void deleteDrama(Map<String, Object> params);

    Map<String, Object> queryDramaListData(Map<String, Object> params);
}
