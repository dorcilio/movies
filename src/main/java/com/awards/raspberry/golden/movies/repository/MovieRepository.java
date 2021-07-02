package com.awards.raspberry.golden.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awards.raspberry.golden.movies.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
