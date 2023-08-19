package com.project.yoo.common.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String Main(Model model) {
		return "common/mainPage";
	}
	
	@GetMapping("/main")
	public String MainPage(Model model) {
		return "common/mainPage";
	}

}
