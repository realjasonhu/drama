package com.drama.controller;

import com.drama.core.ApiResponse;
import com.drama.core.DramaUtil;
import com.drama.pojo.DramaInfo;
import com.drama.service.DramaWebService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "index")
    public String index() {
        return "drama/index";
    }

    @RequestMapping(value = "listIndex")
    public ModelAndView listIndex(@RequestParam Map<String, Object> params) {
        return new ModelAndView("drama/drama_list", params);
    }

    @RequestMapping(value = "queryDramaListData")
    @ResponseBody
    public Object queryDramaListData(@RequestParam Map<String, Object> params) {
        try {
            return dramaWebService.queryDramaListData(params);
        } catch (Exception e) {
            return ApiResponse.failed(ApiResponse.CODE_FAIL_DEFAULT, "系统繁忙，请稍后重试");
        }
    }

    @RequestMapping(value = "saveDrama")
    @ResponseBody
    public ApiResponse saveDrama(DramaInfo dramaInfo, HttpServletRequest request) {
        try {
            dramaWebService.saveDrama(dramaInfo, DramaUtil.getIPAddress(request));
            return ApiResponse.success();
        } catch (Exception e) {
            return ApiResponse.failed(ApiResponse.CODE_FAIL_DEFAULT, e.getMessage());
        }
    }
}
