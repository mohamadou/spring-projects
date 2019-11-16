package com.prestadak.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String mainHome() {
		return "main-home";
	}
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("studentName");
		model.addAttribute("studentName", name);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String processForm(@RequestParam("studentName") String name, Model model) {
		
		model.addAttribute("studentName", name);
		
		return "helloworld";
	}
}
