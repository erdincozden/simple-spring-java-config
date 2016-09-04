package springmvc.java.dao;

import org.springframework.data.repository.CrudRepository;

import springmvc.java.domain.BlogPost;

public interface BlogPostDAO extends CrudRepository<BlogPost, Long> {

	
	
}
