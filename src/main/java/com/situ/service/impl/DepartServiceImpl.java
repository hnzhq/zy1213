package com.situ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.dao.DepartDao;
import com.situ.model.Depart;
import com.situ.service.DepartService;

@Service
public class DepartServiceImpl implements DepartService {
	@Autowired
	private DepartDao dao;

	@Override
	public List<Depart> findAll() {
		return dao.findAll();
	}

}
