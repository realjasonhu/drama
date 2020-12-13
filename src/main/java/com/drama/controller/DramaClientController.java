package com.drama.controller;

import com.drama.core.ApiResponse;
import com.drama.service.DramaClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 客户端请求
 *
 * @author Hu JunJie
 * @date 2020/12/11 17:16
 * @since
 */
@RestController
@RequestMapping(value = "client")
public class DramaClientController {

    @Resource
    private DramaClientService dramaClientService;

    @RequestMapping(value = "queryDramaListData")
    public Object queryDramaListData(@RequestParam Map<String, Object> params) {
        try {
            List<Map<String, Object>> list = dramaClientService.queryDramaClientListData(params);
            return ApiResponse.success(list, "success");
        } catch (Exception e) {
            return ApiResponse.failed(ApiResponse.CODE_FAIL_DEFAULT, "系统繁忙，请稍后重试");
        }
    }
}
