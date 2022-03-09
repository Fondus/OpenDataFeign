package org.vipcube.openfeign.wra.fhy.v1.dto.record;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

/**
 * The parent model of real-time record.
 *
 * @author Brad Chen
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class BasicRealTimeRecord {
	@JsonProperty( "StationNo" )
	private String stationId;

	@JsonProperty( "Time" )
	private OffsetDateTime time;
}
