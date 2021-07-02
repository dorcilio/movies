package com.awards.raspberry.golden.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@Column(name = "id_movie")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovie;
	private Integer year;
	private String title;
	private String studio;
	private String producer;
	private Boolean winner;
	
	public Movie () {
		
	}

	public Movie(Long idMovie, Integer year, String title, String studio, String producer, Boolean winner) {
		super();
		this.idMovie = idMovie;
		this.year = year;
		this.title = title;
		this.studio = studio;
		this.producer = producer;
		this.winner = winner;
	}

	public Long getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(Long idMovie) {
		this.idMovie = idMovie;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Boolean getWinner() {
		return winner;
	}

	public void setWinner(Boolean winner) {
		this.winner = winner;
	}
}
