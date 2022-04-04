/**
 * 
 */
package com.bet.springboot.crudrestfullwebservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 */

@Entity
@Table(name = "odds")
public class MatchOdds {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "match_id")
	private long matchId;
	
	@Column(name = "specifier")
	private Specifier specifier;
	
	@Column(name = "odd")
	private double odd;
	
	/**
	 * default Constructor
	 */
	public MatchOdds() {
		super();
	}

	/**
	 * @param id
	 * @param matchId
	 * @param specifier
	 * @param odd
	 */
	public MatchOdds(long id, long matchId, Specifier specifier, double odd) {
		super();
		this.id = id;
		this.matchId = matchId;
		this.specifier = specifier;
		this.odd = odd;
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
	 * @return the matchId
	 */
	public long getMatchId() {
		return matchId;
	}

	/**
	 * @param matchId the matchId to set
	 */
	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	/**
	 * @return the specifier
	 */
	public Specifier getSpecifier() {
		return specifier;
	}

	/**
	 * @param specifier the specifier to set
	 */
	public void setSpecifier(Specifier specifier) {
		this.specifier = specifier;
	}

	/**
	 * @return the odd
	 */
	public double getOdd() {
		return odd;
	}

	/**
	 * @param odd the odd to set
	 */
	public void setOdd(double odd) {
		this.odd = odd;
	}
	
	

}
