package com.bet.springboot.crudrestfullwebservices.model;


import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "matches")
public class Match {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "description")
	private String description;
	
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@Column(name = "match_date")
	private Date matchDate;
	
	@JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
	@Column(name = "match_time")
	private Calendar matchTime;
	
	@Column(name = "team_a")
	private String teamA;
	
	@Column(name = "team_b")
	private String teamB;
	
	@Column(name = "sport")
	private Sport sport;
	
	public Match() {
		super();
	}
	
	public Match(long id, String description, Date matchDate, Calendar matchTime, String teamA, String teamB, Sport sport) {
		super();
		this.id = id;
		this.description = description;
		this.matchDate = matchDate;
		this.matchTime = matchTime;
		this.teamA = teamA;
		this.teamB = teamB;
		this.sport = sport;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the matchDate
	 */
	public Date getMatchDate() {
		return matchDate;
	}

	/**
	 * @param matchDate the matchDate to set
	 */
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	/**
	 * @return the matchTime
	 */
	public Calendar getMatchTime() {
		return matchTime;
	}

	/**
	 * @param matchTime the matchTime to set
	 */
	public void setMatchTime(Calendar matchTime) {
		this.matchTime = matchTime;
	}

	/**
	 * @return the teamA
	 */
	public String getTeamA() {
		return teamA;
	}

	/**
	 * @param teamA the teamA to set
	 */
	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}

	/**
	 * @return the teamB
	 */
	public String getTeamB() {
		return teamB;
	}

	/**
	 * @param teamB the teamB to set
	 */
	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}

	/**
	 * @return the sport
	 */
	public Sport getSport() {
		return sport;
	}

	/**
	 * @param sport the sport to set
	 */
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	
	
}
