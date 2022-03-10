package org.vipcube.openfeign.wra.fhy.v1.dto.record;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * The model of reservoir real-time record.
 *
 * @author Brad Chen
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
@ToString( callSuper = true )
@EqualsAndHashCode( callSuper = true )
public class ReservoirRealTimeRecord extends BasicRealTimeRecord {
	@JsonProperty( "AccumulatedRainfall" )
	private BigDecimal rainfallAccumulated;

	@JsonProperty( "WaterHeight" )
	private BigDecimal waterHeight;

	@JsonProperty( "EffectiveCapacity" )
	private BigDecimal effectiveCapacity;

	@JsonProperty( "EffectiveStorage" )
	private BigDecimal effectiveStorage;

	@JsonProperty( "PercentageOfStorage" )
	private BigDecimal percentageOfStorage;

	@JsonProperty( "OperationalStorage" )
	private BigDecimal operationalStorage;

	@JsonProperty( "Inflow" )
	private BigDecimal flowIn;

	@JsonProperty( "Outflow" )
	private BigDecimal flowOut;

	@JsonProperty( "Status" )
	private int status = -1;

	@JsonProperty( "NextSpillTime" )
	private OffsetDateTime nextSpillTime;

	@JsonProperty( "Discharge" )
	private BigDecimal discharge;

	@JsonProperty( "DischargeOfProtectionFlood" )
	private BigDecimal dischargeOfProtectionFlood;

	@JsonProperty( "DischargeOfEscapeSand" )
	private BigDecimal dischargeOfEscapeSand;

	@JsonProperty( "DischargeOfHydroelectric" )
	private BigDecimal dischargeOfHydroelectric;

	@JsonProperty( "DischargeOfOthers" )
	private BigDecimal dischargeOfOthers;
}
