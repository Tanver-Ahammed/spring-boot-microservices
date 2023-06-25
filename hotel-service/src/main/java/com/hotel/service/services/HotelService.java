package com.hotel.service.services;

import com.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    // create hotel
    Hotel createHotel(Hotel hotel);

    // get hotel by id
    Hotel getHotelById(Long hotelId);

    // get all hotel
    List<Hotel> getAllHotel();

    // update hotel
    Hotel updateHotel(Hotel hotel, Long hotelId);

    // delete  hotel
    void deleteHotel(Long hotelId);

}
