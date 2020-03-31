package com.lyx.bolg.service.impl;

import com.lyx.bolg.dao.TypeRepository;
import com.lyx.bolg.exception.NotFoundException;
import com.lyx.bolg.pojo.Tag;
import com.lyx.bolg.pojo.Type;
import com.lyx.bolg.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by liuyixiang  2020-03-18 21:03
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return this.typeRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return this.typeRepository.getOne(id);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return this.typeRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = this.typeRepository.getOne(id);
        if (t == null)
            throw new NotFoundException("不存在");
        BeanUtils.copyProperties(type,t);
        return this.typeRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        this.typeRepository.deleteById(id);
    }

    @Override
    public List<Type> listType(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable =PageRequest.of(0,size,sort);
        return this.typeRepository.findTop(pageable);
    }

    @Override
    public Type getTypeByName(String name) {
        return this.typeRepository.findByName(name);
    }

    @Override
    public List<Type> listType() {
        return this.typeRepository.findAll();
    }

}
