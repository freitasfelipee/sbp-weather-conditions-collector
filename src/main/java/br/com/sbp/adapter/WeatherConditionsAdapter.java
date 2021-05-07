package br.com.sbp.adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;

import br.com.sbp.config.exception.ConvertWeatherConditionsFileException;
import br.com.sbp.core.enums.WeatherConditionsEnum;
import br.com.sbp.core.model.WeatherConditions;
import br.com.sbp.core.utils.NormalizeDateTimeInformationUtils;
import br.com.sbp.core.utils.NormalizeTableItemUtils;
import br.com.sbp.dataprovider.database.entity.WeatherConditionsDb;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeatherConditionsAdapter {

	public static WeatherConditions toDomain(File file) {
		try {

			WeatherConditions weatherConditions = new WeatherConditions();
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			int count = 0;

			while ((line = reader.readLine()) != null) {
				if (count == WeatherConditionsEnum.DATE_TIME.getLineNumber())
					weatherConditions.setDatetime(NormalizeDateTimeInformationUtils.execute(line));
				
				if (count == WeatherConditionsEnum.TEMPERATURE.getLineNumber()) 
					weatherConditions.setTemperature(new BigDecimal(NormalizeTableItemUtils.execute(line)));
				
				if (count == WeatherConditionsEnum.DEW_POINT.getLineNumber()) 
					weatherConditions.setDewpoint(new BigDecimal(NormalizeTableItemUtils.execute(line)));
				
				if (count == WeatherConditionsEnum.HUMIDITY.getLineNumber()) 
					weatherConditions.setHumidity(new BigDecimal(NormalizeTableItemUtils.execute(line)));
				
				if (count == WeatherConditionsEnum.WIND_CHILL.getLineNumber()) 
					weatherConditions.setWindChill(new BigDecimal(NormalizeTableItemUtils.execute(line)));

				if (count == WeatherConditionsEnum.WIND.getLineNumber()) 
					weatherConditions.setWind(new BigDecimal(NormalizeTableItemUtils.execute(line)));
				
				if (count == WeatherConditionsEnum.THW_INDEX.getLineNumber()) 
					weatherConditions.setThwIndex(new BigDecimal(NormalizeTableItemUtils.execute(line)));
				
				if (count == WeatherConditionsEnum.BAROMETER.getLineNumber()) 
					weatherConditions.setBarometer(new BigDecimal(NormalizeTableItemUtils.execute(line)));
				
				if (count == WeatherConditionsEnum.HEAT_INDEX.getLineNumber()) 
					weatherConditions.setHeatIndex(new BigDecimal(NormalizeTableItemUtils.execute(line)));
				
				if (count == WeatherConditionsEnum.TODAY_RAIN.getLineNumber()) 
					weatherConditions.setTodayRain(new BigDecimal(NormalizeTableItemUtils.execute(line)));
				
				if (count == WeatherConditionsEnum.YEARLY_RAIN.getLineNumber()) 
					weatherConditions.setYearlyRain(new BigDecimal(NormalizeTableItemUtils.execute(line)));
				
				count++;
			}
			
			reader.close();
			
			return weatherConditions;
			
		} catch (Exception e) {
			log.error("Failed to convert file. Details: " + e.getLocalizedMessage()); 
			throw new ConvertWeatherConditionsFileException();
		}
	}

	public static WeatherConditionsDb toEntity(WeatherConditions weatherConditions) {
		try {
			return WeatherConditionsDb.builder()
									  .datetime(weatherConditions.getDatetime())
									  .temperature(weatherConditions.getTemperature())
									  .dewpoint(weatherConditions.getDewpoint())
									  .humidity(weatherConditions.getHumidity())
									  .windChill(weatherConditions.getWindChill())
									  .wind(weatherConditions.getWind())
									  .thwIndex(weatherConditions.getThwIndex())
									  .barometer(weatherConditions.getBarometer())
									  .heatIndex(weatherConditions.getHeatIndex())
									  .todayRain(weatherConditions.getTodayRain())
									  .yearlyRain(weatherConditions.getYearlyRain())
									 .build();
		} catch (Exception e) {
			log.error("Failed to convert weatherInfo to db object. Details: " + e.getLocalizedMessage()); 
			throw new ConvertWeatherConditionsFileException();
		}
	}
	
}