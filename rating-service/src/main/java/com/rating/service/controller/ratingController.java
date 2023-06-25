package com.rating.service.controller;

import com.rating.service.entities.Rating;
import com.rating.service.services.impl.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class ratingController {

    @Autowired
    private RatingServiceImpl ratingService;

    // create rating
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.ratingService.createRating(rating));
    }

    // get all rating
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating() {
        return ResponseEntity.ok(this.ratingService.getAllRating());
    }

    // get all rating by user id
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(this.ratingService.getAllRatingByUserId(userId));
    }

    // get all rating by hotel id
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable Long hotelId) {
        return ResponseEntity.ok(this.ratingService.getAllRatingByHotelId(hotelId));
    }

    // create rating
    // create rating
    // create rating

}
