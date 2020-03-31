package com.lyx.bolg.service.impl;

import com.lyx.bolg.dao.TagRepository;
import com.lyx.bolg.exception.NotFoundException;
import com.lyx.bolg.pojo.Tag;
import com.lyx.bolg.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyixiang  2020-03-19 19:05
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return this.tagRepository.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return this.tagRepository.getOne(id);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return this.tagRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = this.tagRepository.getOne(id);
        if (t == null)
            throw new NotFoundException("不存在");
        BeanUtils.copyProperties(tag,t);
        return this.tagRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        this.tagRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Tag getTagByName(String name) {

        return this.tagRepository.findTagByName(name);
    }

    @Override
    public List<Tag> listTag() {
        return this.tagRepository.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {  // 1,2,3

        return this.tagRepository.findAllById(convertToList(ids));
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0,size,sort);
        return this.tagRepository.findTop(pageable);
    }

    private List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids !=null){
            String[] strings = ids.split(",");
            for (int i = 0 ;i < strings.length;i++){
                list.add(new Long(strings[i]));
            }
        }
        return list;
    }


}
