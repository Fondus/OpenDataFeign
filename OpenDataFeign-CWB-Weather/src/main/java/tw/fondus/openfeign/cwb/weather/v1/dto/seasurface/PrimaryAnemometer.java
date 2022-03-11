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
public class PrimaryAnemometer {
	@JsonProperty( "windSpeed" )
	private String windSpeed;

	@JsonProperty( "windScale" )
	private String windScale;

	@JsonProperty( "windDirection" )
	private String windDirection;

	@JsonProperty( "windDirectionDescription" )
	private String windDirectionDescription;

	@JsonProperty( "maximumWindSpeed" )
	private String maximumWindSpeed;

	@JsonProperty( "maximumWindScale" )
	private String maximumWindScale;
}
