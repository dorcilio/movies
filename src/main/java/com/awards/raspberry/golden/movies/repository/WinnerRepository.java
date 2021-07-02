package com.awards.raspberry.golden.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awards.raspberry.golden.movies.model.Winner;

public interface WinnerRepository extends JpaRepository<Winner, Long> {
	List<Winner> findAllMinWinner();
	
	List<Winner> findAllMaxWinner();
}
