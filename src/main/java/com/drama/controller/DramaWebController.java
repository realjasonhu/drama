package com.drama.controller;

import com.drama.core.ApiResponse;
import com.drama.core.DramaUtil;
import com.drama.pojo.DramaInfo;
import com.drama.service.DramaWebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
            log.error("web端查询数据出错，params={}，e={}", params, e);
            return ApiResponse.failed(ApiResponse.CODE_FAIL_DEFAULT, "系统繁忙，请稍后重试");
        }
    }

    @RequestMapping(value = "saveDrama")
    @ResponseBody
    public ApiResponse saveDrama(DramaInfo dramaInfo, HttpServletRequest request) {
        try {
            MultipartHttpServletRequest newRequest = (MultipartHttpServletRequest) request;
            /*newRequest.getFileNames().forEachRemaining(file -> {
                try {
                    newRequest.getFile(file).getInputStream()
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                }
            });*/
            dramaWebService.saveDrama(dramaInfo, DramaUtil.getIPAddress(request));
            return ApiResponse.success();
        } catch (Exception e) {
            log.error("保存数据出错，params={}，e={}", dramaInfo, e);
            return ApiResponse.failed(ApiResponse.CODE_FAIL_DEFAULT, e.getMessage());
        }
    }
}
