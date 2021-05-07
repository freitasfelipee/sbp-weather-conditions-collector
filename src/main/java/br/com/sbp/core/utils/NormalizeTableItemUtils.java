package br.com.sbp.core.utils;

public class NormalizeTableItemUtils {

	public static String execute(String line) {
		int begin = line.trim().indexOf("<b>");
		int end = line.trim().indexOf("</b>"); 
		return line.trim().substring(begin, end).replaceAll("[^\\d.]+","");
	}
	
}