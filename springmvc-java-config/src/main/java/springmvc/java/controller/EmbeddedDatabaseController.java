package springmvc.java.controller;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class EmbeddedDatabaseController {

	private static final Logger LOGGER=LoggerFactory.getLogger(EmbeddedDatabaseController.class);
	
	@Autowired
	@Qualifier("embedded")
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/displayUsers")
	public void displayUsers() {
		
		jdbcTemplate=new JdbcTemplate(dataSource);
		List<Map<String,Object>> users=jdbcTemplate.queryForList("select * from user");
		LOGGER.info("asdasdasd");
		for(Map<String,Object> user:users){
			LOGGER.debug("USER:"+user);
		}
		

	}
}
