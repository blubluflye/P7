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

import com.openclassrooms.poseidonInc.nnk.domain.CurvePoint;
import com.openclassrooms.poseidonInc.nnk.services.CurvePointService;

import jakarta.validation.Valid;

@Controller
public class CurveController {

	@ModelAttribute
    private void userDetails(Model model, Principal p) {
    	model.addAttribute("username", p.getName());
    }
	
	@Autowired
	CurvePointService curvePointService;
	
    @RequestMapping("/curvePoint/list")
    public String home(Model model)
    {
    	model.addAttribute("curvePoints",curvePointService.findAll());
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint bid) {
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
    	if (!result.hasErrors()) {
    		curvePointService.create(curvePoint);
    		return "redirect:/curvePoint/list";
    	}
        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	CurvePoint curvepoint =  curvePointService.read(id).orElseThrow(() -> new IllegalArgumentException("Invalid CurvePoint Id:" + id));
    	model.addAttribute("curvePoint", curvepoint);
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                             BindingResult result, Model model) {
    	curvePointService.update(curvePoint);
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
    	CurvePoint curvePoint = curvePointService.read(id).orElseThrow(() -> new IllegalArgumentException("Invalid CurvePoint Id:" + id));
    	curvePointService.delete(curvePoint);
        return "redirect:/curvePoint/list";
    }
}
