package tw.fondus.openfeign.cwb.weather.v1.dto.rainfall;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The JSON model of rainfall records.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class Records {
	@Builder.Default
	@JsonProperty( "location" )
	private List<Location> locations = new ArrayList();
}
