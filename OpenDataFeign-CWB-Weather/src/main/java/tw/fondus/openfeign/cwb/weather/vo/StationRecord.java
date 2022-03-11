package tw.fondus.openfeign.cwb.weather.vo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The model for stored record data with id, time and value.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class StationRecord {
	private String id;
	private OffsetDateTime time;
	private String value;
	
	/**
	 * Get big decimal value.
	 * 
	 * @return value
	 */
	public BigDecimal getValue() {
		return new BigDecimal( value );
	}
}
