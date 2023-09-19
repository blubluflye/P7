package com.openclassrooms.poseidonInc.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MySecurityUser extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MySecurityUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,
			String firstName) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.firstname = firstName;
	}
	
	private String firstname;
	
	@Override
	public String toString() {
		return "MySecurityUser firstName=" + firstname + "] " + super.toString();
	}
}
