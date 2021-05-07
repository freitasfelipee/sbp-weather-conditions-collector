package br.com.sbp.core.usecase;

@FunctionalInterface
public interface CollectWeatherConditionsUseCase {

	public void execute(String directory);
	
}