package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.sample.Review;
import com.example.demo.handler.ResHandler;
import com.example.demo.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ResHandler resHandler;


    
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Review review){

        return resHandler.generateResponse(reviewService.addReview(review), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){

        return resHandler.generateResponse(reviewService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByMovieId(@PathVariable("id") Long movieId){

        return resHandler.generateResponse(reviewService.getAllByMovieId(movieId), HttpStatus.OK);
    }

}
