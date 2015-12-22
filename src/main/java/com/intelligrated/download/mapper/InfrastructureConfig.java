package com.intelligrated.download.mapper;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Sets up Spring container & infrastructure components
 * like {@link DataSource}, {@link EntityManagerFactory} and {@link PlatformTransactionManager}.
 * This will be used by the configuration activating plain JPA-based repository configuration 
 * used in {@link ApplicationConfig}
 * 
 * @author matt.aspen
 */
@Configuration
@EnableTransactionManagement
public class InfrastructureConfig {

	/**
	 * Bootstraps in-memory H2 db.
	 * @return {@link DataSource}
	 */
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.H2).build();
	}
	
	/**
	 * Sets up {@link LocalContainerEntityManagerFactoryBean} to use
	 * Hibernate. Activates picking up of entities from project's base package.
	 * @return {@link LocalContainerEntityManagerFactoryBean}
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.H2);
		vendorAdapter.setGenerateDdl(true); // ~ hibernate.hbm2ddl.auto

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(getClass().getPackage().getName());
		factory.setDataSource(dataSource());

		return factory;
	}
	
	/**
	 * Service provider interface, abstraction of transaction strategy.
	 * @return {@link PlatformTransactionManager}
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
