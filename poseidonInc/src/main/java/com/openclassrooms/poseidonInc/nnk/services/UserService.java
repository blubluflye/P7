package com.openclassrooms.poseidonInc.nnk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.poseidonInc.nnk.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
}
