package com.project.yoo.common.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUser implements UserDetails {

	private static final long serialVersionUID = -986129879391091985L;

	private nCommonUser user;
	
	public CustomUser(nCommonUser user) {
        this.user = user;
    }
	
	public int getUserNo() {
		return user.getUserNo();
	}
	
	@Override
	public String getUsername() {
		return user.getUserEmail();
	}
	
	@Override
	public String getPassword() {
		return user.getUserPw();
	}

	public String getUserRealName() {
		return user.getUserName();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		
		collect.add(new SimpleGrantedAuthority(user.getUserRole()));
		
		return collect;
	}
	
	public Date getRegDate() {
		return user.getRegDate();
	}
	
	public Date getModDate() {
		return user.getModDate();
	}
	
	public Date getLastAccessDate() {
		return user.getLastAccessDate();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		boolean enabled = true;
		
		if (user.getDel() == "0") enabled = false;
		
		return enabled;
	}
	
}
