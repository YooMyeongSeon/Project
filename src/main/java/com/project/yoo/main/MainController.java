package com.project.yoo.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String Main() {
		return "main/mainPage";
	}
	
}
