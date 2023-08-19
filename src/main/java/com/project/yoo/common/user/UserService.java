package com.project.yoo.common.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	/* 로그인 기능 */
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		nCommonUser user = userRepository.findByUserEmail(userEmail);
		
		if (user == null) {
            throw new UsernameNotFoundException("");
        }
		
		return new CustomUser(user);
	}
	
	/* 가입 기능 */
	@Transactional
	public void userRegistration(String userEmail, String userPw, String userName) {
		nCommonUser user = new nCommonUser();
		
		String encodedPassword = passwordEncoder.encode(userPw);
		Date date = new Date();
		
		user.setUserEmail(userEmail);
		user.setUserPw(encodedPassword);
		user.setUserName(userName);
		user.setUserRole("USER");
		user.setDel("1");
		user.setRegDate(date);
		user.setModDate(date);
		user.setLastAccessDate(date);
		
        userRepository.save(user);
	}
}
