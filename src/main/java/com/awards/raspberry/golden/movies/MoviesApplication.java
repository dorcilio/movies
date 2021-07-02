package com.awards.raspberry.golden.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.awards.raspberry.golden.movies.service.MovieService;
import com.awards.raspberry.golden.movies.util.ApplicationContextHolder;

@SpringBootApplication
public class MoviesApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
		/* load service and save CSV to DB */
		MovieService movieService = ApplicationContextHolder.getContext().getBean(MovieService.class);
		movieService.saveCSVToDB();
	}

}
