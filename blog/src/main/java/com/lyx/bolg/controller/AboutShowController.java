package com.lyx.bolg.controller;

import com.lyx.bolg.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by liuyixiang  2020-03-26 16:22
 */
@Controller
public class AboutShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("newblogs",this.blogService.listRecommendBlogTop(3));
        return "about";
    }


}
