package com.openclassrooms.poseidonInc.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.openclassrooms.poseidonInc.nnk.domain.RuleName;
import com.openclassrooms.poseidonInc.nnk.repositories.RuleNameRepository;
import com.openclassrooms.poseidonInc.nnk.services.RuleNameService;

@ExtendWith(MockitoExtension.class)
public class RuleNameServiceTest {
	@InjectMocks
	RuleNameService ruleNameService;
	@Mock
	RuleNameRepository ruleNameRepository;
	
	@Test
	public void ruleNameCreateTest() {
		RuleName ruleName = new RuleName();
		ruleName.setId(1);
		given(ruleNameRepository.save(ruleName)).willReturn(ruleName);
		assertThat(ruleNameService.create(ruleName).getId()).isEqualTo(1);
	}
	
	@Test
	public void ruleNameDeleteTest() {
		RuleName ruleName = new RuleName();
		ruleName.setId(1);
		willDoNothing().given(ruleNameRepository).delete(ruleName);
		ruleNameService.delete(ruleName);
		verify(ruleNameRepository, times(1)).delete(ruleName);
	}
	
	@Test
	public void ruleNameFindAllTest() {
		List<RuleName> ruleNames = new ArrayList<RuleName>();
		ruleNames.add(new RuleName());
		given(ruleNameRepository.findAll()).willReturn(ruleNames);
		assertThat(ruleNameService.findAll().size()).isEqualTo(1);
	}
	
	@Test
	public void ruleNameUpdateTest() {
		RuleName ruleName = new RuleName();
		ruleName.setId(1);
		given(ruleNameRepository.save(ruleName)).willReturn(ruleName);
		assertThat(ruleNameService.update(ruleName).getId()).isEqualTo(1);
	}
	
	@Test
	public void ruleNameReadTest() {
		Optional<RuleName> ruleName = Optional.of(new RuleName());
		ruleName.get().setId(1);
		ruleName.get().setDescription("Test");
		given(ruleNameRepository.findById(1)).willReturn(ruleName);
		assertThat(ruleNameService.read(1).get().getDescription()).isEqualTo("Test");
	}
}
