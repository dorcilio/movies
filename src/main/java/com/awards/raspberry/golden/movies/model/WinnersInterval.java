package com.awards.raspberry.golden.movies.model;

import java.util.List;

public class WinnersInterval {
	private List<Winner> min;
	private List<Winner> max;
	
	public WinnersInterval() {
		
	}

	public WinnersInterval(List<Winner> min, List<Winner> max) {
		super();
		this.min = min;
		this.max = max;
	}

	public List<Winner> getMin() {
		return min;
	}

	public void setMin(List<Winner> min) {
		this.min = min;
	}

	public List<Winner> getMax() {
		return max;
	}

	public void setMax(List<Winner> max) {
		this.max = max;
	}
}
