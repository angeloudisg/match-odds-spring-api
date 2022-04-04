/**
 * 
 */
package com.bet.springboot.crudrestfullwebservices.model;

import lombok.Getter;

/**
 * Enumeration to set the outcome of the match
 */
@Getter
public enum Specifier {
	WIN("1"), DRAW("X"), LOSS("2");

	private String specifierId;

	private Specifier(String specifierId) {
		this.specifierId = specifierId;
	}
	
	public String getSpecifierId() {
		return specifierId;
	}
	

}
