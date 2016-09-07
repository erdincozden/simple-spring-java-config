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
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springmvc.java.service.BlogPostService;
import springmvc.java.service.impl.BlogPostServiceImpl;



@EnableJpaRepositories(basePackages={"springmvc.java.dao"})
@EnableTransactionManagement
@Configuration
public class ApplicationContext {

	private static final Logger LOGGER=LoggerFactory.getLogger(ApplicationContext.class);
	
	@Autowired
	private Environment environment;
	
	
	@Bean
	public DataSource dataSource(){
		LOGGER.info("GULSAH");
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("456123");
		
		return dataSource;
	}
	
	
	public DatabasePopulator databasePopulator(){
		
		ResourceDatabasePopulator databasePopulator=new ResourceDatabasePopulator();
		databasePopulator.setContinueOnError(true);
		databasePopulator.addScript(new ClassPathResource("test-data.sql"));
		return databasePopulator;
	}
	
	
	
	
	@Bean
	@Qualifier("embedded")
	public DataSource dataSourceEmbedded(){
		LOGGER.info("asdasd");
		LOGGER.info("GULSAH2");
		EmbeddedDatabaseBuilder builder=new EmbeddedDatabaseBuilder();
		EmbeddedDatabase embeddedDatabase=builder
												.setType(EmbeddedDatabaseType.HSQL)
												.addScript("dbschema.sql")
												.addScript("test-data.sql")
												.build();
		return embeddedDatabase;
	}
	
	@Bean
	public BlogPostService blogPostService(){
		
		return new BlogPostServiceImpl();
	}
	
	
	@Bean
	public JpaVendorAdapter JpaVendorAdapter(){
		
		HibernateJpaVendorAdapter jpaVendorAdapter=new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		jpaVendorAdapter.setShowSql(true);	
		
		return jpaVendorAdapter; 
	}
	
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){

		LOGGER.info("GULSAHt"+entityManagerFactory.getProperties().get("hibernate.hbm2dll.auto"));
		JpaTransactionManager jpaTransactionManager=new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		
		DatabasePopulatorUtils.execute(databasePopulator(), dataSource());
		return jpaTransactionManager;
				
		
		
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LOGGER.info("GULSAHzzz");
		LocalContainerEntityManagerFactoryBean entityManagerFactory=new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaVendorAdapter(JpaVendorAdapter());
		entityManagerFactory.setPackagesToScan("springmvc.java.domain");
		
		Properties jpaProperties=new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		
		entityManagerFactory.setJpaProperties(jpaProperties);
		
		return entityManagerFactory;
		
	}
	
	
	
	
	
	
}













