package br.com.sbp.core.usecase;

import java.io.File;

import org.springframework.stereotype.Service;

import br.com.sbp.config.exception.RetrieveFilesException;
import br.com.sbp.core.gateway.WeatherConditionsGateway;
import br.com.sbp.core.model.WeatherConditions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ColectWeatherConditionsUseCaseImpl implements CollectWeatherConditionsUseCase {

	private final WeatherConditionsGateway weatherConditionsGateway;
	
	public void execute(String directory) {
		File[] files = this.retrieveFilesFromPath(directory);
		
		for (File file : files) {
			WeatherConditions weatherConditions = this.weatherConditionsGateway.parseToDomain(file);
			this.weatherConditionsGateway.save(weatherConditions);
			file.delete();
		}
	}

	private File[] retrieveFilesFromPath(String path) {
		try {
			
			File directory = new File(path);
			
			return directory.listFiles();
						
		} catch (Exception e) {
			log.error("Failed to list files. Details: " + e.getLocalizedMessage()); 
			throw new RetrieveFilesException();
		}
	}

}