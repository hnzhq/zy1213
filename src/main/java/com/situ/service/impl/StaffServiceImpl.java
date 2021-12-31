package com.situ.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.situ.dao.StaffDao;
import com.situ.model.Staff;
import com.situ.model.StaffSearchBean;
import com.situ.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
	// 定义一个日志记录器
	private static final Log LOGGER = LogFactory.getLog(StaffServiceImpl.class);

	// 自动按类型匹配
	private StaffDao dao;

	public StaffServiceImpl(StaffDao dao) {
		super();
		this.dao = dao;
	}

	/**
	 * 返回所有学生
	 * 
	 * @return
	 */
	public List<Staff> findAll(StaffSearchBean ssb) {
		// 记录一共花了多少时间
		// long start = System.currentTimeMillis();

		// 输出日志
		// LOGGER.trace(ssb);
		// LOGGER.info("检测到查询全体");
		List<Staff> staff = dao.findAll(ssb);
		// long end = System.currentTimeMillis() - start;
		// LOGGER.info("查询操作结束,用时:" + end);
		return staff;
		// return dao.findAll(ssb);
	}

	public int deleteByIds(Integer[] ids) {
		return dao.deleteByIds(ids);
	}

	public boolean save(Staff staff) {
		return dao.save(staff) > 0;
	}

	// 更具Id查数据
	public Staff findById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		return dao.findById(map);
	}

	// 修改商品信息
	public boolean update(Staff staff) {
		return dao.update(staff) > 0;
	}
}
