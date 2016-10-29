package spring.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spring.java.domain.BlogPost;
import spring.java.service.BlogPostService;

public class MediumBlogPostImpl implements BlogPostService{

	private static final Logger LOGGER=LoggerFactory.getLogger(MediumBlogPostImpl.class);
	
	@Override
	public void savePost(BlogPost blogPost) {
		LOGGER.debug("MediumBlogPostImpl savePost is called....");
		
	}

}