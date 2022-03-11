package tw.fondus.openfeign.cwb.weather.v1.dto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.fondus.openfeign.cwb.weather.TestApplication;
import tw.fondus.openfeign.cwb.weather.v1.dto.rainfall.Rainfall;

/**
 * The test of rainfall model.
 * 
 * @author Chao
 *
 */
@SpringBootTest( classes = { TestApplication.class } )
public class RainfallModelTest {
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void test() throws IOException {
		String jsonString = Files.readString( Paths.get( "src/test/resources/json/Rainfall.json" ) );
		JsonNode jsonElement = this.mapper.readTree( jsonString );
		Optional<JsonNode> optLocation = Optional.ofNullable( jsonElement.get( "records" ).get( "location" ).get( 0 ) );
		Assertions.assertAll( "Location object check", () -> Assertions.assertTrue( optLocation.isPresent() ) );

		Rainfall rainfall = this.mapper.readValue( jsonString, Rainfall.class );
		JsonNode location = optLocation.get();
		Assertions.assertAll( "BasicTypeCheck",
				() -> Assertions.assertEquals(
						LocalDateTime.parse( location.get( "time" ).get( "obsTime" ).textValue(),
								DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss" ) ),
						rainfall.getRecords().getLocations().get( 0 ).getTime().getObsTime().toLocalDateTime() ),
				() -> Assertions.assertEquals( location.get( "stationId" ).textValue(),
						rainfall.getRecords().getLocations().get( 0 ).getStationId() ),
				() -> Assertions.assertEquals( location.get( "locationName" ).textValue(),
						rainfall.getRecords().getLocations().get( 0 ).getLocationName() ),
				() -> Assertions.assertEquals(
						location.get( "weatherElement" ).get( 0 ).get( "elementName" ).textValue(),
						rainfall.getRecords().getLocations().get( 0 ).getWeatherElements().get( 0 ).getElementName() ),
				() -> Assertions.assertEquals(
						location.get( "weatherElement" ).get( 0 ).get( "elementValue" ).textValue(),
						rainfall.getRecords().getLocations().get( 0 ).getWeatherElements().get( 0 ).getElementValue() ) );
	}
}
