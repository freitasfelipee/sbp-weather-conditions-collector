package br.com.sbp.config.exception;

public class ConvertWeatherConditionsToWeatherConditionDbException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConvertWeatherConditionsToWeatherConditionDbException() {
		super("Failed to convert weatherConditions to WeatherConditionDb.");
	}
	
}