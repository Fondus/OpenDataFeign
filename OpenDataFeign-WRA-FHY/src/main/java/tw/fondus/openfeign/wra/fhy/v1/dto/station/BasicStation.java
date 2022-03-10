package tw.fondus.openfeign.wra.fhy.v1.dto.station;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * The parent class of station data.
 *
 * @author Brad Chen
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class BasicStation {
	@JsonProperty( "Latitude" )
	private BigDecimal latitude;

	@JsonProperty( "Longitude" )
	private BigDecimal longitude;

	@JsonProperty( "BasinNo" )
	private String basinId;

	@JsonProperty( "BasinName" )
	private String basinName;

	@JsonProperty( "StationNo" )
	private String stationId;

	@JsonProperty( "StationName" )
	private String stationName;

	@JsonProperty( "CityCode" )
	private String cityCode;
}
