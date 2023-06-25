package com.rating.service.repositories;

import com.rating.service.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, Long> {

    // custom finder method
    List<Rating> findByUserId(Long userId);

    List<Rating> findByHotelId(Long hotelId);

}
