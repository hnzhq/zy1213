package com.situ.common;

/**
 * 存储公共变量的类
 * 
 * @author shenming
 *
 */
public final class Global {
	// 导包地址
	/*public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/employee1213?characterEncoding=UTF-8&useSSL=false&autoReconnect=true&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
	public static final String USER = "root";
	public static final String PASSWORD = "123456";*/
	// 上传文件目录
	public static final String UPLOAD = "d:/update";
	// 上传头像的目录
	public static final String UPLOAD_PICTURE = UPLOAD + "/image/picture";

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	/*
	public static Connection getConnection() {
	return JdbcUtil.getConnection(Global.DRIVER, Global.JDBC_URL, Global.USER, Global.PASSWORD);
	}*/
}
