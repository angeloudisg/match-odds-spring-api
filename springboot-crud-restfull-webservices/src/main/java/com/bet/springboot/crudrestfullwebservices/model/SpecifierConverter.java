/**
 * 
 */
package com.bet.springboot.crudrestfullwebservices.model;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Convert {@link Specifier} to corresponding database value
 */
@Converter(autoApply = true)
public class SpecifierConverter implements AttributeConverter<Specifier, String> {
	
	@Override
    public String convertToDatabaseColumn(Specifier specifier) {
        if (specifier == null) {
            return null;
        }
        return specifier.getSpecifierId();
    }

    @Override
    public Specifier convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Specifier.values())
          .filter(s -> s.getSpecifierId().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }


}
