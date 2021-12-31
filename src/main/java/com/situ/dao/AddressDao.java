package com.situ.dao;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.Address;

@Mapper
public interface AddressDao {
	// 根据id查询
	public Address findById(Integer id);
}
