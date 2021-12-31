package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.Depart;

@Mapper
public interface DepartDao {
	public Depart findById(Integer id);

	public List<Depart> findAll();
}
