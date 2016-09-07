package springmvc.java.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;

public interface BlogPostDAO extends CrudRepository<BlogPost, Long> {

	
	List<BlogPost> findAllBlogPostsByUserAndTitleContaining(User user,String title);
	List<BlogPost> findAllBlogPostsByUserAndDraft(User user,boolean draft);
}
