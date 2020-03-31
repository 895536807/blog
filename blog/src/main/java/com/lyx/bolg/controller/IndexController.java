package com.lyx.bolg.controller;

import com.lyx.bolg.exception.NotFoundException;
import com.lyx.bolg.service.BlogService;
import com.lyx.bolg.service.TagService;
import com.lyx.bolg.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liuyixiang  2020-03-17 16:01
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, Model model){

        model.addAttribute("page",this.blogService.listBlog(pageable));
        model.addAttribute("types",this.typeService.listType(6));
        model.addAttribute("tags",this.tagService.listTagTop(10));
        model.addAttribute("recommendBlogs",this.blogService.listRecommendBlogTop(8));
        return "index";
    }


    @PostMapping("/search")
    public String search(@PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                         Model model, @RequestParam String query){
        model.addAttribute("page",this.blogService.listBlog("%" + query + "%",pageable));
        model.addAttribute("query",query);
        return "search";
    }


    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model){
        model.addAttribute("blog",this.blogService.getAndConvert(id));
        return "blog";
    }

    @GetMapping("/footer/newblog")
    public String newblogs(Model model){
        model.addAttribute("newblogs",this.blogService.listRecommendBlogTop(3));
        return "_fragments :: newblogList";
    }
}
