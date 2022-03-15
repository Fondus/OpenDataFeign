package tw.fondus.openfeign.cwb.weather.v1.dto.rainfall;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The JSON model of weather element.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class WeatherElement {
	@JsonProperty( "elementName" )
	private String elementName;
	
	@JsonProperty( "elementValue" )
	private String elementValue;
}
