package com.upu.scan4tracking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

@Configuration
public class DozerConfig {
	@Bean
	public Mapper mapper() {
		//		final List<CustomConverter> customConverters = dozerBeanMapper.getCustomConverters();
		//		customConverters.add(new LocalDateToDateConverter())
		return DozerBeanMapperBuilder.buildDefault();
	}
}