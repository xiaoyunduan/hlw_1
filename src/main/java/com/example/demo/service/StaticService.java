package com.example.demo.service;

import java.awt.List;
import java.util.ArrayList;

import com.example.demo.model.Statistics;

public interface StaticService {

ArrayList<Statistics> querySMS();
ArrayList<Statistics> queryEmail();
}
