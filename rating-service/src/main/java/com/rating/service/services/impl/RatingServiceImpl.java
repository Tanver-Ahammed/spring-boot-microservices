package com.rating.service.services.impl;

import com.rating.service.entities.Rating;
import com.rating.service.repositories.RatingRepository;
import com.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    // create rating
    @Override
    public Rating createRating(Rating rating) {
        return this.ratingRepository.save(rating);
    }

    // get all rating
    @Override
    public List<Rating> getAllRating() {
        return this.ratingRepository.findAll();
    }

    // get rating by user id
    @Override
    public List<Rating> getAllRatingByUserId(Long userId) {
        return this.ratingRepository.findByUserId(userId);
    }

    // get rating by hotel id
    @Override
    public List<Rating> getAllRatingByHotelId(Long hotelId) {
        return this.ratingRepository.findByHotelId(hotelId);
    }

    // update rating
    @Override
    public Rating updateRating(Rating rating, Long ratingId) {
        return null;
    }

    // delete rating
    @Override
    public void deleteRating(Long ratingId) {

    }


}
