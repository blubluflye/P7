package com.openclassrooms.poseidonInc.nnk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.poseidonInc.nnk.domain.RuleName;
import com.openclassrooms.poseidonInc.nnk.repositories.RuleNameRepository;

import jakarta.validation.Valid;

@Service
public class RuleNameService {
	
	@Autowired
	RuleNameRepository ruleNameRepository;

	public  List<RuleName> findAll() {
		return ruleNameRepository.findAll();
	}

	public  RuleName create(@Valid RuleName ruleName) {
		return ruleNameRepository.save(ruleName);
	}

	public  Optional<RuleName> findById(Integer id) {
		return ruleNameRepository.findById(id);
	}

	public RuleName update(@Valid RuleName ruleName) {
		return ruleNameRepository.save(ruleName);		
	}

	public void delete(Integer id) {
		ruleNameRepository.deleteById(id);
	}
	
	
}
