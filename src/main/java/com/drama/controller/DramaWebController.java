package com.drama.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.drama.core.ApiResponse;
import com.drama.core.DramaUtil;
import com.drama.pojo.DramaInfo;
import com.drama.service.DramaWebService;
import com.drama.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

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
            MultipartHttpServletRequest newRequest = (MultipartHttpServletRequest) request;
            newRequest.getFileNames().forEachRemaining(file -> {
                InputStream is = null;
                try {
                    is = newRequest.getFile(file).getInputStream();
                } catch (IOException e) {
                    log.error("上传图片失败:params={},e={}", JSONUtils.toJSONString(dramaInfo), e);
                } finally {
                    if (!Objects.isNull(is)) {
                        try {
                            is.close();
                        } catch (IOException e) {
                            log.error("关闭文件流失败");
                        }
                    }
                }
            });
            dramaWebService.saveDrama(dramaInfo, DramaUtil.getIPAddress(request));
            return ApiResponse.success();
        } catch (Exception e) {
            log.error("保存数据出错，params={}，e={}", dramaInfo, e);
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
