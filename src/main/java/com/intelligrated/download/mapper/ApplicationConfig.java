package com.intelligrated.download.mapper;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.intelligrated.download.mapper")
@EnableJpaRepositories
@Import(InfrastructureConfig.class)
public class ApplicationConfig {

}
