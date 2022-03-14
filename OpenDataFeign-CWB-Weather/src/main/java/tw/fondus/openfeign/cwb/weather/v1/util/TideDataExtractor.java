package tw.fondus.openfeign.cwb.weather.v1.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import tw.fondus.openfeign.cwb.weather.v1.dto.seasurface.SeaState;
import tw.fondus.openfeign.cwb.weather.vo.TideRecord;

/**
 * The extractor for tide data.
 * 
 * @author Chao
 *
 */
public class TideDataExtractor {
	
	/**
	 * Extract tide data to tide record with only id, time, value and level.
	 * 
	 * @param seaState sea state data
	 * @return
	 */
	public static List<TideRecord> getRecords( SeaState seaState ) {
		List<TideRecord> records = new ArrayList<>();
		seaState.getRecords()
				.getSeaSurfaceObs()
				.getLocations()
				.stream()
				.filter( location -> Optional
						.ofNullable( location.getStationObsTimes().getList().get( 0 ).getWeatherElements().getTideLevel() )
						.isPresent() )
				.forEach( location -> {
					records.addAll( location.getStationObsTimes()
							.getList()
							.stream()
							.map( obs -> TideRecord.builder()
									.id( location.getStation().getStationID() )
									.time( obs.getDataTime() )
									.value( new BigDecimal( obs.getWeatherElements().getTideHeight() ) )
									.level( obs.getWeatherElements().getTideLevel() )
									.build() )
							.collect( Collectors.toList() ) );
				} );
		
		return records;
	}
}
