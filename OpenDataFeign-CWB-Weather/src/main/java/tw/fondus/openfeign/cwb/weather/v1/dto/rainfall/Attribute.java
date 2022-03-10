package tw.fondus.openfeign.cwb.weather.v1.dto.rainfall;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The JSON model of attribute.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class Attribute {
	@JsonProperty( "elementName" )
	private String name;
	
	@JsonProperty( "elementValue" )
	private String value;
}
