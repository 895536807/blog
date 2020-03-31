package com.lyx.bolg.controller;

import com.lyx.bolg.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by liuyixiang  2020-03-26 14:33
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archive(Model model){
        model.addAttribute("archiveMap",this.blogService.archiveBlog());
        model.addAttribute("blogCount",this.blogService.countBlog());
        model.addAttribute("newblogs",this.blogService.listRecommendBlogTop(3));
        return "archives";
    }


}
