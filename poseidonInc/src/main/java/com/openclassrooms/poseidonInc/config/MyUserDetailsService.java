package com.openclassrooms.poseidonInc.config;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.openclassrooms.poseidonInc.nnk.domain.User;
import com.openclassrooms.poseidonInc.nnk.repositories.UserRepository;

public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> userByUsername = userRepo.findByUsername(username);
		if (!userByUsername.isPresent()) {
			//throw
			throw new UsernameNotFoundException("Invalid credentials!");
		}
		User user = userByUsername.get();
		if(user == null || !user.getUsername().equals(username)) {
			//throw
			throw new UsernameNotFoundException("Invalid credentials!");
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		//add role as authority ( "ROLE_" + role from user ? to test)
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		return new MySecurityUser(user.getUsername(), user.getPassword(), true, true, true, true, grantedAuthorities, user.getUsername());
	}

}
