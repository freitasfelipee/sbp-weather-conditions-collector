package br.com.sbp.config.exception;

public class ConvertWeatherConditionsFileException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConvertWeatherConditionsFileException() {
		super("Failed to convert file.");
	}
	
}