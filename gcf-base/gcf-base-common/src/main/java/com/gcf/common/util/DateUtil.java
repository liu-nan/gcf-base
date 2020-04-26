package com.gcf.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期类
 * @author Administrator
 *
 */
public class DateUtil {

	//类不能new
	private DateUtil() {
		
	}
	
	public static final String PATTERN_DATA_DEFAULT = "yyyy-MM-dd";
	public static final String PATTERN_DATATIME_DEFAULT = "yyyy-MM-dd HH:mm:ss";
	
	private static final SimpleDateFormat createSimpleDateFormat(String pattern) {
		return new SimpleDateFormat(pattern);
	}
	
	public static final String convertDate(Date date) {
		return createSimpleDateFormat(PATTERN_DATA_DEFAULT).format(date);
	}
	public static final String convertDateTime(Date date) {
		return createSimpleDateFormat(PATTERN_DATATIME_DEFAULT).format(date);
	}
}
