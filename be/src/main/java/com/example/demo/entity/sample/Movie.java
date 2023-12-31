package com.example.demo.entity.sample;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_Movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    
    @Id
    @SequenceGenerator(
        name = "movie_sequence",
        sequenceName = "movie_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "movie_sequence"
    )
    private Long id;
    private String imdbId;
    private String title;
    
    private LocalDate releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backDrops;

    // // @JsonBackReference
    // @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;
    
}
