package com.example.demo.service;



import java.util.List;

import com.example.demo.model.User;



public interface UserService {
    int add_user(User u);
    int delete_user(Integer id);
    int update_user(User u);
    User get_user(Integer id,String name,String email);
    List<User> get_users();
    Integer get_matchCount(User u);
    User get_userbyId(Integer i);

    //实现游客模式访问
    int no_name_login();

}
