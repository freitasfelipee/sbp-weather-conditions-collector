package br.com.sbp.core.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherConditions {
	private String datetime;
	private BigDecimal temperature;
	private BigDecimal dewpoint;
	private BigDecimal humidity;
	private BigDecimal windChill;
	private BigDecimal wind;
	private String windDirection;
	private BigDecimal thwIndex;
	private BigDecimal barometer;
	private BigDecimal heatIndex;
	private BigDecimal todayRain;
	private BigDecimal yearlyRain;
	private String sunriseTime;
	private String sunsetTime;
}