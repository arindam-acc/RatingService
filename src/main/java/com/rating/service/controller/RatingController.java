package com.rating.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.service.entities.Rating;
import com.rating.service.services.RatingService;

@RestController
@RequestMapping("/v1/rating")
public class RatingController {
	
	private Logger logger = LoggerFactory.getLogger(RatingController.class);
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/addRating")
	public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
		Rating newRating  = ratingService.addRating(rating);
		return new ResponseEntity<Rating>(newRating, HttpStatus.CREATED);
	}
	
	@GetMapping("/getRating/{ratingId}")
	public ResponseEntity<Rating> getRating(@PathVariable String ratingId){
		return new ResponseEntity<Rating>(ratingService.getRatingById(ratingId), HttpStatus.OK);
	}
	
	@GetMapping("/getAllRatings")
	public ResponseEntity<List<Rating>> allRatings(){
		List<Rating> allRating = ratingService.getAllRating();
		return new ResponseEntity<List<Rating>>(allRating, HttpStatus.OK);
	}
	
	@GetMapping("/getAllRatings/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		List<Rating> allRating = ratingService.getRatingByUserId(userId);
		logger.info("{}",allRating);
		return new ResponseEntity<List<Rating>>(allRating, HttpStatus.OK);
	}
	
	@GetMapping("/getAllRatings/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		List<Rating> allRating = ratingService.getRatingByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(allRating, HttpStatus.OK);
	}

}
