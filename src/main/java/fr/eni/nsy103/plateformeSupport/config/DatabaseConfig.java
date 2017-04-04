package fr.eni.nsy103.plateformeSupport.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("fr.eni.nsy103.plateformeSupport.dao")
public class DatabaseConfig {

	@Resource
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl(ConfigProperties.DATABASE_URL);
		ds.setUsername(ConfigProperties.DATABASE_URL);
		ds.setPassword(ConfigProperties.DATABASE_PWD);
		return ds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManager() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource());
		entityManager.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManager.setPackagesToScan();
		entityManager.setJpaProperties(this.hibernateProperties());
		return entityManager;
	}
	
	private Properties hibernateProperties() {
		Properties props = new Properties();
		props.setProperty(ConfigProperties.SQL_DIALECT, env.getProperty(ConfigProperties.SQL_DIALECT));
		props.setProperty(ConfigProperties.HIBERNATE_SHOW_SQL, env.getProperty(ConfigProperties.HIBERNATE_SHOW_SQL));
		return props;
	}
	
	@Bean
	public JpaTransactionManager txManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(this.entityManager().getObject());
		return txManager;
	}
}
