package com.openclassrooms.poseidonInc.nnk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.poseidonInc.nnk.domain.CurvePoint;
import com.openclassrooms.poseidonInc.nnk.services.CurvePointService;

import jakarta.validation.Valid;

@Controller
public class CurveController {
    // TODO: Inject Curve Point service
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
        // TODO: check data valid and save to db, after saving return Curve list
    	if (!result.hasErrors()) {
    		curvePointService.create(curvePoint);
    		model.addAttribute("curvePoints",curvePointService.findAll());
    		return "redirect:/curvePoint/list";
    	}
    	
        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	CurvePoint curvepoint =  curvePointService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid CurvePoint Id:" + id));
    	model.addAttribute("curvePoint", curvepoint);
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Curve and return Curve list
    	curvePointService.update(curvePoint);
		model.addAttribute("curvePoints",curvePointService.findAll());
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
    	curvePointService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid CurvePoint Id:" + id));
    	curvePointService.delete(id);
		model.addAttribute("curvePoints",curvePointService.findAll());
        return "redirect:/curvePoint/list";
    }
}
