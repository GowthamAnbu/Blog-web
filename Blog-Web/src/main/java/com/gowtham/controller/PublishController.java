package com.gowtham.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gowtham.exception.ServiceException;
import com.gowtham.model.Article;
import com.gowtham.model.Category;
import com.gowtham.model.CategoryDetail;
import com.gowtham.model.User;
import com.gowtham.service.ArticleService;
import com.gowtham.service.CategoryDetailService;
import com.gowtham.service.CategoryService;

@Controller
@RequestMapping("/publish")
public class PublishController {

	@GetMapping
	public String publish(HttpSession session, @RequestParam("name") String name,
			@RequestParam("content") String content,@RequestParam("categoryName")String categoryName,ModelMap modelMap) {
		CategoryDetailService categoryDetailService = new CategoryDetailService();
		ArticleService articleService = new ArticleService();
		CategoryService categoryService = new CategoryService();
		Article article = new Article();
		User user = (User)session.getAttribute("USER");
		article.setUser(user);
		article.setName(name);
		article.setContent(content);
		Category category = new Category();
		category.setName(categoryName);
		category.setUser(user);
		CategoryDetail categoryDetail = new CategoryDetail();
		categoryDetail.setArticle(article);
		categoryDetail.setCategory(category);
		try {
			articleService.publishSave(article);
			categoryService.addCategory(category);
			categoryDetailService.save(categoryDetail);
		} catch (ServiceException e) {
			modelMap.addAttribute("PUBLISH_ERROR", e.getMessage());
			return "publish.jsp";
		}
		return "redirect:/showList";
	}
}
