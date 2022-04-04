/**
 * 
 */
package com.bet.springboot.crudrestfullwebservices.model;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Convert {@link Sport} to corresponding database value
 */
@Converter(autoApply = true)
public class SportConverter implements AttributeConverter<Sport, String> {
	
	  @Override
	    public String convertToDatabaseColumn(Sport sport) {
	        if (sport == null) {
	            return null;
	        }
	        return sport.getSportId();
	    }

	    @Override
	    public Sport convertToEntityAttribute(String code) {
	        if (code == null) {
	            return null;
	        }

	        return Stream.of(Sport.values())
	          .filter(s -> s.getSportId().equals(code))
	          .findFirst()
	          .orElseThrow(IllegalArgumentException::new);
	    }


}
