package com.awards.raspberry.golden.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@NamedNativeQueries({
    @NamedNativeQuery(
            name    =   "Winner.findAllMinWinner",
            query   =   "SELECT "
            		+ "	b.interval_win, "
            		+ "	b.producer, "
            		+ "	b.previous_win, "
            		+ "	b.following_win "
            		+ "FROM "
            		+ "( "
            		+ "	SELECT "
            		+ "		a.interval_win "
            		+ "	FROM "
            		+ "	( "
            		+ "		SELECT "
            		+ "			DISTINCT a.producer, "
            		+ "			b.year - c.year AS interval_win, "
            		+ "			c.year AS previous_win, "
            		+ "			b.year AS following_win "
            		+ "		FROM "
            		+ "			producer a "
            		+ "		JOIN "
            		+ "			movie b ON a.id_movie = b.id_movie "
            		+ "		JOIN "
            		+ "		( "
            		+ "			SELECT "
            		+ "				DISTINCT a.producer, "
            		+ "				b.year, "
            		+ "				b.id_movie "
            		+ "			FROM "
            		+ "				producer a "
            		+ "			JOIN "
            		+ "				movie b ON a.id_movie = b.id_movie "
            		+ "			WHERE "
            		+ "				b.winner IS TRUE "
            		+ "			ORDER BY "
            		+ "				b.year ASC "
            		+ "	) c ON a.producer = c.producer "
            		+ "	WHERE "
            		+ "		b.winner IS TRUE AND b.id_movie > c.id_movie "
            		+ "	ORDER BY "
            		+ "		b.year ASC "
            		+ "	) AS a "
            		+ "	ORDER BY "
            		+ "		a.interval_win ASC "
            		+ "	LIMIT 1 "
            		+ ") a JOIN "
            		+ "( "
            		+ "	SELECT "
            		+ "		a.producer, "
            		+ "		a.interval_win, "
            		+ "		a.previous_win, "
            		+ "		a.following_win "
            		+ "	FROM "
            		+ "	( "
            		+ "		SELECT "
            		+ "			DISTINCT a.producer, "
            		+ "			b.year - c.year AS interval_win, "
            		+ "			c.year AS previous_win, "
            		+ "			b.year AS following_win "
            		+ "		FROM "
            		+ "			producer a "
            		+ "		JOIN "
            		+ "			movie b ON a.id_movie = b.id_movie "
            		+ "		JOIN "
            		+ "		( "
            		+ "			SELECT "
            		+ "				DISTINCT a.producer, "
            		+ "				b.year, "
            		+ "				b.id_movie "
            		+ "			FROM "
            		+ "				producer a "
            		+ "			JOIN "
            		+ "				movie b ON a.id_movie = b.id_movie "
            		+ "			WHERE "
            		+ "				b.winner IS TRUE "
            		+ "			ORDER BY "
            		+ "				b.year ASC "
            		+ "	) c ON a.producer = c.producer "
            		+ "	WHERE "
            		+ "		b.winner IS TRUE AND b.id_movie > c.id_movie "
            		+ "	ORDER BY "
            		+ "		b.year ASC "
            		+ "	) AS a "
            		+ "	ORDER BY "
            		+ "		a.interval_win "
            		+ ") b ON a.interval_win = b.interval_win",
                        resultClass=Winner.class
    ),
    @NamedNativeQuery(
            name    =   "Winner.findAllMaxWinner",
            query   =   "SELECT "
            		+ "	b.interval_win, "
            		+ "	b.producer, "
            		+ "	b.previous_win, "
            		+ "	b.following_win "
            		+ "FROM "
            		+ "( "
            		+ "	SELECT "
            		+ "		a.interval_win "
            		+ "	FROM "
            		+ "	( "
            		+ "		SELECT "
            		+ "			DISTINCT a.producer, "
            		+ "			b.year - c.year AS interval_win, "
            		+ "			c.year AS previous_win, "
            		+ "			b.year AS following_win "
            		+ "		FROM "
            		+ "			producer a "
            		+ "		JOIN "
            		+ "			movie b ON a.id_movie = b.id_movie "
            		+ "		JOIN "
            		+ "		( "
            		+ "			SELECT "
            		+ "				DISTINCT a.producer, "
            		+ "				b.year, "
            		+ "				b.id_movie "
            		+ "			FROM "
            		+ "				producer a "
            		+ "			JOIN "
            		+ "				movie b ON a.id_movie = b.id_movie "
            		+ "			WHERE "
            		+ "				b.winner IS TRUE "
            		+ "			ORDER BY "
            		+ "				b.year ASC "
            		+ "	) c ON a.producer = c.producer "
            		+ "	WHERE "
            		+ "		b.winner IS TRUE AND b.id_movie > c.id_movie "
            		+ "	ORDER BY "
            		+ "		b.year ASC "
            		+ "	) AS a "
            		+ "	ORDER BY "
            		+ "		a.interval_win DESC "
            		+ "	LIMIT 1 "
            		+ ") a JOIN "
            		+ "( "
            		+ "	SELECT "
            		+ "		a.producer, "
            		+ "		a.interval_win, "
            		+ "		a.previous_win, "
            		+ "		a.following_win "
            		+ "	FROM "
            		+ "	( "
            		+ "		SELECT "
            		+ "			DISTINCT a.producer, "
            		+ "			b.year - c.year AS interval_win, "
            		+ "			c.year AS previous_win, "
            		+ "			b.year AS following_win "
            		+ "		FROM "
            		+ "			producer a "
            		+ "		JOIN "
            		+ "			movie b ON a.id_movie = b.id_movie "
            		+ "		JOIN "
            		+ "		( "
            		+ "			SELECT "
            		+ "				DISTINCT a.producer, "
            		+ "				b.year, "
            		+ "				b.id_movie "
            		+ "			FROM "
            		+ "				producer a "
            		+ "			JOIN "
            		+ "				movie b ON a.id_movie = b.id_movie "
            		+ "			WHERE "
            		+ "				b.winner IS TRUE "
            		+ "			ORDER BY "
            		+ "				b.year ASC "
            		+ "	) c ON a.producer = c.producer "
            		+ "	WHERE "
            		+ "		b.winner IS TRUE AND b.id_movie > c.id_movie "
            		+ "	ORDER BY "
            		+ "		b.year ASC "
            		+ "	) AS a "
            		+ "	ORDER BY "
            		+ "		a.interval_win "
            		+ ") b ON a.interval_win = b.interval_win",
                        resultClass=Winner.class
    )
})
public class Winner {
	@Id
	private String producer;
	@Column(name = "interval_win")
	@JsonProperty("interval")
	private Integer intervalWin;
	@Column(name = "previous_win")
	private Integer previousWin;
	@Column(name = "following_win")
	private Integer followingWin;
	
	public Winner () {
		
	}

	public Winner(String producer, Integer intervalWin, Integer previousWin, Integer followingWin) {
		super();
		this.producer = producer;
		this.intervalWin = intervalWin;
		this.previousWin = previousWin;
		this.followingWin = followingWin;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@JsonProperty("interval")
	public Integer getIntervalWin() {
		return intervalWin;
	}

	public void setIntervalWin(Integer intervalWin) {
		this.intervalWin = intervalWin;
	}

	public Integer getPreviousWin() {
		return previousWin;
	}

	public void setPreviousWin(Integer previousWin) {
		this.previousWin = previousWin;
	}

	public Integer getFollowingWin() {
		return followingWin;
	}

	public void setFollowingWin(Integer followingWin) {
		this.followingWin = followingWin;
	}
}
