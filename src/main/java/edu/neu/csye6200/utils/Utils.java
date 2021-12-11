package edu.neu.csye6200.utils;

import java.util.Date;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;
public class Utils {
	public static String addChar(String str, char ch, int position) {
	    StringBuilder sb = new StringBuilder(str);
	    sb.insert(position, ch);
	    return sb.toString();
	}
	public static long differenceDate(Date date) {
		LocalDateTime now = LocalDateTime.now();
		long diff = DAYS.between(now, (Temporal) date);
		return diff;
	}
}
