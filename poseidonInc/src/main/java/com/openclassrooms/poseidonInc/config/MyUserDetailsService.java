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
import org.springframework.stereotype.Service;

import com.openclassrooms.poseidonInc.nnk.domain.User;
import com.openclassrooms.poseidonInc.nnk.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;

	/**
	 * 	used to get user information
	 * 
	 * 	@param String username
	 * 
	 * 	@return UserDetails - the user informations
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userByUsername = userRepo.findByUsername(username);
		if (!userByUsername.isPresent()) {
			throw new UsernameNotFoundException("Invalid credentials!");
		}
		User user = userByUsername.get();
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
		return new MySecurityUser(user.getUsername(), user.getPassword(), true, true, true, true, grantedAuthorities, user.getUsername());
	}
}
