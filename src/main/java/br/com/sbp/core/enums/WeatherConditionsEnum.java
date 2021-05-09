package br.com.sbp.core.enums;

import lombok.Getter;

@Getter
public enum WeatherConditionsEnum {

	DATE_TIME(14),
	TEMPERATURE(20),
	DEW_POINT(22),
	HUMIDITY(26),
	WIND_CHILL(28),
	WIND(32),
	THW_INDEX(34),
	BAROMETER(38),
	HEAT_INDEX(40),
	TODAY_RAIN(44),
	YEARLY_RAIN(46),
	SUNRISE_SUNSET(50);
	
	private int lineNumber;
	
	WeatherConditionsEnum(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
}