package com.bookStore.Util;

/**
 * 工具类判断查询条件是否为空
 * @author Administrator
 *
 */
public class StringUtil {

	public static boolean isNullOrEmpty(String str){
		return (str==null||"".equals(str))?true:false;
	}
}
