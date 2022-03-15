package tw.fondus.openfeign.cwb.weather.v1.dto.rainfall;

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
public class Rainfall {
	@JsonProperty( "success" )
	private String success;
	
	@JsonProperty( "records" )
	private Records records;
}

