package com.situ.util;

public final class PaginateInfo {
	private static final Integer PAGENO = 1;
	private static final Integer PAGESIZE = 15;

	// 一次查询全部信息
	public static final PaginateInfo MAX_LIMIT = new PaginateInfo(PAGENO, Integer.MAX_VALUE);
	public static final PaginateInfo DEFAULT = new PaginateInfo(PAGENO, PAGESIZE);

	/*// 查询第几页的数据
	private Integer pageNo = 1;
	// 每一页多少行
	private Integer pageSize = 10;*/
	private Integer pageNo;// 当前第几页
	private Integer pageSize;// 每页显示多少条记录
	private Integer count;// 总记录数
	private Integer pages;// 总页数
	private Integer navItemCount = 5;// 导航页

	public PaginateInfo(Integer pageNo, Integer pageSize) {
		super();
		setPageNo(pageNo);
		setPageSize(pageSize);
	}

	public void setPageNo(Integer pageNo) {
		if (pageNo == null) {
			this.pageNo = PAGENO;
		} else {
			this.pageNo = pageNo < 1 ? 1 : pageNo;
		}
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize == null ? PAGESIZE : pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	// 从第几个位置开始查寻
	public Integer getoffset() {
		return (this.pageNo - 1) * this.pageSize;
	}

	// 查询多少条记录
	public Integer getlimit() {
		return getPageSize();
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;

		// 计算总页数
		this.pages = count / getPageSize();// 总页数
		if (count % getPageSize() > 0) {
			this.pages += 1;
		}
		// 修正当前页面，当进入尾页就不能再进入下一页
		if (this.pages > 0 && this.pageNo > pages) {
			this.pageNo = pages;
		}
	}

	public Integer getTotalPages() {
		return pages;
	}

	public Integer getNavItemCount() {
		return navItemCount;
	}

	public void setNavItemCount(Integer navItemCount) {
		this.navItemCount = navItemCount;
	}

	/**
	 * 导航页起始值
	 * 
	 * @return
	 */
	public int getNavItemStart() {
		int cnt = this.navItemCount / 2;
		int start = this.pageNo - cnt;
		if (start < 1) {
			start = 1;
		}
		return start;
	}

	/**
	 * 导航页结束值
	 * 
	 * @return
	 */
	public int getNavItemEnd() {
		int end = getNavItemStart() + navItemCount - 1;
		// System.out.println(end);
		if (end > this.pages) {
			end = this.pages;
		}
		return end;
	}

}
