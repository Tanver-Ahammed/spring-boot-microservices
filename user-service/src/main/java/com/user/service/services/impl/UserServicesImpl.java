package com.user.service.services.impl;

import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repositories.UserRepository;
import com.user.service.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(UserServicesImpl.class);

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = this.userRepository.findAll()
                .stream()
                .map(this::fetchingRatingOfUser)
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public User getUserById(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User not found on server!! " + userId));
        // fetching rating from RATING-SERVICE
        return this.fetchingRatingOfUser(user);
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public void updateUser(Long userId, User user) {

    }

    // fetching rating from RATING-SERVICE
    public User fetchingRatingOfUser(User user) {
        // http://localhost:8083/ratings/users/1
        ArrayList ratingsOfUsers = restTemplate.getForObject("http://localhost:8083/ratings/users/" + user.getId(), ArrayList.class);
        logger.info("", ratingsOfUsers);
        user.setRatings(ratingsOfUsers);
        return user;
    }

}
