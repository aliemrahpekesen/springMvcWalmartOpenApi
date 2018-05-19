package com.aep.walmart.util;

/**
 * @author aliemrahpekesen
 */
public class DisplayUtil {
	public static String clearAndResize(String text, int maxLength) {
		String str = text.replace('"', ' ').replaceAll("&quot;", "");
		while (str.length() <= maxLength) {
			str += " " + str;
		}
		return str.substring(0, maxLength - 3) + "...";
	}
}
