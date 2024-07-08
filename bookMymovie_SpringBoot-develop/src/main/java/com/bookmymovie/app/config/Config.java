package com.bookmymovie.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

/**
 * @author Sidramesh.
 *
 */
@Configuration
public class Config {

	/*
	 * Configuration for email template.
	 */
	@Bean(name="emailConfigBean")
    public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration(ResourceLoader resourceLoader) {
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath("classpath:/templates/");
        return bean;
    }
    
}
