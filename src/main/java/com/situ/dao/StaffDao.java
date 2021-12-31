package com.situ.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.situ.model.Staff;
import com.situ.model.StaffSearchBean;

@Mapper
public interface StaffDao {
	// private BeanListHandler<Staff> handler = new BeanListHandler<>(Staff.class);

	public List<Staff> findAll(StaffSearchBean ssb);

	/**
	 * 根据编号唯一查询
	 */
	public Staff findById(Map<String, Object> map);

	public int deleteByIds(@Param(value = "ids") Integer[] ids);

	/**
	 * 添加
	 */
	public int save(Staff staff);

	/**
	 * 修改
	 */
	public int update(Staff staff);

}
