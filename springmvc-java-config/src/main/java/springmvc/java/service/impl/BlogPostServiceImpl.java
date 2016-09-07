package springmvc.java.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import springmvc.java.dao.BlogPostDAO;
import springmvc.java.domain.BlogPost;

import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;


public class BlogPostServiceImpl implements BlogPostService{

	
	private static final Logger LOGGER=LoggerFactory.getLogger(BlogPostServiceImpl.class);
	
	@Autowired
	private BlogPostDAO blogPostDAO;
	
	@Override
	public void savePost(BlogPost blogPost) {		
		
		LOGGER.debug("BlogPostServiceImpl:savePost called.....");
		blogPost.setPublishDate(new Date());
		blogPostDAO.save(blogPost);
	}


	@Override
	public void saveAsDraft(BlogPost blogPost) {
		LOGGER.debug("BlogPostServiceImpl:savePost called.....");
		blogPost.setPublishDate(new Date());
		blogPost.setDraft(true);
		blogPostDAO.save(blogPost);
		
	}


	@Override
	public void deletePost(BlogPost blogPost) {
		blogPostDAO.delete(blogPost);		
	}


	@Override
	public List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user, boolean draft) {
		// TODO Auto-generated method stub
		return blogPostDAO.findAllBlogPostsByUserAndDraft(user, draft);
	}


	@Override
	public List<BlogPost> listAllBlogPostByUserAndTitleLike(User user, String title) {
		// TODO Auto-generated method stub
		return blogPostDAO.findAllBlogPostsByUserAndTitleContaining(user, title);
	}


	@Override
	public BlogPost findBlogPosById(long id) {
		// TODO Auto-generated method stub
	
		return blogPostDAO.findOne(id);
	}

}
