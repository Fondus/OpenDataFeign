package tw.fondus.openfeign.wra.fhy.v1.dto.record;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * The model of waterlevel real-time record.
 *
 * @author Brad Chen
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
@ToString( callSuper = true )
@EqualsAndHashCode( callSuper = true )
public class WaterlevelRealTimeRecord extends BasicRealTimeRecord {
	@JsonProperty( "WaterLevel" )
	private BigDecimal level;
}
