package tw.fondus.openfeign.cwb.weather.v1.dto.seasurface;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The JSON model of sea currents layer.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class Layer {
	@JsonProperty( "layerNumber" )
	private String layerNumber;

	@JsonProperty( "currentDirection" )
	private String currentDirection;

	@JsonProperty( "currentDirectionDescription" )
	private String currentDirectionDescription;

	@JsonProperty( "currentSpeed" )
	private String currentSpeed;

	@JsonProperty( "currentSpeedInKnots" )
	private String currentSpeedInKnots;
}
