package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Reportevent;

public interface ReportEventService {

	int add_reportEvent(Reportevent re);
	int add_reportEventbySelect(Reportevent re);
	int delete_reportEvent(Reportevent re);
	int update_reportEvent(Reportevent re,int i);
	Reportevent get_reportEvent(Reportevent re);
   List<Reportevent> get_reportEvent_2(Integer id);
   List<Reportevent> get_reportEvent_3(String email);
   List<Reportevent> getAllReport();
   
}
