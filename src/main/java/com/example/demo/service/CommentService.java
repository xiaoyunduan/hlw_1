package com.example.demo.service;



import java.util.List;

import com.example.demo.model.Comment;
import com.example.demo.model.User;



public interface CommentService {
    int add_comment(Comment c);
    int delete_comment(Integer id);
    int update_comment(Integer id);
    Comment get_comment(Integer id);
    List<Comment> get_comments();
   

    //实现游客模式访问
    int no_name_login();

}
