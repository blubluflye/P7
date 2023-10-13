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
	private RatingRepository ratingRepository;

	public Rating create(Rating newRating) {
		return ratingRepository.save(newRating);
	}
	
	public Optional<Rating> read(Integer id) {
		return ratingRepository.findById(id);
	}
	
	public void delete(Rating rating){
		ratingRepository.delete(rating);
	}
	
	public Rating update(Rating updatedRating) {
		return ratingRepository.save(updatedRating);
	}
	
	public List<Rating> findAll() {
		return ratingRepository.findAll();
	}
}
