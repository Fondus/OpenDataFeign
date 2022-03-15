package tw.fondus.openfeign.cwb.weather.vo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The model for stored tide record data.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class TideRecord {
	private String id;
	private OffsetDateTime time;
	private BigDecimal value;
	private String level;
}
