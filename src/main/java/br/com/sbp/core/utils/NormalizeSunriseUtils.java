package br.com.sbp.core.utils;

public class NormalizeSunriseUtils {

	public static String execute(String line) {
		int begin = line.indexOf("Sunrise:");
		int end = line.indexOf("&nbsp");
		return line.substring(begin, end).replace("Sunrise:", "").trim();
	}
	
}