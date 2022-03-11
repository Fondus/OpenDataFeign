package tw.fondus.openfeign.cwb.weather.v1.dto.rainfall;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The JSON model of parameter.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class Parameter {
	@JsonProperty( "parameterName" )
	private String parameterName;
	
	@JsonProperty( "parameterValue" )
	private String parameterValue;
}
