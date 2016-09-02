package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import springmvc.java.domain.BlogPost;
import springmvc.java.domain.DataSource;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.EmailService;

public class BlogPostServiceImpl implements BlogPostService{

	
	private static final Logger LOGGER=LoggerFactory.getLogger(BlogPostServiceImpl.class);
	
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private EmailService emailService;
	
	
	@Override
	public void savePost(BlogPost blogPost) {
		LOGGER.debug("BlogPostServiceImpl:savePost called.....");
		LOGGER.debug("BlogPostServiceImpl:savePost"+dataSource.getUrl());
		emailService.sendEmail();
		
	}

}
