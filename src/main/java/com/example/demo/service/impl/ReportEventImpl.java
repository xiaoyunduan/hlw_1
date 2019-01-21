package com.example.demo.service.impl;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ReporteventMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.Reportevent;
import com.example.demo.service.ReportEventService;

@MapperScan("com.example.demo.dao")
@Service
public class ReportEventImpl implements ReportEventService{

		
	

	

	@Autowired
	private ReporteventMapper rem;

	@Override
	public List<Reportevent> getAllReport() {
		// TODO Auto-generated method stub
		return rem.selectAll();
	}
	@Override
	public int add_reportEventbySelect(Reportevent re) {
		// TODO Auto-generated method stub
		rem.insertSelective(re);
		return 1;
	}

	@Override
	public int add_reportEvent(Reportevent re) {
		// TODO Auto-generated method stub
		rem.insert(re);
		return 1;
	}

	@Override
	public int delete_reportEvent(Reportevent re) {
		// TODO Auto-generated method stub
		rem.deleteByPrimaryKey(re.getUserId());
		return 1;
	}

	@Override
	public int update_reportEvent(Reportevent re, int i) {
		
		// TODO Auto-generated method stub
		rem.updateByPrimaryKey(re);
		return 1;
	}

	@Override
	public Reportevent get_reportEvent(Reportevent re) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reportevent> get_reportEvent_2(Integer id) {
		// TODO Auto-generated method stub
		return rem.selectAllByUserId(id);
	}
	@Override
	public List<Reportevent> get_reportEvent_3(String email) {
		// TODO Auto-generated method stub
		return rem.selectAllByHeadEmail(email);
	}

	
	
	

}
