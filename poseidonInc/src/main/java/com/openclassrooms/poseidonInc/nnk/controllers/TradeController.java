package com.openclassrooms.poseidonInc.nnk.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.poseidonInc.nnk.domain.Trade;
import com.openclassrooms.poseidonInc.nnk.services.TradeService;

import jakarta.validation.Valid;

@Controller
public class TradeController {
	@Autowired
	TradeService tradeService;

    @RequestMapping("/trade/list")
    public String home(Model model)
    {
    	model.addAttribute("trades", tradeService.findAll());
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade bid) {
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
    	if (!result.hasErrors()) {
    		tradeService.create(trade);
    		model.addAttribute("trades", tradeService.findAll());
    		return "redirect:/trade/list";
    	}	
        return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	Trade trade = tradeService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id:" + id));
    	model.addAttribute("trade", trade);
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
    	tradeService.update(trade);
    	model.addAttribute("trades", tradeService.findAll());
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
    	tradeService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id:" + id));
    	tradeService.delete(id);
    	model.addAttribute("trades", tradeService.findAll());
        return "redirect:/trade/list";
    }
}
