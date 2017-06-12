package com.bookStore.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理工具类
 * @author Administrator
 *
 */
public class DateUtil {
  private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  /**
   * 将字符串解析为Date对象
   * @param str
   * @return
   */
  public static Date parse(String str){
	  try {
		return sdf.parse(str);
	  } catch (ParseException e) {
		e.printStackTrace();
	  }
	  return null;
  }
  /**
   * 按指定字符串格式格式化为Date对象
   * @param date
   * @return
   */
  public static String dateFormat(Date date){
	  return sdf.format(date);
  }
}
