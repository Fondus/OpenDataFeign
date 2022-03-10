package tw.fondus.openfeign.cwb.weather.v1.dto.seasurface;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The JSON model of wind.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class Wind {
	@JsonProperty( "windSpeed" )
	private String speed;

	@JsonProperty( "windScale" )
	private String scale;

	@JsonProperty( "windDirection" )
	private String direction;

	@JsonProperty( "windDirectionDescription" )
	private String directionDescription;

	@JsonProperty( "maximumWindSpeed" )
	private String maximumSpeed;

	@JsonProperty( "maximumWindScale" )
	private String maximumScale;
}
