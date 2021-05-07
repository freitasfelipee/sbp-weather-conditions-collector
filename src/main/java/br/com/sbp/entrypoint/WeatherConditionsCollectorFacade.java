package br.com.sbp.entrypoint;

import org.springframework.stereotype.Component;

import br.com.sbp.core.usecase.CollectWeatherConditionsUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WeatherConditionsCollectorFacade {

	private final CollectWeatherConditionsUseCase collectWeatherConditionsUseCase;
	
	public void collectWeatherConditions(String directory) {
		this.collectWeatherConditionsUseCase.execute(directory);
	}
	
}