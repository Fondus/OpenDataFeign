package tw.fondus.openfeign.cwb.weather.v1.util;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import tw.fondus.openfeign.cwb.weather.v1.dto.rainfall.Rainfall;
import tw.fondus.openfeign.cwb.weather.v1.dto.rainfall.WeatherElement;
import tw.fondus.openfeign.cwb.weather.vo.StationRecord;

/**
 * The extractor for rainfall data.
 * 
 * @author Chao
 *
 */
public class RainfallDataExtractor {
	public static String MISSING_STRING = "-999.0";
	
	public static List<StationRecord> getRecords( Rainfall rainfall, RainfallType rainfallType ) {
		return rainfall.getRecords().getLocations().stream().map( location -> {
			Optional<WeatherElement> optValue = location.getWeatherElements()
					.stream()
					.filter( element -> element.getElementName().equals( rainfallType.getType() ) )
					.findAny();

			if ( optValue.isPresent() ) {
				return StationRecord.builder()
						.id( location.getStationId() )
						.time( location.getTime().getObsTime() )
						.value( optValue.get().getElementValue() )
						.build();
			} else {
				return StationRecord.builder()
						.id( location.getStationId() )
						.time( location.getTime().getObsTime() )
						.value( MISSING_STRING )
						.build();
			}
		} ).collect( Collectors.toList() );
	}
}
