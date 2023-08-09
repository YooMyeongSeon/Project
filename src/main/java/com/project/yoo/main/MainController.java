package com.project.yoo.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String Main(Model model) {
		String msg = "Hello?";
		
		model.addAttribute("msg", msg);
		return "main/mainPage";
	}
	
}
