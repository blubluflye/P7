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

import com.openclassrooms.poseidonInc.nnk.domain.Rating;
import com.openclassrooms.poseidonInc.nnk.services.RatingService;

import jakarta.validation.Valid;


@Controller
public class RatingController {
	
	@ModelAttribute
    private void userDetails(Model model, Principal p) {
    	model.addAttribute("username", p.getName());
    }
	
	@Autowired
	private RatingService ratingService;
	
    @RequestMapping("/rating/list")
    public String home(Model model)
    {
    	model.addAttribute("ratings",ratingService.findAll());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
    	if (!result.hasErrors()) {
    		ratingService.create(rating);
    		return "redirect:/rating/list";
    	}
        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	Rating rating = ratingService.read(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
    	model.addAttribute("rating", rating);
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {
    	ratingService.update(rating);
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
    	Rating rating = ratingService.read(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
    	ratingService.delete(rating);
        return "redirect:/rating/list";
    }
}
