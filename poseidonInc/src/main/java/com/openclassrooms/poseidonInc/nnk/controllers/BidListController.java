package com.openclassrooms.poseidonInc.nnk.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.poseidonInc.nnk.domain.BidList;
import com.openclassrooms.poseidonInc.nnk.services.BidListService;

import jakarta.validation.Valid;




@Controller
public class BidListController {
	
	@Autowired
	BidListService bidListService;
	
    @RequestMapping("/bidList/list")
    public String home(Model model)
    {
    	model.addAttribute("bidLists",bidListService.findAll());
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
    	if (!result.hasErrors()) {
    		bidListService.createBid(bid);
    		model.addAttribute("bidLists",bidListService.findAll());
    		return "redirect:/bidList/list";
    	}
        return "bidList/add";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	BidList bidList = bidListService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bidList Id:" + id));
    	model.addAttribute("bidList", bidList);
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Bid and return list Bid
    	bidListService.updateBid(bidList);
    	model.addAttribute("bidLists",bidListService.findAll());
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
    	BidList bidList = bidListService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bidList Id:" + id));
    	bidListService.deleteBid(bidList);
    	model.addAttribute("bidLists",bidListService.findAll());
        return "redirect:/bidList/list";
    }
}
