package org.vipcube.openfeign.wra.fhy.v1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.vipcube.openfeign.wra.fhy.TestApplication;
import org.vipcube.openfeign.wra.fhy.v1.dto.request.QueryOptions;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The end-to-end test of WraFhyV1FeignClient.
 *
 * @author Brad Chen
 *
 */
@Disabled
public class WraFhyV1FeignClientTest {
	private final ApplicationContextRunner runner = new ApplicationContextRunner()
			.withConfiguration( AutoConfigurations.of( TestApplication.class ) );

	private final static QueryOptions DEFAULT_QUERY_OPTIONS = QueryOptions.builder()
			.top( 10 )
			.build();

	// Rainfall
	@Test
	public void testGetRainfallStations(){
		this.runner.run( context ->
				assertThat( context )
						.getBean( WraFhyV1FeignClient.class )
						.extracting( WraFhyV1FeignClient::getRainfallStations )
						.matches( response -> !response.isEmpty() )
		);
	}

	@Test
	public void testGetRainfallStationsOptions(){
		this.runner.run( context ->
				assertThat( context )
						.getBean( WraFhyV1FeignClient.class )
						.extracting( client -> client.getRainfallStations( DEFAULT_QUERY_OPTIONS ) )
						.matches( response -> response.size() == 10 )
		);
	}

	@Test
	public void testGetRainfallRealTimeRecords(){
		this.runner.run( context ->
				assertThat( context )
						.getBean( WraFhyV1FeignClient.class )
						.extracting( WraFhyV1FeignClient::getRainfallRealTimeRecords )
						.matches( response -> !response.isEmpty() )
		);
	}

	@Test
	public void testGetRainfallRealTimeRecordsOptions(){
		this.runner.run( context ->
				assertThat( context )
						.getBean( WraFhyV1FeignClient.class )
						.extracting( client -> client.getRainfallRealTimeRecords( DEFAULT_QUERY_OPTIONS ) )
						.matches( response -> response.size() == 10 )
		);
	}

	// Waterlevel
	@Test
	public void testGetWaterlevelStations(){
		this.runner.run( context ->
				assertThat( context )
						.getBean( WraFhyV1FeignClient.class )
						.extracting( WraFhyV1FeignClient::getWaterlevelStations )
						.matches( response -> !response.isEmpty() )
		);
	}

	@Test
	public void testGetWaterlevelStationsOptions(){
		this.runner.run( context ->
				assertThat( context )
						.getBean( WraFhyV1FeignClient.class )
						.extracting( client -> client.getWaterlevelStations( DEFAULT_QUERY_OPTIONS ) )
						.matches( response -> response.size() == 10 )
		);
	}

	@Test
	public void testGetWaterlevelRealTimeRecords(){
		this.runner.run( context ->
				assertThat( context )
						.getBean( WraFhyV1FeignClient.class )
						.extracting( WraFhyV1FeignClient::getWaterlevelRealTimeRecords )
						.matches( response -> !response.isEmpty() )
		);
	}

	@Test
	public void testGetWaterlevelRealTimeRecordsOptions(){
		this.runner.run( context ->
				assertThat( context )
						.getBean( WraFhyV1FeignClient.class )
						.extracting( client -> client.getWaterlevelRealTimeRecords( DEFAULT_QUERY_OPTIONS ) )
						.matches( response -> response.size() == 10 )
		);
	}

	// Waterlevel
	@Test
	public void testGetReservoirStations(){
		this.runner.run( context ->
				assertThat( context )
						.getBean( WraFhyV1FeignClient.class )
						.extracting( WraFhyV1FeignClient::getReservoirStations )
						.matches( response -> !response.isEmpty() )
		);
	}

	@Test
	public void testGetReservoirStationsOptions(){
		this.runner.run( context ->
				assertThat( context )
						.getBean( WraFhyV1FeignClient.class )
						.extracting( client -> client.getReservoirStations( DEFAULT_QUERY_OPTIONS ) )
						.matches( response -> response.size() == 10 )
		);
	}

	@Test
	public void testGetReservoirRealTimeRecords(){
		this.runner.run( context ->
				assertThat( context )
						.getBean( WraFhyV1FeignClient.class )
						.extracting( WraFhyV1FeignClient::getReservoirRealTimeRecords )
						.matches( response -> !response.isEmpty() )
		);
	}

	@Test
	public void testGetReservoirRealTimeRecordsOptions(){
		this.runner.run( context ->
				assertThat( context )
						.getBean( WraFhyV1FeignClient.class )
						.extracting( client -> client.getReservoirRealTimeRecords( DEFAULT_QUERY_OPTIONS ) )
						.matches( response -> response.size() == 10 )
		);
	}
}
