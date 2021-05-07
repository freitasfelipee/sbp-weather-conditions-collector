package br.com.sbp.core.gateway;

import java.io.File;

import br.com.sbp.core.model.WeatherConditions;

public interface WeatherConditionsGateway {

	public WeatherConditions parseToDomain(File file);
	
	public void save(WeatherConditions weatherConditions);
	
}