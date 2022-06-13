package tw.fondus.openfeign.cwb.weather.v1.dto.seasurface;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The JSON model of sea currents.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class SeaCurrents {
	@Builder.Default
	@JsonProperty( "Layer" )
	private List<Layer> layers = new ArrayList();
}
