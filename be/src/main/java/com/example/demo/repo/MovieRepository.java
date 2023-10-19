package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.sample.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
