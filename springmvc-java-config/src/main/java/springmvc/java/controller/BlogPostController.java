package springmvc.java.controller;

import java.util.List;
import java.util.Locale;

import javax.jws.WebParam.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.UserService;

@Controller
public class BlogPostController {

	@Autowired
	private BlogPostService blogPostService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@RequestMapping(value="/saveBlogPost",method=RequestMethod.POST)
	public ModelAndView saveBlogPost(
			@RequestParam(value="title") String title,
			@RequestParam(value="content") String content,
			@RequestParam(value="draft",required=false) Boolean draft,
			Locale locale
			){
		
		
		BlogPost blogPost=new BlogPost();
		blogPost.setTitle(title);
		blogPost.setContent(content);
		blogPost.setUser(userService.findUserByBlogPostsByUsername("root"));
		
		
		if(draft==true){
			blogPostService.saveAsDraft(blogPost);
		}else{
			blogPostService.savePost(blogPost);
		}
		
		return new ModelAndView("newblogpost","message",messageSource.getMessage("blogpost.saved",null, locale));
	}
	
	
	@RequestMapping(value="blogposts",method=RequestMethod.GET)
	public ModelAndView blogPosts(){
		
		User user=userService.findUserByBlogPostsByUsername("root");
		
		List<BlogPost> blogPosts=user.getBlogPosts();
		boolean draft=false;
		//blogPosts=blogPostService.listAllBlogPostByUserAndDraftStatus(user, draft);
		
		return new ModelAndView("blogposts","blogposts",blogPosts);
		
	}
	
	@RequestMapping(value="draftblogposts",method=RequestMethod.GET)
	public ModelAndView draftBlogPosts(){
		User user=userService.findUserByBlogPostsByUsername("root");
		List<BlogPost> draftblogPosts=blogPostService.listAllBlogPostByUserAndDraftStatus(user, true);
		
		return new ModelAndView("blogposts","blogposts",draftblogPosts);
	}
	
	@RequestMapping(value="searchByTitle",method=RequestMethod.POST)
	public ModelAndView searchByTitle(@RequestParam("title") String title){
		User user=userService.findUserByBlogPostsByUsername("root");		
		List<BlogPost> draftblogPosts=blogPostService.listAllBlogPostByUserAndTitleLike(user, title);
		
		return new ModelAndView("blogposts","blogposts",draftblogPosts);
	}
	
	@RequestMapping(value="getBlogPostBy/{id}",method=RequestMethod.GET)
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody BlogPost getBlogPostBy(@PathVariable(value="id") long id){
			return blogPostService.findBlogPosById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
