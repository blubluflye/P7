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
	
	public BidList createBid(BidList bidList) {
		return bidListRepository.save(bidList);
	}
	
	public BidList readBid(Integer id) {
		Optional<BidList> result = bidListRepository.findById(id);
		if (result.isPresent())
			return result.get();
		return null;
	}
	
	public BidList updateBid(BidList bidList) {
		if (bidListRepository.findById(bidList.getBidListId()).isPresent())
			return bidListRepository.save(bidList);
		return null;
	}
	
	public void deleteBid(BidList bidList) {
		if (bidListRepository.findById(bidList.getBidListId()).isPresent())
			bidListRepository.delete(bidList);
	}

	public Optional<BidList> findById(Integer id) {
		return bidListRepository.findById(id);
	}
}
