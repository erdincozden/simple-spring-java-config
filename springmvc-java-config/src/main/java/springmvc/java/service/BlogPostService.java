package springmvc.java.service;

import java.util.List;



import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;

public interface BlogPostService {
	
	void savePost(BlogPost blogPost);
	void saveAsDraft(BlogPost blogPost);
	void deletePost(BlogPost blogPost);
	List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user,boolean draft);
	List<BlogPost> listAllBlogPostByUserAndTitleLike(User user,String title);
	BlogPost findBlogPosById(long id);

}
