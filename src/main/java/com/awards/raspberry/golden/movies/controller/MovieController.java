package com.awards.raspberry.golden.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.awards.raspberry.golden.movies.service.MovieService;

@Controller
@RequestMapping("movie")
public class MovieController {
	@Autowired
    MovieService movieService;
	
	@RequestMapping(path = "upload", headers = "content-type=multipart/*", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> uploadAsync(@RequestParam("file") MultipartFile file) throws Exception {
		return movieService.save(file);
	}
	
	@RequestMapping(path = "winners", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> listarImportacoes() throws Exception {
		return movieService.findAllWinnersInterval();
	}
	
}
