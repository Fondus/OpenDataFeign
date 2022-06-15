package tw.fondus.openfeign.cwb.weather.v1.dto.seasurface;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The JSON model of tide and buoy elements.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class WeatherElements {
	@JsonProperty( "TideHeight" )
	private String tideHeight;

	@JsonProperty( "TideLevel" )
	private String tideLevel;

	@JsonProperty( "WaveHeight" )
	private String waveHeight;

	@JsonProperty( "WaveDirection" )
	private String waveDirection;

	@JsonProperty( "WaveDirectionDescription" )
	private String waveDirectionDescription;

	@JsonProperty( "WavePeriod" )
	private String wavePeriod;

	@JsonProperty( "SeaTemperature" )
	private String seaTemperature;

	@JsonProperty( "Temperature" )
	private String temperature;

	@JsonProperty( "StationPressure" )
	private String stationPressure;

	@JsonProperty( "PrimaryAnemometer" )
	private PrimaryAnemometer primaryAnemometer;

	@JsonProperty( "SeaCurrents" )
	private SeaCurrents seaCurrents;
}
