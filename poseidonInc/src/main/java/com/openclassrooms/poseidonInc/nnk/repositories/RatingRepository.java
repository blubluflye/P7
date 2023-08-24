package com.openclassrooms.poseidonInc.nnk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openclassrooms.poseidonInc.nnk.domain.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
