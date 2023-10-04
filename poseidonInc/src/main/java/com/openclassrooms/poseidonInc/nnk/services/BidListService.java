package com.openclassrooms.poseidonInc.nnk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.poseidonInc.nnk.domain.BidList;
import com.openclassrooms.poseidonInc.nnk.repositories.BidListRepository;

@Service
public class BidListService {

	@Autowired
	BidListRepository bidListRepository;
	
	public List<BidList> findAll() {
		return bidListRepository.findAll();
	}
	
	public BidList create(BidList bidList) {
		return bidListRepository.save(bidList);
	}
	
	
	public BidList update(BidList bidList) {
		if (bidListRepository.findById(bidList.getBidListId()).isPresent())
			return bidListRepository.save(bidList);
		return null;
	}
	
	public void delete(BidList bidList) {
		if (bidListRepository.findById(bidList.getBidListId()).isPresent())
			bidListRepository.delete(bidList);
	}

	public Optional<BidList> read(Integer id) {
		return bidListRepository.findById(id);
	}
}
