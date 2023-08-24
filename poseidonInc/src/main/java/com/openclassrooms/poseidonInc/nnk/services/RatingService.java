package com.openclassrooms.poseidonInc.nnk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.poseidonInc.nnk.domain.Rating;
import com.openclassrooms.poseidonInc.nnk.repositories.RatingRepository;

@Service
public class RatingService {
	@Autowired
	private RatingRepository ratingRepo;

	Rating create(Rating newRating) {
		return ratingRepo.save(newRating);
	}
	
	Rating read(Integer id) {
		return ratingRepo.getReferenceById(id);
	}
	
	void delete(Integer id){
		ratingRepo.deleteById(id);
	}
	
	Rating update(Rating updatedRating) {
		return ratingRepo.save(updatedRating);
	}
	
	List<Rating> getAll() {
		return ratingRepo.findAll();
	}
}
