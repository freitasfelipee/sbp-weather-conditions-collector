package br.com.sbp.entrypoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.sbp.config.property.SbpConfig;
import lombok.extern.slf4j.Slf4j;

@Component
@EnableScheduling
@Slf4j
public class WeatherConditionsCollectorJob {

	@Autowired
	private WeatherConditionsCollectorFacade weatherConditionsCollectorFacade;
	@Autowired
	private SbpConfig sbpConfig;
	
	@Scheduled(cron = "${sbp.config.cronjob.time}")
	public void collect() {
		log.info("Executing new verification.."); 
		this.weatherConditionsCollectorFacade.collectWeatherConditions(this.sbpConfig.getDirectory());
	}
	
}