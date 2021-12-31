package com.situ.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ExceptionUtil {
	/**
	 * 返回一个异常的堆栈信息
	 * 
	 * @param ex
	 * @return
	 */
	public static String exceptionToString(Throwable ex) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ex.printStackTrace(new PrintStream(os));

		try {
			os.flush();
			os.close();
			return os.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
