package com.example.demo.service;



import java.util.List;

import com.example.demo.model.Addinfo;
import com.example.demo.model.User;



public interface AddInfoService {
    int add_user(Addinfo ai);
    int delete_user(Integer id);
    int update_user(Addinfo ai);
    Addinfo query_user(Integer id);

}
