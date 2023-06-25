package com.rating.service.services;

import com.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {

    // create rating
    Rating createRating(Rating rating);

    // get all rating
    List<Rating> getAllRating();

    // get rating by user id
    List<Rating> getAllRatingByUserId(Long userId);

    // get rating by hotel id
    List<Rating> getAllRatingByHotelId(Long hotelId);

    // update rating
    Rating updateRating(Rating rating, Long ratingId);

    // delete rating
    void deleteRating(Long ratingId);

}
