package com.awards.raspberry.golden.movies.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.awards.raspberry.golden.movies.model.Movie;
import com.awards.raspberry.golden.movies.model.Response;
import com.awards.raspberry.golden.movies.model.Winner;
import com.awards.raspberry.golden.movies.model.WinnersInterval;
import com.awards.raspberry.golden.movies.repository.MovieRepository;
import com.awards.raspberry.golden.movies.repository.WinnerRepository;
import com.awards.raspberry.golden.movies.util.CSVUtil;

@Service
@Configurable
public class MovieService {
	@Autowired
    private MovieRepository movieRepository;

	@Autowired
    private WinnerRepository winnerRepository;

	public ResponseEntity<?> save(MultipartFile file) {
        try {
        	Response response = new Response();
            if (CSVUtil.hasCSVFormat(file)) {
            	List<Movie> movies = CSVUtil.parseCSVToMovie(file.getInputStream());
            	/* prevention of duplicate data */
            	movieRepository.deleteAll();
            	/* save all data from CSV in H2 DB */
                movieRepository.saveAll(movies);
                response.setMessage("Upload and save the file successfully: " + file.getOriginalFilename());
                return new ResponseEntity<Response>(response, HttpStatus.CREATED);
            } else {
            	response.setMessage("Only CSV format is supported!");
            	return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (IOException e) {
            throw new RuntimeException("error to store CSV data: " + e.getMessage());
        }
    }
	
	public void saveCSVToDB() {
        try {
        	InputStream is = Thread.currentThread().getContextClassLoader().getResource("movielist.csv").openStream();
        	List<Movie> movies = CSVUtil.parseCSVToMovie(is);
        	/* save all data from CSV in H2 DB */
        	movieRepository.saveAll(movies);
        } catch (IOException e) {
            throw new RuntimeException("error to store CSV data: " + e.getMessage());
        }
    }
	
	public ResponseEntity<?> findAllWinnersInterval() {
        final List<Winner> min = winnerRepository.findAllMinWinner();
		final List<Winner> max = winnerRepository.findAllMaxWinner();
		WinnersInterval response = new WinnersInterval(min, max);
		return new ResponseEntity<WinnersInterval>(response, HttpStatus.OK);
    }
}
