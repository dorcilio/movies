package com.awards.raspberry.golden.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producer")
public class Producer {
	@Id
	@Column(name = "id_producer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducer;
	private String producer;
	@ManyToOne
	@JoinColumn(name="id_movie")
	private Movie movie;
	
	public Producer() {
		
	}

	public Producer(String producer) {
		super();
		this.producer = producer;
	}

	public Producer(Long idProducer, String producer, Movie movie) {
		super();
		this.idProducer = idProducer;
		this.producer = producer;
		this.movie = movie;
	}

	public Long getIdProducer() {
		return idProducer;
	}

	public void setIdProducer(Long idProducer) {
		this.idProducer = idProducer;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
