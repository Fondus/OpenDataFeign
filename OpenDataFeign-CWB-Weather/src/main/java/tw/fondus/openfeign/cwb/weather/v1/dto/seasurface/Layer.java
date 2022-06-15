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
	@JsonProperty( "LayerNumber" )
	private String layerNumber;

	@JsonProperty( "CurrentDirection" )
	private String currentDirection;

	@JsonProperty( "CurrentDirectionDescription" )
	private String currentDirectionDescription;

	@JsonProperty( "CurrentSpeed" )
	private String currentSpeed;

	@JsonProperty( "CurrentSpeedInKnots" )
	private String currentSpeedInKnots;
}
