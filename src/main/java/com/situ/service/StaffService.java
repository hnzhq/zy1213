package com.situ.service;

import java.util.List;

import com.situ.model.Staff;
import com.situ.model.StaffSearchBean;

public interface StaffService {

	/**
	 * 返回所有
	 * 
	 * @return
	 */
	public List<Staff> findAll(StaffSearchBean ssb);

	public int deleteByIds(Integer[] ids);

	public boolean save(Staff staff);

	// 更具Id查数据
	public Staff findById(Integer id);

	// 修改商品信息
	public boolean update(Staff staff);

}
