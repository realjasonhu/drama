package com.drama.controller;

import com.drama.core.ApiResponse;
import com.drama.core.DramaUtil;
import com.drama.service.DramaWebService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Hu JunJie
 * @date 2020/12/11 17:16
 * @since
 */
@Controller
@RequestMapping(value = "web")
public class DramaWebController {

    @Resource
    private DramaWebService dramaWebService;

    @RequestMapping(value = "saveDrama")
    @ResponseBody
    public ApiResponse saveDrama(@RequestParam Map<String, Object> params, HttpServletRequest request) {
        try {
            dramaWebService.saveDrama(params, DramaUtil.getIPAddress(request));
            return ApiResponse.success();
        } catch (Exception e) {
            return ApiResponse.failed(ApiResponse.CODE_FAIL_DEFAULT, e.getMessage());
        }

    }
}
