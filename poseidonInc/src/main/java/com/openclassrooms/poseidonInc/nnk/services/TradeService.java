package com.openclassrooms.poseidonInc.nnk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.poseidonInc.nnk.domain.Trade;
import com.openclassrooms.poseidonInc.nnk.repositories.TradeRepository;

import jakarta.validation.Valid;

@Service
public class TradeService {
	
	@Autowired
	TradeRepository tradeRepository;
	
	public List<Trade> findAll() {
		return tradeRepository.findAll();
	}

	public @Valid Trade create(@Valid Trade trade) {
		return tradeRepository.save(trade);
	}

	public void delete(Integer id) {
		tradeRepository.deleteById(id);
	}

	public @Valid Trade update(@Valid Trade trade) {
		return tradeRepository.save(trade);
	}

	public  Optional<Trade> read(Integer id) {
		// TODO Auto-generated method stub
		return tradeRepository.findById(id);
	}

}
