package www.yunpan.com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * 日期操作工具类
 *
 * @version 1.0 2009-8-5
 * @author ltang
 * @history
 *
 */
public class DateUtils {
	/** 日期格式yyyyMMddHHmmss **/
	public static String FORMAT_TIME = "yyyyMMddHHmmss";
	public static String FORMAT_DATE = "yyyyMMdd";
	/** 日期格式 yyyy-MM-dd HH:mm:ss **/
	public static final String FORMAT_TIME_SHOW = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 将yyyyMMddHHmmss格式 格式化为yyyy-MM-dd
	 *
	 * @param date
	 *            yyyyMMddHHmmss格式
	 * @return yyyy-MM-dd
	 */
	public static String parseToDate(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 给定指定模式，指定日期字符串
	 *
	 * @param pattern
	 *            模式如(yyyyMMddHHmmss...)
	 * @param date
	 *            日期
	 * @return 解释后返回的日期对象
	 */
	public static Date parseDate(String pattern, String date) {
		if (StringUtils.isBlank(pattern) || StringUtils.isBlank(date))
			return null;
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(date);
		} catch (ParseException e) {
			return new Date();
		}
	}

	/**
	 * 给定指定模式，指定日期字符串
	 *
	 * @param pattern
	 *            模式如(yyyyMMddHHmmss...)
	 * @param date
	 *            日期
	 * @return 解释后返回的日期对象
	 */
	public static String parseDate(String pattern, Date date) {
		if (null == date || StringUtils.isBlank(pattern))
			return null;
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 将yyyyMMddHHmmss格式 格式化为HH:mm:ss
	 *
	 * @param date
	 *            yyyyMMddHHmmss格式的日期
	 * @return HH:mm:ss
	 */
	public static String parseToTimeHHmmss(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat fo = new SimpleDateFormat("HH:mm:ss");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 将yyyyMMddHHmm格式 格式化为HH:mm
	 *
	 * @param date
	 *            yyyyMMddHHmm格式
	 * @return HH:mm
	 */
	public static String parseToTimeHHMM(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat fo = new SimpleDateFormat("HH:mm");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 将yyyyMMddHHmmss格式 格式化为yyyy/MM/dd HH:mm:ss
	 *
	 * @param date
	 *            yyyyMMddHHmmss格式
	 * @return yyyy/MM/dd HH:mm:ss
	 */
	public static String parseToDateYYYYMMDDHHMMSS(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat fo = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 将yyyyMMddHHmmss格式 格式化为yyyy年MM月dd日
	 *
	 * @param date
	 *            yyyyMMddHHmmss格式
	 * @return yyyy/MM/dd HH:mm:ss
	 */
	public static String parseToDateYYYYMMDD(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		SimpleDateFormat format = null;
		if (date.length() > 8) {
			format = new SimpleDateFormat("yyyyMMddHHmmss");
		} else {
			format = new SimpleDateFormat("yyyyMMdd");
		}
		SimpleDateFormat fo = new SimpleDateFormat("yyyy年MM月dd日");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 返回默认时间格式 14位:yyyyMMddHHmmss
	 *
	 * @return
	 */
	public static String getCurrentDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(new Date());
	}

	/**
	 * 返回指定的时间格式
	 *
	 * @return
	 */
	public static String getCurrentDate(String parrten) {
		if (StringUtils.isBlank(parrten)) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(parrten);
		return format.format(new Date());
	}

	/**
	 * 日期比较，大于currDate，返回false
	 *
	 * @param format
	 *            日期字符串格式
	 * @param baseDate
	 *            被比较的日期
	 * @param compareDate
	 *            比较日期
	 * @return
	 */
	public static boolean before(String format, String baseDate,
			String compareDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			Date base = simpleDateFormat.parse(baseDate);
			Date compare = simpleDateFormat.parse(compareDate);
			return compare.before(base);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 根据格式得到 step时间间隔以后的时间字符串。
	 *
	 * @param format
	 * @param baseTime
	 *            基准时间
	 * @param step
	 *            以分钟为单位
	 * @return 返回的格式 为 format
	 */
	public static String getNextTime(String format, String baseTime, long step) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			Date base = simpleDateFormat.parse(baseTime);
			long nextTime = base.getTime() + step * 60 * 1000;
			Date newTime = new Date();
			newTime.setTime(nextTime);
			return simpleDateFormat.format(newTime);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 根据基准时间,得到新的时间
	 *
	 * @param baseDate
	 *            基准时间
	 * @param step
	 *            新时间间隔, 以分为单位
	 * @return
	 */
	public static Date getNextTime(Date baseDate, long step) {
		long nextTime = baseDate.getTime() + step * 60 * 1000;
		Date newDate = new Date();
		newDate.setTime(nextTime);
		return newDate;
	}

	/**
	 * 将yyyy-MM-dd格式 格式化为yyyyMMdd
	 *
	 * @param date
	 *            yyyy-MM-dd格式
	 * @return yyyyMMdd
	 */
	public static String parseToDateYYYYMMdd(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat fo = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss格式 格式化为yyyyMMddHHmmss
	 *
	 * @param date
	 *            yyyy-MM-dd HH:mm:ss格式
	 * @return yyyyMMddHHmmss
	 */
	public static String parseToDateYYYYMMddHHmmss(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 将yyyyMMdd格式 格式化为yyyy-MM-dd
	 *
	 * @param date
	 *            yyyy-MM-dd格式
	 * @return yyyy-MM-dd
	 */
	public static String parseToDate2(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 日期字符串格式转换通用方法
	 *
	 * @param date
	 *            要转换的值
	 * @param sourceFormate
	 *            源日期格式
	 * @param objectiveFormate
	 *            目标日期格式
	 * @return
	 */
	public static String parseToDate(String date, String sourceFormate,
			String objectiveFormate) {
		SimpleDateFormat format = new SimpleDateFormat(sourceFormate);
		SimpleDateFormat fo = new SimpleDateFormat(objectiveFormate);
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 得到前两个月的最后一天的日期和 前一个月的最后一天的日期(如果为<=0取默认的) 参数可选
	 *
	 * @param startMonth
	 *            (默认2)
	 * @param endMonth
	 *            (默认1)
	 * @param datePattern
	 *            日期格式(默认yyyy-MM-dd)
	 * @return key[startDate],key[endDate]
	 */
	public static Map<String, String> getDateForSet(Integer startMonth,
			Integer endMonth, String datePattern) {
		if (startMonth == null) {
			startMonth = -2;
		} else {
			startMonth = Integer.parseInt("-" + startMonth);
		}
		if (endMonth == null) {
			endMonth = -1;
		} else {
			endMonth = Integer.parseInt("-" + startMonth);
		}
		if (StringUtils.isBlank(datePattern)) {
			datePattern = "yyyy-MM-dd";
		}
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		Calendar start = Calendar.getInstance();
		start.add(Calendar.MONTH, startMonth);
		start.set(Calendar.DAY_OF_MONTH,
				start.getActualMaximum(Calendar.DAY_OF_MONTH));
		String startDate = format.format(start.getTime());
		Calendar end = Calendar.getInstance();
		end.add(Calendar.MONTH, endMonth);
		end.set(Calendar.DAY_OF_MONTH,
				end.getActualMaximum(Calendar.DAY_OF_MONTH));
		String endDate = format.format(end.getTime());
		Map<String, String> rs = new HashMap<String, String>(1);
		rs.put("startDate", startDate);
		rs.put("endDate", endDate);
		return rs;
	}

	/**
	 * 将yyyyMMddHHmmss格式 格式化为yyyy-MM-dd HH:mm:ss
	 *
	 * @param date
	 *            yyyyMMddHHmmss格式
	 * @return yyyy/MM/dd HH:mm:ss
	 */
	public static String parseToDateAD(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss格式 格式转化为yyyyMMddHHmmss
	 *
	 * @param FORMAT_TIME
	 * @param date
	 * @return
	 */
	public static String parseToDateS(String date) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat(FORMAT_TIME);
		try {
			Date date1 = format1.parse(date);
			return format2.format(date1);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 将yyyy-MM-dd格式 格式转化为yyyyMMdd
	 *
	 * @param FORMAT_DATE
	 * @param date
	 * @return
	 */
	public static String parseToDateSS(String date) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat(FORMAT_DATE);
		try {
			Date date1 = format1.parse(date);
			return format2.format(date1);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 取当前时间前一天和当前时间
	 *
	 */
	public static Map<String, String> getLastCurrDay() {
		String datePattern = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		Calendar calendarStart = Calendar.getInstance();
		calendarStart.add(Calendar.DATE, -1); // 得到前一天
		String startDate = format.format(calendarStart.getTime());
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.add(Calendar.DATE, 0); // 得到前一天
		String endDate = format.format(calendarEnd.getTime());
		Map<String, String> rs = new HashMap<String, String>(1);
		rs.put("startDate", startDate);
		rs.put("endDate", endDate);
		return rs;
	}

	/**
	 * 取当月第一天和当前时间
	 *
	 */
	public static Map<String, String> getFirstDayInMonth() {
		String datePattern = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		Calendar calendarStart = Calendar.getInstance();
		calendarStart.set(Calendar.DAY_OF_MONTH, 1); // 得到当月第一天
		String startDate = format.format(calendarStart.getTime());
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.add(Calendar.DATE, 0); // 得到当天日期
		String endDate = format.format(calendarEnd.getTime());
		Map<String, String> rs = new HashMap<String, String>(1);
		rs.put("startDate", startDate);
		rs.put("endDate", endDate);
		return rs;
	}

	/**
	 * 取当月第一天和当前时间
	 *
	 */
	public static Map<String, String> getFirstDayInMonth(String datePattern) {
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		Calendar calendarStart = Calendar.getInstance();
		calendarStart.set(Calendar.DAY_OF_MONTH, 1); // 得到当月第一天
		String startDate = format.format(calendarStart.getTime());
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.add(Calendar.DATE, 0); // 得到当天日期
		String endDate = format.format(calendarEnd.getTime());
		Map<String, String> rs = new HashMap<String, String>(1);
		rs.put("startDate", startDate);
		rs.put("endDate", endDate);
		return rs;
	}

	/**
	 * 根据基准时间加上天数,得到新的时间
	 *
	 * @param baseDate
	 *            基准时间
	 * @param days
	 *            天数
	 * @return
	 */
	public static Date addDays(Date baseDate, int days) {
		Calendar expiration = Calendar.getInstance();
		expiration.setTime(baseDate);
		expiration.add(Calendar.DAY_OF_MONTH, days);
		return expiration.getTime();
	}

	/**
	 * 根据基准时间加上月数,得到新的时间
	 *
	 * @param baseDate
	 *            基准时间
	 * @param days
	 *            月数
	 * @return
	 */
	public static Date addMonths(Date baseDate, int months) {
		Calendar expiration = Calendar.getInstance();
		expiration.setTime(baseDate);
		expiration.add(Calendar.MONTH, months);
		return expiration.getTime();
	}

	/**
	 * 返回两个日期相差的天数
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long getDistDates(Date startDate, Date endDate) {
		long totalDate = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		long timestart = calendar.getTimeInMillis();
		calendar.setTime(endDate);
		long timeend = calendar.getTimeInMillis();
		totalDate = (timeend - timestart) / (1000 * 60 * 60 * 24);
		return totalDate;
	}

	/**
	 * 接受YYYY-MM-DD的日期字符串参数,返回两个日期相差的天数
	 *
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public static long getDistDates(String start, String end)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse(start);
		Date endDate = sdf.parse(end);
		return getDistDates(startDate, endDate);
	}

	/**
	 * 接受yyyyMMddHHmmss的日期字符串参数,返回两个日期相差的毫秒数
	 *
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public static long getDistTimeInMillis(String start, String end)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date startDate = sdf.parse(start);
		Date endDate = sdf.parse(end);
		long totalDate = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		long timestart = calendar.getTimeInMillis();
		calendar.setTime(endDate);
		long timeend = calendar.getTimeInMillis();
		totalDate = (timeend - timestart);
		return totalDate;
	}

	public static boolean isInBetweenDate(Date date, Date startDate,
			Date endDate) {
		if (date == null || startDate == null || endDate == null) {
			return false;
		}
		long d = date.getTime();
		long s = startDate.getTime();
		long e = endDate.getTime();
		if (d > s && d < e) {
			return true;
		}
		return false;
	}
}
