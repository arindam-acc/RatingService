package com.rating.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rating.service.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{
	
	@Query(value = "SELECT * FROM ratings r WHERE r.user_id =?1", nativeQuery = true)
	List<Rating> getUserRatingByUserId(String userId );
	
	@Query(value = "SELECT * FROM ratings h WHERE h.hotel_id = ?1", nativeQuery = true)
	List<Rating> getUserRatingByHotelId(String hotelId);
	

}
