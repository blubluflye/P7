package com.openclassrooms.poseidonInc.nnk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.poseidonInc.nnk.domain.Rating;
import com.openclassrooms.poseidonInc.nnk.repositories.RatingRepository;

@Service
public class RatingService {
	@Autowired
	private RatingRepository ratingRepo;

	public Rating create(Rating newRating) {
		return ratingRepo.save(newRating);
	}
	
	public Optional<Rating> read(Integer id) {
		return ratingRepo.findById(id);
	}
	
	public void delete(Integer id){
		ratingRepo.deleteById(id);
	}
	
	public Rating update(Rating updatedRating) {
		return ratingRepo.save(updatedRating);
	}
	
	public List<Rating> getAll() {
		return ratingRepo.findAll();
	}
}
