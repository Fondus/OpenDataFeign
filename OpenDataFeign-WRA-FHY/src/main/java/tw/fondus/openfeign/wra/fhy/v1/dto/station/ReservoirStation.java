package tw.fondus.openfeign.wra.fhy.v1.dto.station;

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
public class ReservoirStation extends BasicStation {
	@JsonProperty( "EffectiveCapacity" )
	private BigDecimal effectiveCapacity;

	@JsonProperty( "FullWaterHeight" )
	private BigDecimal fullWaterHeight;

	@JsonProperty( "DeadWaterHeight" )
	private BigDecimal deadWaterHeight;

	@JsonProperty( "Storage" )
	private BigDecimal storage;

	@JsonProperty( "ProtectionFlood" )
	private int protectionFlood = 0;

	@JsonProperty( "HydraulicConstruction" )
	private int hydraulicConstruction = 0;

	@JsonProperty( "Importance" )
	private int importance = 0;
}
