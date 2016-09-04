package springmvc.java.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;

public class MediumBlogPostImpl implements BlogPostService{

	private static final Logger LOGGER=LoggerFactory.getLogger(MediumBlogPostImpl.class);
	
	@Override
	public void savePost(BlogPost blogPost) {
		// TODO Auto-generated method stub
		LOGGER.debug("MediumBlogPostImpl savePost is called....");
		
	}

	@Override
	public void saveAsDraft(BlogPost blogPost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePost(BlogPost blogPost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user, boolean draft) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogPost> listAllBlogPostByUserAndTitleLike(User user, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogPost findBlogPosById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
