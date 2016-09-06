package springmvc.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.java.domain.BlogPost;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.UserService;

@Controller
public class BlogPostController {

	@Autowired
	private BlogPostService blogPostService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/saveBlogPost",method=RequestMethod.POST)
	public ModelAndView saveBlogPost(
			@RequestParam(value="title") String title,
			@RequestParam(value="content") String content,
			@RequestParam(value="draft",required=false) Boolean draft			
			){
		
		
		BlogPost blogPost=new BlogPost();
		blogPost.setTitle(title);
		blogPost.setContent(content);
		blogPost.setUser(userService.findUserById(1L));
		
		
		if(draft==true){
			blogPostService.saveAsDraft(blogPost);
		}else{
			blogPostService.savePost(blogPost);
		}
		
		return new ModelAndView("newblogpost","message","Blog Post is saved.");
	}
}
