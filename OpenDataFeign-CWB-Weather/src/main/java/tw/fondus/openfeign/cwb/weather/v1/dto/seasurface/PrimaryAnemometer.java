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
	@JsonProperty( "WindSpeed" )
	private String windSpeed;

	@JsonProperty( "WindScale" )
	private String windScale;

	@JsonProperty( "WindDirection" )
	private String windDirection;

	@JsonProperty( "WindDirectionDescription" )
	private String windDirectionDescription;

	@JsonProperty( "MaximumWindSpeed" )
	private String maximumWindSpeed;

	@JsonProperty( "MaximumWindScale" )
	private String maximumWindScale;
}
