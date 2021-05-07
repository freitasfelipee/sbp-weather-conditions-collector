package br.com.sbp.dataprovider.database.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Builder
@Entity
@Data
public class WeatherConditionsDb implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "data")
	private String datetime;
	
	@Column(name = "temperature")
	private BigDecimal temperature;
	
	@Column(name = "dew_point")
	private BigDecimal dewpoint;
	
	@Column(name = "humidity")
	private BigDecimal humidity;
	
	@Column(name = "wind_chill")
	private BigDecimal windChill;
	
	@Column(name = "wind")
	private BigDecimal wind;
	
	@Column(name = "thw_index")
	private BigDecimal thwIndex;
	
	@Column(name = "barometer")
	private BigDecimal barometer;
	
	@Column(name = "heat_index")
	private BigDecimal heatIndex;
	
	@Column(name = "today_rain")
	private BigDecimal todayRain;
	
	@Column(name = "yearly_rain")
	private BigDecimal yearlyRain;
}