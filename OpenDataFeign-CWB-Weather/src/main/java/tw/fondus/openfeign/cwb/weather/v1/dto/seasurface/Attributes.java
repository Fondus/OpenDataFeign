package tw.fondus.openfeign.cwb.weather.v1.dto.seasurface;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The JSON model of tide and buoy attribute.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class Attributes {
	@JsonProperty( "tideHeight" )
	private String tideHeight;

	@JsonProperty( "tideLevel" )
	private String tideLevel;

	@JsonProperty( "waveHeight" )
	private String waveHeight;

	@JsonProperty( "waveDirection" )
	private String waveDirection;

	@JsonProperty( "waveDirectionDescription" )
	private String waveDirectionDescription;

	@JsonProperty( "wavePeriod" )
	private String wavePeriod;

	@JsonProperty( "seaTemperature" )
	private String seaTemperature;

	@JsonProperty( "temperature" )
	private String temperature;

	@JsonProperty( "stationPressure" )
	private String stationPressure;

	@JsonProperty( "primaryAnemometer" )
	private Wind wind;

	@JsonProperty( "seaCurrents" )
	private SeaCurrents seaCurrents;
}
