package tw.fondus.openfeign.cwb.weather.v1.dto.seasurface;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The JSON model of sea state location.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class Location {
	@JsonProperty( "station" )
	private Station station;

	@JsonProperty( "stationObsTimes" )
	private StationObsTimes stationObsTimes;
}
