package com.awards.raspberry.golden.movies.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_movie")
	private List<Producer> producers;
	private Boolean winner;
	
	public Movie () {
		
	}

	public Movie(Long idMovie, Integer year, String title, String studio, List<Producer> producers, Boolean winner) {
		super();
		this.idMovie = idMovie;
		this.year = year;
		this.title = title;
		this.studio = studio;
		this.producers = producers;
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

	public List<Producer> getProducers() {
		return producers;
	}

	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}

	public Boolean getWinner() {
		return winner;
	}

	public void setWinner(Boolean winner) {
		this.winner = winner;
	}
}
