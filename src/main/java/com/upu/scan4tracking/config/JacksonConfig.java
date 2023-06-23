package com.upu.scan4tracking.config;

import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {
	@Bean
	public JSR310Module javaTimeModule() {
		return new JSR310Module();
	}
}