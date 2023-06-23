package com.upu.scan4tracking.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfig {
	@Bean
	public Mapper mapper() {
		return new DozerBeanMapper();
	}
}