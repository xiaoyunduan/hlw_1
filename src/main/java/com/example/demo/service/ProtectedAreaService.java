package com.example.demo.service;

import com.example.demo.model.Protectedarea;

public interface ProtectedAreaService {

	int add_protectedArea(Protectedarea pa);
	int delete_protectedArea(Protectedarea pa);
	int update_protectedArea(Protectedarea pa);
	Protectedarea  get_protectedArea(Protectedarea pa);
}