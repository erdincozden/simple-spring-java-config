package springmvc.java.service;

import springmvc.java.domain.User;

public interface UserService {

	
	User findUserById(long id);
	User findUserByBlogPostsByUsername(String username);
}
