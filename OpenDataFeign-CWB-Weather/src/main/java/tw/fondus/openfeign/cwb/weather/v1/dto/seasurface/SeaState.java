package tw.fondus.openfeign.cwb.weather.v1.dto.seasurface;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The JSON model data set of tide and buoy.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class SeaState {
	@JsonProperty( "Success" )
	private String success;
	
	@JsonProperty( "Records" )
	private Records records;
}

