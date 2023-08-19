package com.project.yoo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/* 스프링 시큐리티 설정 */
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.requestMatchers("/public/**", "/loginPage", "/css/**", "/js/**").permitAll().anyRequest().authenticated())
			.formLogin((formLogin) -> formLogin.loginPage("/loginPage").loginProcessingUrl("/login").permitAll())
			.logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/loginPage").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll());
		
		return http.build();
	}
	
	/* 스프링 시큐리티 패스워드 해시처리 설정 */
	@Bean
	protected BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
}