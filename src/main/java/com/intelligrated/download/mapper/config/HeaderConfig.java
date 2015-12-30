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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.intelligrated.download.mapper.entity.HeaderEntity;
import com.intelligrated.download.mapper.repo.HeaderRepository;

@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "headerEntityManager",
		transactionManagerRef = "headerTransactionManager",
		basePackageClasses = {HeaderEntity.class, HeaderRepository.class})
public class HeaderConfig {

	@Autowired(required = false)
	private PersistenceUnitManager persistenceUnitManager;

	@Bean
	@ConfigurationProperties("app.header.jpa")
	public JpaProperties headerJpaProperties() {
		return new JpaProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "app.header.datasource")
	public DataSource headerDataSource() {
		return (DataSource) DataSourceBuilder.create().type(DataSource.class).build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean headerEntityManager(
			JpaProperties headerJpaProperties) {
		EntityManagerFactoryBuilder builder = createEntityManagerFactoryBuilder(headerJpaProperties);
		return builder
				.dataSource(headerDataSource())
				.packages(HeaderEntity.class)
				.persistenceUnit("headers")
				.build();
	}

	@Bean
	@Primary
	public JpaTransactionManager headerTransactionManager(EntityManagerFactory headerEntityManager) {
		return new JpaTransactionManager(headerEntityManager);
	}

	private EntityManagerFactoryBuilder createEntityManagerFactoryBuilder(JpaProperties headerJpaProperties) {
		JpaVendorAdapter jpaVendorAdapter = createJpaVendorAdapter(headerJpaProperties);
		return new EntityManagerFactoryBuilder(
				jpaVendorAdapter, headerJpaProperties.getProperties(), this.persistenceUnitManager);
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
