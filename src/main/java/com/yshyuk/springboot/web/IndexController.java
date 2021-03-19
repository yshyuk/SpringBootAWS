package com.yshyuk.springboot.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yshyuk.springboot.config.auth.LoginUser;
import com.yshyuk.springboot.config.auth.dto.SessionUser;
import com.yshyuk.springboot.service.PostsService;
import com.yshyuk.springboot.web.DTO.PostsResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final PostsService postsService;
	private final HttpSession httpSession;
	
	@GetMapping("/")
	public String index(Model model, @LoginUser SessionUser user) {
		model.addAttribute("posts",postsService.findAllDesc());
		if(user!=null) {
			model.addAttribute("username", user.getName());
		}
		return "index";
	}
	
	@GetMapping("/posts/save")
	public String postsSave() {
		return "posts-save";
	}
	
	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model) {
		PostsResponseDto dto =postsService.findById(id);
		model.addAttribute("post",dto);
		return "posts-update";
	}
}
