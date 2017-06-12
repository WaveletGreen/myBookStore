package com.bookStore.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bookStoreUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 判断字符串的有效性，检查传入的字符串是否为空或null
	 * 
	 * @param str
	 *            需要检查的字符串
	 * @return 如果为空或null，则返回false，否则返回true
	 */
	public static boolean checkStringValidate(String str) {
		return !str.isEmpty() || str != null;
	}

	public static boolean checkObjectValidate(Object obj) {
		return obj != null;
	}

	/**
	 * 将字符串解析为Date对象
	 * 
	 * @param str
	 *            需要转换的字符串
	 * @return 返回成功转换的日期
	 */
	public static Date parse(String str) {
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 按指定字符串格式格式化为Date对象
	 * 
	 * @param date
	 *            需要转换的日期时间
	 * @return 返回转换后的字符串
	 */
	public static String dateFormat(Date date) {
		return sdf.format(date);
	}
}
