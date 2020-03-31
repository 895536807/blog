package com.lyx.bolg.dao;

import com.lyx.bolg.pojo.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by liuyixiang  2020-03-19 19:06
 */
public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findTagByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);

}
