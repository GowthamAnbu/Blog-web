package com.gowtham.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gowtham.dao.UserDAO;
import com.gowtham.exception.ServiceException;
import com.gowtham.model.Article;
import com.gowtham.model.Category;
import com.gowtham.model.User;
import com.gowtham.service.ArticleService;
import com.gowtham.service.CategoryService;
import com.gowtham.service.UserService;

@Controller
@RequestMapping("/showList")
public class ShowListController {

	@GetMapping
	public String showList(HttpSession session, ModelMap modelMap) {
		ArticleService articleService = new ArticleService();
		UserService userService = new UserService();
		User user = (User)session.getAttribute("USER");
		int roleId=userService.getRole(user.getId());
		try {
			List<Article> articleList = articleService.viewAllArticle(user);
			modelMap.addAttribute("ARTICLE_LIST", articleList);
			if(roleId==1){
				List<User> userList=userService.forAdmin();
				modelMap.addAttribute("VIEW_USERS", userList);
				return "admin.jsp";
			}
		} catch (ServiceException e) {
			modelMap.addAttribute("SHOW_LIST_ERROR", e.getMessage());
			return "showList.jsp?roleId="+roleId; 
		}
		return "showList.jsp?roleId="+roleId;
	}

	@GetMapping("/update")
	public String update(@RequestParam("articleId") Integer id, @RequestParam("title") String title,
			@RequestParam("content") String content, ModelMap modelMap) {
		ArticleService articleService = new ArticleService();
		Article article = new Article();
		article.setId(id);
		article.setName(title);
		article.setContent(content);
		try {
			articleService.updateArticle(article);
		} catch (ServiceException e) {
			modelMap.addAttribute("UPDATE_ERROR", e.getMessage());
		}
		return "/showList";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Integer id, @RequestParam("userId") Integer userId) {
		ArticleService articleService = new ArticleService();
		articleService.delete(id);
		return "/showList";
	}
	
	@GetMapping("/viewAll")
	public String viewAll(ModelMap modelMap,HttpSession session) {
		ArticleService articleService = new ArticleService();
		try {
			CategoryService categoryService = new CategoryService();
			User user=(User) session.getAttribute("USER");
			List<Article> articleList = articleService.viewAllArticle();
			List<Category> categoryList=categoryService.getCategory(user.getId());
			modelMap.addAttribute("VIEW_ALL", articleList);
			modelMap.addAttribute("CATEGORY_VIEW", categoryList);
		} catch (ServiceException e) {
			modelMap.addAttribute("VIEW_ALL_ERROR", e.getMessage());
			return "../viewAll.jsp"; 
		}
		return "../viewAll.jsp";
	}
	
	@GetMapping("/viewByCategory")
	public String viewByCategory(ModelMap modelMap,HttpSession session,@RequestParam("category")String categoryName) {
			CategoryService categoryService = new CategoryService();
			User user=(User) session.getAttribute("USER");
			List<Category> categoryList=categoryService.getCategory(user.getId());
			List<Article> articleList=categoryService.listByCategory(categoryName);
			modelMap.addAttribute("VIEW_ALL", articleList); 
			modelMap.addAttribute("CATEGORY_VIEW", categoryList);
		return "../viewAll.jsp";
	}
	
	@GetMapping("/change")
	public String change(ModelMap modelMap,@RequestParam("id")String id,@RequestParam("roleId")String roleId){
		UserService userService = new UserService();
		userService.change(Integer.parseInt(id), Integer.parseInt(roleId));
		List<User> userList=userService.forAdmin();
		modelMap.addAttribute("VIEW_USERS", userList);
		return "../admin.jsp";
	}
}
