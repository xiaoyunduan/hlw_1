package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.Sms;

public interface SMSService {
    int addSMS(Sms sms);
    int deleteSMS(int SMSId);
    int updateSMS(Sms sms);
    Sms querySMS_1(int SMSId);
    ArrayList<Sms> querySMS_2(int userId);
    ArrayList<Sms> querySMS_3(int headId);
    
    ArrayList<Sms> queryALL();
}