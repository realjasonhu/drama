package com.drama.controller;

import com.alibaba.fastjson.JSON;
import com.drama.core.ApiResponse;
import com.drama.pojo.DramaInfo;
import com.drama.service.DramaWebService;
import com.drama.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class DramaWebController {

    @Resource
    private DramaWebService dramaWebService;

    @Resource
    private SysMenuService sysMenuService;

    @RequestMapping(value = "listIndex")
    public ModelAndView listIndex(@RequestParam Map<String, Object> params) {
        params.put("menuList", sysMenuService.querySysMenuListData(null));
        return new ModelAndView("drama/drama_list", params);
    }

    @RequestMapping(value = "queryDramaListData")
    @ResponseBody
    public Object queryDramaListData(@RequestParam Map<String, Object> params) {
        try {
            return dramaWebService.queryDramaListData(params);
        } catch (Exception e) {
            log.error("web端查询数据出错，params={}，e={}", params, e);
            return ApiResponse.failed(ApiResponse.CODE_FAIL_DEFAULT, "系统繁忙，请稍后重试");
        }
    }

    @RequestMapping(value = "saveDrama")
    @ResponseBody
    public ApiResponse saveDrama(DramaInfo dramaInfo, HttpServletRequest request) {
        try {
            dramaWebService.saveDrama(dramaInfo, request);
            return ApiResponse.success();
        } catch (Exception e) {
            log.error("保存数据出错，params={}，e={}", JSON.toJSONString(dramaInfo), e);
            return ApiResponse.failed(ApiResponse.CODE_FAIL_DEFAULT, e.getMessage());
        }
    }

    @RequestMapping(value = "deleteDrama")
    @ResponseBody
    public ApiResponse deleteDrama(@RequestParam Map<String, Object> params) {
        try {
            dramaWebService.deleteDrama(params);
            return ApiResponse.success();
        } catch (Exception e) {
            log.error("保存数据出错，params={}，e={}", params, e);
            return ApiResponse.failed(ApiResponse.CODE_FAIL_DEFAULT, e.getMessage());
        }
    }
}
