package com.hotel.service.services.impl;

import com.hotel.service.entities.Hotel;
import com.hotel.service.exceptions.ResourceNotFoundException;
import com.hotel.service.repository.HotelRepository;
import com.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return this.hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(Long hotelId) {
        return this.hotelRepository.findById(hotelId).orElseThrow(() ->
                new ResourceNotFoundException("Hotel not found on server!! " + hotelId));
    }

    @Override
    public List<Hotel> getAllHotel() {
        return this.hotelRepository.findAll();
    }

    @Override
    public Hotel updateHotel(Hotel hotel, Long hotelId) {
        Hotel mainHotel = this.hotelRepository.findById(hotelId).orElseThrow(() ->
                new ResourceNotFoundException("Hotel not found on server!! " + hotelId));
        mainHotel.setName(hotel.getName());
        mainHotel.setAbout(hotel.getAbout());
        mainHotel.setLocation(hotel.getLocation());
        return this.hotelRepository.save(mainHotel);
    }

    @Override
    public void deleteHotel(Long hotelId) {
        Hotel mainHotel = this.hotelRepository.findById(hotelId).orElseThrow(() ->
                new ResourceNotFoundException("Hotel not found on server!! " + hotelId));
        this.hotelRepository.delete(mainHotel);
    }
}
