package br.com.sbp.dataprovider.gateway;

import java.io.File;

import org.springframework.stereotype.Service;

import br.com.sbp.adapter.WeatherConditionsAdapter;
import br.com.sbp.core.gateway.WeatherConditionsGateway;
import br.com.sbp.core.model.WeatherConditions;
import br.com.sbp.dataprovider.database.entity.WeatherConditionsDb;
import br.com.sbp.dataprovider.database.repository.WeatherConditionsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherConditionsGatewayImpl implements WeatherConditionsGateway {

	private final WeatherConditionsRepository weatherConditionsRepository;
	
	@Override
	public WeatherConditions parseToDomain(File file) {
		return WeatherConditionsAdapter.toDomain(file);
	}

	@Override
	public void save(WeatherConditions weatherConditions) {
		WeatherConditionsDb weatherConditionsDb = WeatherConditionsAdapter.toEntity(weatherConditions);
		this.weatherConditionsRepository.save(weatherConditionsDb);
		log.info("File from " + weatherConditions.getDatetime() + " has saved successfully.");
	}
	
}