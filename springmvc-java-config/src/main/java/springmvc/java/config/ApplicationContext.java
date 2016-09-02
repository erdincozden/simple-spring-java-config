package springmvc.java.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;




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
}
