package tw.fondus.openfeign.cwb.weather.v1.dto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.fondus.openfeign.cwb.weather.TestApplication;
import tw.fondus.openfeign.cwb.weather.v1.dto.seasurface.SeaState;

/**
 * The test of sea state model.
 * 
 * @author Chao
 *
 */
@SpringBootTest( classes = { TestApplication.class } )
public class SeaStateModelTest {
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void test() throws IOException {
		String jsonString = Files.readString( Paths.get( "src/test/resources/json/SeaState.json" ) );
		JsonNode jsonElement = this.mapper.readTree( jsonString );
		Optional<JsonNode> optLocation = Optional
				.ofNullable( jsonElement.get( "records" ).get( "seaSurfaceObs" ).get( "location" ).get( 0 ) );
		Assertions.assertAll( "Location object check", () -> Assertions.assertTrue( optLocation.isPresent() ) );

		SeaState seaState = this.mapper.readValue( jsonString, SeaState.class );
		JsonNode location = optLocation.get();
		Assertions.assertAll( "BasicTypeCheck",
				() -> Assertions.assertEquals( location.get( "station" ).get( "stationID" ).textValue(),
						seaState.getRecords().getSeaSurfaceObs().getLocations().get( 0 ).getStation().getStationID() ),
				() -> Assertions.assertEquals(
						OffsetDateTime.parse( location.get( "stationObsTimes" )
								.get( "stationObsTime" )
								.get( 0 )
								.get( "dataTime" )
								.textValue() ),
						seaState.getRecords()
								.getSeaSurfaceObs()
								.getLocations()
								.get( 0 )
								.getStationObsTimes()
								.getList()
								.get( 0 )
								.getDataTime() ),
				() -> Assertions.assertEquals(
						location.get( "stationObsTimes" )
								.get( "stationObsTime" )
								.get( 0 )
								.get( "weatherElements" )
								.get( "tideHeight" )
								.textValue(),
						seaState.getRecords()
								.getSeaSurfaceObs()
								.getLocations()
								.get( 0 )
								.getStationObsTimes()
								.getList()
								.get( 0 )
								.getWeatherElements()
								.getTideHeight() ),
				() -> Assertions.assertEquals(
						location.get( "stationObsTimes" )
								.get( "stationObsTime" )
								.get( 0 )
								.get( "weatherElements" )
								.get( "tideLevel" )
								.textValue(),
						seaState.getRecords()
								.getSeaSurfaceObs()
								.getLocations()
								.get( 0 )
								.getStationObsTimes()
								.getList()
								.get( 0 )
								.getWeatherElements()
								.getTideLevel() ) );
	}
}
