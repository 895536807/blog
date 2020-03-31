package com.lyx.bolg.controller;

import com.lyx.bolg.pojo.Tag;
import com.lyx.bolg.service.BlogService;
import com.lyx.bolg.service.TagService;
import com.lyx.bolg.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by liuyixiang  2020-03-25 22:30
 */

@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String tags(@PageableDefault(size = 8,sort = {"updateTime"} ,direction = Sort.Direction.DESC) Pageable pageable,
                        Model model,@PathVariable Long id){
        List<Tag> tags = this.tagService.listTagTop(10000);
        if(id == -1)
            id = tags.get(0).getId();
        model.addAttribute("tags",tags);
        model.addAttribute("page",this.blogService.listBlog(id,pageable));
        model.addAttribute("activeTagId",id);
        return "tags";
    }


}
