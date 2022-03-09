package org.vipcube.openfeign.wra.fhy.v1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.vipcube.openfeign.wra.fhy.configure.WraFhyFeignConfiguration;
import org.vipcube.openfeign.wra.fhy.v1.dto.record.RainfallRealTimeRecord;
import org.vipcube.openfeign.wra.fhy.v1.dto.record.ReservoirRealTimeRecord;
import org.vipcube.openfeign.wra.fhy.v1.dto.record.WaterlevelRealTimeRecord;
import org.vipcube.openfeign.wra.fhy.v1.dto.request.QueryOptions;
import org.vipcube.openfeign.wra.fhy.v1.dto.station.RainfallStation;
import org.vipcube.openfeign.wra.fhy.v1.dto.station.ReservoirStation;
import org.vipcube.openfeign.wra.fhy.v1.dto.station.WaterlevelStation;

import java.util.List;

/**
 * The open feign client of WRA FHY API.
 *
 * @author Brad Chen
 *
 */
@FeignClient(
		name= "opendata-wra-fhy",
		url = "https://fhy.wra.gov.tw/WraApi/v1",
		configuration = WraFhyFeignConfiguration.class
)
public interface WraFhyV1FeignClient {
	// Rainfall
	/**
	 * Get the rainfall stations.
	 *
	 * @return rainfall stations
	 */
	default List<RainfallStation> getRainfallStations(){
		return this.getRainfallStations( QueryOptions.builder().build() );
	}

	/**
	 * Get the rainfall stations.
	 *
	 * @param queryOptions query options
	 * @return rainfall stations
	 */
	@GetMapping( value = "Rain/Station", produces = MediaType.APPLICATION_JSON_VALUE )
	List<RainfallStation> getRainfallStations( @SpringQueryMap( encoded = true ) QueryOptions queryOptions );

	/**
	 * Get the rainfall real-time records.
	 *
	 * @return rainfall real-time records
	 */
	default List<RainfallRealTimeRecord> getRainfallRealTimeRecords(){
		return this.getRainfallRealTimeRecords( QueryOptions.builder().build() );
	}

	/**
	 * Get the rainfall real-time records.
	 *
	 * @param queryOptions query options
	 * @return rainfall real-time records
	 */
	@GetMapping( value = "Rain/RealTimeInfo", produces = MediaType.APPLICATION_JSON_VALUE )
	List<RainfallRealTimeRecord> getRainfallRealTimeRecords( @SpringQueryMap( encoded = true ) QueryOptions queryOptions );

	// Waterlevel
	/**
	 * Get the waterlevel stations.
	 *
	 * @return waterlevel stations
	 */
	default List<WaterlevelStation> getWaterlevelStations(){
		return this.getWaterlevelStations( QueryOptions.builder().build() );
	}

	/**
	 * Get the waterlevel stations.
	 *
	 * @param queryOptions query options
	 * @return waterlevel stations
	 */
	@GetMapping( value = "Water/Station", produces = MediaType.APPLICATION_JSON_VALUE )
	List<WaterlevelStation> getWaterlevelStations( @SpringQueryMap( encoded = true ) QueryOptions queryOptions );

	/**
	 * Get the waterlevel real-time records.
	 *
	 * @return waterlevel real-time records
	 */
	default List<WaterlevelRealTimeRecord> getWaterlevelRealTimeRecords(){
		return this.getWaterlevelRealTimeRecords( QueryOptions.builder().build() );
	}

	/**
	 * Get the waterlevel real-time records.
	 *
	 * @param queryOptions query options
	 * @return waterlevel real-time records
	 */
	@GetMapping( value = "Water/RealTimeInfo", produces = MediaType.APPLICATION_JSON_VALUE )
	List<WaterlevelRealTimeRecord> getWaterlevelRealTimeRecords( @SpringQueryMap( encoded = true ) QueryOptions queryOptions );

	// Reservoir
	/**
	 * Get the reservoir stations.
	 *
	 * @return reservoir stations
	 */
	default List<ReservoirStation> getReservoirStations(){
		return this.getReservoirStations( QueryOptions.builder().build() );
	}

	/**
	 * Get the reservoir stations.
	 *
	 * @param queryOptions query options
	 * @return reservoir stations
	 */
	@GetMapping( value = "Reservoir/Station", produces = MediaType.APPLICATION_JSON_VALUE )
	List<ReservoirStation> getReservoirStations( @SpringQueryMap( encoded = true ) QueryOptions queryOptions );

	/**
	 * Get the reservoir real-time records.
	 *
	 * @return reservoir real-time records
	 */
	default List<ReservoirRealTimeRecord> getReservoirRealTimeRecords(){
		return this.getReservoirRealTimeRecords( QueryOptions.builder().build() );
	}

	/**
	 * Get the reservoir real-time records.
	 *
	 * @param queryOptions query options
	 * @return reservoir real-time records
	 */
	@GetMapping( value = "/Reservoir/RealTimeInfo", produces = MediaType.APPLICATION_JSON_VALUE )
	List<ReservoirRealTimeRecord> getReservoirRealTimeRecords( @SpringQueryMap( encoded = true ) QueryOptions queryOptions );
}
