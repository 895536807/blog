package com.lyx.bolg.service;

import com.lyx.bolg.pojo.Comment;

import java.util.List;

/**
 * Created by liuyixiang  2020-03-25 12:43
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long id);

    Comment saveComment(Comment comment);

}
