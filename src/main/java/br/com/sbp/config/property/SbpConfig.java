package br.com.sbp.config.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class SbpConfig {

	@Value("${sbp.config.directoryToBeRead}")
	private String directory;
	
}