package com.rating.service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rating.service.entities.Rating;

public interface RatingService {
	
	Rating addRating(Rating rating);
	
	Rating getRatingById(String ratingid);
	
	List<Rating> getAllRating();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
	

}
