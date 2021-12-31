package com.situ.model;

import java.util.List;

public class Depart {
	private Integer id;
	private Integer dapartId;
	private String name;
	private Integer staffNum;
	private List<Staff> staffs;// 部门里面的员工

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDapartId() {
		return dapartId;
	}

	public void setDapartId(Integer dapartId) {
		this.dapartId = dapartId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStaffNum() {
		return staffNum;
	}

	public void setStaffNum(Integer staffNum) {
		this.staffNum = staffNum;
	}

}
