package com.gowtham.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gowtham.exception.ServiceException;
import com.gowtham.model.Article;
import com.gowtham.model.Category;
import com.gowtham.model.User;
import com.gowtham.service.ArticleService;
import com.gowtham.service.CategoryService;

@Controller
@RequestMapping("/showList")
public class ShowListController {

	@GetMapping
	public String showList(HttpSession session, ModelMap modelMap) {
		ArticleService articleService = new ArticleService();
		User user = (User)session.getAttribute("USER");
		try {
			List<Article> articleList = articleService.viewAllArticle(user);
			modelMap.addAttribute("ARTICLE_LIST", articleList);
		} catch (ServiceException e) {
			modelMap.addAttribute("SHOW_LIST_ERROR", e.getMessage());
			return "showList.jsp"; 
		}
		return "showList.jsp";
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
	
	
	
}
