package com.photo.database;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.thymeleaf.util.StringUtils;

@Configuration
public class DataSourceConfig {

	private static final Logger LOG = LoggerFactory.getLogger(DataSourceConfig.class);
	private static final String DATA_SOURCE_PREFIX = "spring.datasource";
	
	@Value("${flyway.installedBy}")
	private String flywayInstalledBy;
	
	@Autowired
	DataSource dataSource;
	
	/**
	 * @return Flyway bean
	 */
	@ConfigurationProperties(prefix = DATA_SOURCE_PREFIX)
	@Bean
	@Profile("default")
	Flyway createFlywayNonDev() {
		LOG.info("Creating flyway with default profile");
		return initialiseFlywayBean(false);
	}
	
	/**
	 * @return Flyway bean
	 */
	@ConfigurationProperties(prefix = DATA_SOURCE_PREFIX)
	@Bean
	@Profile("development")
	Flyway createFlywayDev() {
		LOG.info("Creating flyway with development profile");
		return initialiseFlywayBean(true);
	}
	
	/**
	 * @param allowClean
	 * @return
	 */
	private Flyway initialiseFlywayBean(boolean allowClean) {
		Flyway flyway = new Flyway();
		if(StringUtils.isEmpty(flywayInstalledBy)) {
			flyway.setInstalledBy(flywayInstalledBy);
		}
		flyway.setDataSource(dataSource);
		flyway.setOutOfOrder(true);
		flyway.setBaselineOnMigrate(true);
		if(allowClean) {
			LOG.info("Allow clean on Flyway DB");
			flyway.setCleanDisabled(false);
		}
		LOG.info("Flyway Migrate!");
		flyway.migrate();
		
		return flyway;
	}
}
