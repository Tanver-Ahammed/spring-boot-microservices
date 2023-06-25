package com.hotel.service.controller;

import com.hotel.service.entities.Hotel;
import com.hotel.service.payload.ApiResponse;
import com.hotel.service.services.impl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelServiceImpl hotelService;

    // create hotel
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.hotelService.createHotel(hotel));
    }

    // get hotel by id
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long hotelId) {
        return ResponseEntity.ok(this.hotelService.getHotelById(hotelId));
    }

    // get all hotel
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel() {
        return ResponseEntity.ok(this.hotelService.getAllHotel());
    }

    // update hotel
    @PutMapping("{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long hotelId,
                                             @RequestBody Hotel hotel) {
        return ResponseEntity.ok(this.hotelService.updateHotel(hotel, hotelId));
    }

    // delete hotel
    @DeleteMapping("{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long hotelId) {
        this.hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>(new ApiResponse("Category deleted successfully",
                true, HttpStatus.OK),
                HttpStatus.OK);
    }


}
