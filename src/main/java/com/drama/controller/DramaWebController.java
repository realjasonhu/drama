package com.drama.controller;

import com.drama.core.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Hu JunJie
 * @date 2020/12/11 17:16
 * @since
 */
@Controller
@RequestMapping(value = "web")
public class DramaWebController {

    @RequestMapping(value = "saveDrama")
    @ResponseBody
    public Object saveDrama() {

        return ApiResponse.success();
    }
}
