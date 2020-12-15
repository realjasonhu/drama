package com.drama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 *
 * @author Hu JunJie
 * @date 2020/12/15 10:04
 * @since
 */
@Controller
public class DramaWebIndexController {

    @RequestMapping(value = "/")
    public String index() {
        return "drama/index";
    }
}
