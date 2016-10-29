package spring.java.config;



import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import spring.java.domain.BlogPost;
import spring.java.domain.DataSource;
import spring.java.service.BlogPostService;
import spring.java.service.EmailService;
import spring.java.service.ServiceManager;

public class MainApplication {
	public static final Logger LOGGER=LoggerFactory.getLogger(MainApplication.class);
	public static void main(String[] args) {
		
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfig.class);
		BlogPostService blogPostService=applicationContext.getBean("blogPostService",BlogPostService.class);
		BlogPost blogPost=new BlogPost();
		blogPost.setId(1L);
		blogPost.setTitle("Java Spring ");
		blogPost.setContent("Spring about starter");
		blogPost.setPublishDate(new Date());
		blogPost.setDraft(true);
		blogPostService.savePost(blogPost);
		
		DataSource dataSource=applicationContext.getBean("dataSource",DataSource.class);
		LOGGER.debug("URL:"+dataSource.getUrl()+" username:"+dataSource.getUsername()+" password:"+dataSource.getPassword());
		EmailService emailService=applicationContext.getBean(EmailService.class);
		emailService.sendEmail();
		
		
		System.out.println("---------------------------");
		
		ServiceManager serviceManager= applicationContext.getBean(ServiceManager.class);
		serviceManager.sendBlogPost(blogPost);
		System.out.println("---------------------------");
		
		((ConfigurableApplicationContext)applicationContext).close();

	}

}
