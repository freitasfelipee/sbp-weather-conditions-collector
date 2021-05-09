package br.com.sbp.core.utils;

public class NormalizeSunsetUtils {

	public static String execute(String line) {
		int begin = line.indexOf("Sunset:");
		return line.substring(begin).replace("Sunset:", "").trim();
	}
	
}