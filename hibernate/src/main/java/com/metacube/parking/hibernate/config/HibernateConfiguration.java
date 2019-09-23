package com.metacube.parking.hibernate.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * 
 * @author Abhishek Bishnoi
 * This is Configuration file for Hibernate
 */
@PropertySource(value = { "classpath:application.properties" })
@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	@Autowired
	private Environment env;
	
	@Value("${db.driver}")
	private String driverClass;
	
	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String username;
	
	@Value("${db.password}")
	private String password;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	/**
	 * creating bean of data source
	 * @return DataSource
	 */
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url,username,password);
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}
	
	/**
	 * Creating Session Factory
	 * @return SessionFactoryObject
	 */
	@Bean
	//@Primary
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(getDataSource());
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		sessionFactoryBean.setPackagesToScan(new String[] {"com.metacube.parking.hibernate.model.pojo"});
		return sessionFactoryBean;
	}
	
	/**
	 * loading Properties files
	 * @return Properties
	 */
	public Properties hibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	
	/**
	 * Creating Bean of Hibernate Transaction Manager
	 * @param factory 
	 * @return HibernateTransactionManagaer
	 */
	@Bean
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory factory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(factory);
		return transactionManager;
	}
	
	 @Bean
	 @Primary
	 public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em 
	        = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(getDataSource());
	      em.setPackagesToScan(new String[] { "com.metacube.parking.hibernate.model.pojo" });
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(hibernateProperties());
	 
	      return em;
	   }
}
