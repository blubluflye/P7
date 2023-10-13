package com.openclassrooms.poseidonInc.ServiceTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

import com.openclassrooms.poseidonInc.nnk.domain.Rating;
import com.openclassrooms.poseidonInc.nnk.repositories.RatingRepository;
import com.openclassrooms.poseidonInc.nnk.services.RatingService;

@ExtendWith(MockitoExtension.class)
public class RatingServiceTest {
	@InjectMocks
	RatingService ratingService;
	@Mock
	RatingRepository ratingRepository;
	
	@Test
	public void ratingCreateTest() {
		Rating rating = new Rating();
		rating.setOrderNumber(1);
		given(ratingRepository.save(rating)).willReturn(rating);
		assertThat(ratingService.create(rating).getOrderNumber()).isEqualTo(1);
	}
	
	@Test
	public void ratingDeleteTest() {
		Rating rating = new Rating();
		rating.setOrderNumber(1);
		willDoNothing().given(ratingRepository).delete(rating);
		ratingService.delete(rating);
		verify(ratingRepository, times(1)).delete(rating);;
	}
	
	@Test
	public void ratingFindAllTest() {
		List<Rating> ratings = new ArrayList<Rating>();
		ratings.add(new Rating());
		given(ratingRepository.findAll()).willReturn(ratings);
		assertThat(ratingService.findAll().size()).isEqualTo(1);
	}
	
	@Test
	public void ratingUpdateTest() {
		Rating rating = new Rating();
		rating.setOrderNumber(1);
		given(ratingRepository.save(rating)).willReturn(rating);
		assertThat(ratingService.update(rating).getOrderNumber()).isEqualTo(1);
	}
	
	@Test
	public void ratingReadTest() {
		Optional<Rating> rating = Optional.of(new Rating());
		rating.get().setId(1);
		rating.get().setOrderNumber(3);;
		given(ratingRepository.findById(1)).willReturn(rating);
		assertThat(ratingService.read(1).get().getOrderNumber()).isEqualTo(3);
	}
}
