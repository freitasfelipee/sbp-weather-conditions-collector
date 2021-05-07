package br.com.sbp.core.utils;

public class NormalizeDateTimeInformationUtils {

	public static String execute(String line) {
		int begin = line.indexOf("of");
		return line.substring(begin).replace("of:", "").trim();
	}
	
}