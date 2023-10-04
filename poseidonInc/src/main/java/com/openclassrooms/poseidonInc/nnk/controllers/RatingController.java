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
    	model.addAttribute("ratings",ratingService.getAll());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Rating list
    	if (!result.hasErrors()) {
    		ratingService.create(rating);
    		return "redirect:/rating/list";
    	}
        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Rating by Id and to model then show to the form
    	Rating rating = ratingService.read(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
    	model.addAttribute("rating", rating);
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Rating and return Rating list
    	ratingService.update(rating);
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Rating by Id and delete the Rating, return to Rating list
    	ratingService.read(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
    	ratingService.delete(id);
        return "redirect:/rating/list";
    }
}
