package com.intelligrated.download.mapper;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.intelligrated.download.mapper.entity.MapperEntity;

@Configuration
@ComponentScan(basePackageClasses = MapperEntity.class)
@Import(InfrastructureConfig.class)
public class JpaConfig {

}
