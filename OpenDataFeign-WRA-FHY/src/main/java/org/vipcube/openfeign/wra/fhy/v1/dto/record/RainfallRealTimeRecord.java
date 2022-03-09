package org.vipcube.openfeign.wra.fhy.v1.dto.record;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * The model of rainfall real-time record.
 *
 * @author Brad Chen
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
@ToString( callSuper = true )
@EqualsAndHashCode( callSuper = true )
public class RainfallRealTimeRecord extends BasicRealTimeRecord {
	@JsonProperty( "M10" )
	private BigDecimal rainfall10Minute;

	@JsonProperty( "H1" )
	private BigDecimal rainfall01Hour;

	@JsonProperty( "H3" )
	private BigDecimal rainfall03Hour;

	@JsonProperty( "H6" )
	private BigDecimal rainfall06Hour;

	@JsonProperty( "H12" )
	private BigDecimal rainfall12Hour;

	@JsonProperty( "H24" )
	private BigDecimal rainfall24Hour;
}
