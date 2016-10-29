package spring.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spring.java.domain.BlogPost;
import spring.java.service.BlogPostService;

public class BlogPostServiceImpl implements BlogPostService{

	public static final Logger LOGGER=LoggerFactory.getLogger(BlogPostService.class);
	
	@Override
	public void savePost(BlogPost blogPost) {
		LOGGER.debug("BlogPostServiceImpl:savePost() is called");
	}

}
