package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import springmvc.java.domain.BlogPost;
import springmvc.java.service.BlogPostService;

public class MediumBlogPostImpl implements BlogPostService{

	private static final Logger LOGGER=LoggerFactory.getLogger(MediumBlogPostImpl.class);
	
	@Override
	public void savePost(BlogPost blogPost) {
		// TODO Auto-generated method stub
		LOGGER.debug("MediumBlogPostImpl savePost is called....");
		
	}

}
