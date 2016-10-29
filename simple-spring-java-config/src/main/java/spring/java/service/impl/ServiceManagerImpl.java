package spring.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.java.domain.BlogPost;
import spring.java.service.BlogPostService;
import spring.java.service.ServiceManager;

public class ServiceManagerImpl implements ServiceManager{

	@Autowired
	@Qualifier("MediumBlogPostService")
	private BlogPostService blogPostService;
	
	@Override
	public void sendBlogPost(BlogPost blogPost) {
		blogPostService.savePost(blogPost);				
	}

}
