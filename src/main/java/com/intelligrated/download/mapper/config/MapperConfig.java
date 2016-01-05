package com.intelligrated.download.mapper.config;

import javax.persistence.EntityManagerFactory;

import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.intelligrated.download.mapper.entity.MapperEntity;
import com.intelligrated.download.mapper.repo.MapperRepository;

@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "mapperEntityManager",
		transactionManagerRef = "mapperTransactionManager",
		basePackageClasses = { MapperEntity.class, MapperRepository.class })
public class MapperConfig {
	@Autowired(required = false)
	private PersistenceUnitManager persistenceUnitManager;

	@Bean(name="mapperJpaProperties")
	@ConfigurationProperties("app.mapper.jpa")
	public JpaProperties mapperJpaProperties() {
		return new JpaProperties();
	}

	@Bean(name="mapperDataSource") // have to name this one since there are multiple
	@ConfigurationProperties(prefix = "app.mapper.datasource")
	public DataSource mapperDataSource() {
		return (DataSource) DataSourceBuilder.create().type(DataSource.class).build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean mapperEntityManager(
			JpaProperties mapperJpaProperties) {
		EntityManagerFactoryBuilder builder = createEntityManagerFactoryBuilder(mapperJpaProperties);
		return builder
				.dataSource(mapperDataSource())
				.packages(MapperEntity.class)
				.persistenceUnit("mappers")
				.build();
	}

	@Bean
	public JpaTransactionManager mapperTransactionManager(EntityManagerFactory mapperEntityManager) {
		return new JpaTransactionManager(mapperEntityManager);
	}

	private EntityManagerFactoryBuilder createEntityManagerFactoryBuilder(JpaProperties customerJpaProperties) {
		JpaVendorAdapter jpaVendorAdapter = createJpaVendorAdapter(customerJpaProperties);
		
		return new EntityManagerFactoryBuilder(
				jpaVendorAdapter, customerJpaProperties.getProperties(), this.persistenceUnitManager);
	}

	private JpaVendorAdapter createJpaVendorAdapter(JpaProperties jpaProperties) {
		AbstractJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(jpaProperties.isShowSql());
		adapter.setDatabase(jpaProperties.getDatabase());
		adapter.setDatabasePlatform(jpaProperties.getDatabasePlatform());
		adapter.setGenerateDdl(jpaProperties.isGenerateDdl());
		return adapter;
	}
}
