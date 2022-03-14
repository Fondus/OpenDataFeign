package tw.fondus.openfeign.cwb.weather.v1.util;

import java.math.BigDecimal;
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
	public static BigDecimal MISSING_VALUE = new BigDecimal( "-999.0" );
	
	/**
	 * Extract rainfall data to station record.
	 * 
	 * @param rainfall rainfall data
	 * @param rainfallType extract rainfall value type
	 * @return
	 */
	public static List<StationRecord> getRecords( Rainfall rainfall, RainfallType rainfallType ) {
		return rainfall.getRecords().getLocations().stream().map( location -> {
			Optional<WeatherElement> optValue = location.getWeatherElements()
					.stream()
					.filter( element -> element.getElementName().equals( rainfallType.getType() ) )
					.findAny();
			return StationRecord.builder()
					.id( location.getStationId() )
					.time( location.getTime().getObsTime() )
					.value( optValue.map( element -> new BigDecimal( element.getElementValue() ) )
							.orElse( MISSING_VALUE ) )
					.build();
		} ).collect( Collectors.toList() );
	}
}
