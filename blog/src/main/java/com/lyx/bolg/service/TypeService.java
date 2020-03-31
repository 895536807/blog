package com.lyx.bolg.service;

import com.lyx.bolg.pojo.Tag;
import com.lyx.bolg.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by liuyixiang  2020-03-18 21:00
 */
public interface TypeService {


    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    Type updateType(Long id,Type type);

    void deleteType(Long id);

    List<Type> listType(Integer size);

    Type getTypeByName(String name);

    List<Type> listType();




}
