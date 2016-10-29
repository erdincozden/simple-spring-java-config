package spring.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.java.domain.DataSource;

@Configuration
public class DBConfig {

	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setUrl("www.erdincozden.com");
		dataSource.setUsername("root");
		dataSource.setPassword("456123");
		return dataSource;
	}
}
