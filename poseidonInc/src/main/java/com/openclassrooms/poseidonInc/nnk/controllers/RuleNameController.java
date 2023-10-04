package com.openclassrooms.poseidonInc.nnk.controllers;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.poseidonInc.nnk.domain.RuleName;
import com.openclassrooms.poseidonInc.nnk.services.RuleNameService;

import jakarta.validation.Valid;


@Controller
public class RuleNameController {
	
	@ModelAttribute
    private void userDetails(Model model, Principal p) {
    	model.addAttribute("username", p.getName());
    }
	
	@Autowired
	RuleNameService ruleNameService;
	
    @RequestMapping("/ruleName/list")
    public String home(Model model)
    {
    	model.addAttribute("ruleNames", ruleNameService.findAll());
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
    	if (!result.hasErrors()) {
    		ruleNameService.create(ruleName);
    		return "redirect:/ruleName/list";
    	}
        return "ruleName/add";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	RuleName ruleName = ruleNameService.read(id).orElseThrow(() -> new IllegalArgumentException("Invalid ruleName Id:" + id));
    	model.addAttribute("ruleName", ruleName);
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
    	ruleNameService.update(ruleName);
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
    	ruleNameService.read(id).orElseThrow(() -> new IllegalArgumentException("Invalid ruleName Id:" + id));
    	ruleNameService.delete(id);
        return "redirect:/ruleName/list";
    }
}
