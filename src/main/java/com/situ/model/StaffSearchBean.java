package com.situ.model;

import com.situ.util.DateRange;

public class StaffSearchBean extends Staff {
	private String birthdayRange;// 出生日期的时间范围
	// private PaginateInfo pi;
	private String start;
	private String end;

	public String getStart() {
		if (birthdayRange != null && birthdayRange.trim().length() != 0) {
			String[] date = birthdayRange.split(" - ");
			start = date[0];
			return start;

		}

		return null;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		if (birthdayRange != null && birthdayRange.trim().length() != 0) {
			String[] date = birthdayRange.split(" - ");
			end = date[1];
			return end;

		}
		return null;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public DateRange getBirthdayRange() {
		if (birthdayRange == null || birthdayRange.isEmpty()) {
			return null;
		}
		return DateRange.of(birthdayRange, " - ");
	}

	public void setBirthdayRange(String birthdayRange) {
		this.birthdayRange = birthdayRange;
	}

	/*public PaginateInfo getPi() {
		return pi;
	}
	
	public void setPi(PaginateInfo pi) {
		this.pi = pi;
	}*/

	/*public String getName() {
		return "%" + super.getName() + "%";
	}*/

}
