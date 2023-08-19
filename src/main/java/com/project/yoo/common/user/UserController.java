package com.project.yoo.common.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.Resource;

@Controller
public class UserController {

	@Resource
	UserService userService;

	@GetMapping("/loginPage")
	public String login(Model model) {
		String url = "common/login";

		return authenticationCheck(url);
	}

	@GetMapping("/public/join")
	public String joinPage() {
		String url = "common/join";

		return authenticationCheck(url);
	}

	@PostMapping("/public/join")
	public String join(@RequestParam String userEmail, @RequestParam String userPw, @RequestParam String userName) {
		userService.userRegistration(userEmail, userPw, userName);

		return "common/login";
	}

	public String authenticationCheck(String url) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || authentication.getName().equals("anonymousUser"))
			return url;

		return "common/mainPage";
	}

}
