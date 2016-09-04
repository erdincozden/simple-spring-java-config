package springmvc.java.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jca.support.LocalConnectionFactoryBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;




@Configuration
public class ApplicationContext {

	private static final Logger LOGGER=LoggerFactory.getLogger(ApplicationContext.class);
	
	@Autowired
	private Environment environment;
	
	
	@Bean
	public DataSource dataSource(){
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		
		return dataSource;
	}
	
	@Bean(name="embedded")
	public DataSource dataSourceEmbedded(){
		LOGGER.info("asdasd");
		
		EmbeddedDatabaseBuilder builder=new EmbeddedDatabaseBuilder();
		EmbeddedDatabase embeddedDatabase=builder
												.setType(EmbeddedDatabaseType.HSQL)
												.addScript("dbschema.sql")
												.addScript("test-data.sql")
												.build();
		return embeddedDatabase;
	}
	
	@Bean
	public JpaVendorAdapter JpaVendorAdapter(){
		
		HibernateJpaVendorAdapter jpaVendorAdapter=new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		jpaVendorAdapter.setShowSql(true);	
		
		return jpaVendorAdapter; 
	}
	
	
	@Bean
	public JpaTransactionManager JpaTransactionManager(EntityManagerFactory entityManagerFactory){
		
		JpaTransactionManager jpaTransactionManager=new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		return jpaTransactionManager;
				
		
		
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		
		LocalContainerEntityManagerFactoryBean entityManagerFactory=new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaVendorAdapter(JpaVendorAdapter());
		entityManagerFactory.setPackagesToScan("springmvc.java.domain");
		
		Properties jpaProperties=new Properties();
		jpaProperties.setProperty("hibernate.hbm2dll.auto", "create-drop");
		
		entityManagerFactory.setJpaProperties(jpaProperties);
		
		return entityManagerFactory;
		
	}
	
	
	
	
	
	
}













