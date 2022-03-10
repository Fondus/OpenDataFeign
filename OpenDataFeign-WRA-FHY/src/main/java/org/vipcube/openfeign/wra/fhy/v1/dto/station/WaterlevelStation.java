package org.vipcube.openfeign.wra.fhy.v1.dto.station;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString( callSuper = true )
@EqualsAndHashCode( callSuper = true )
public class WaterlevelStation extends BasicStation {
	@JsonProperty( "Address" )
	private String address;

	@JsonProperty( "WarningLevel1" )
	private BigDecimal warningLevel1;

	@JsonProperty( "WarningLevel2" )
	private BigDecimal warningLevel2;

	@JsonProperty( "WarningLevel3" )
	private BigDecimal warningLevel3;

	@JsonProperty( "TopLevel" )
	private BigDecimal topLevel;

	@JsonProperty( "PlanFloodLevel" )
	private BigDecimal planFloodLevel;
}
