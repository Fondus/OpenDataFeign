package org.vipcube.openfeign.wra.fhy.v1.dto.station;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vipcube.openfeign.wra.fhy.TestApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest( classes = { TestApplication.class } )
public class WaterlevelStationModelTest {
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void test() throws IOException {
		// ShouldDeserialize
		String jsonString = Files.readString( Paths.get( "src/test/resources/json/station_v1_waterlevel.json" ) );
		JsonNode jsonElement = this.mapper.readTree( jsonString );

		WaterlevelStation station = this.mapper.readValue( jsonString, WaterlevelStation.class );
		Assertions.assertAll( "BasicTypeCheck",
				() -> Assertions.assertEquals( jsonElement.get( "StationNo" ).textValue(), station.getStationId() ),
				() -> Assertions.assertEquals( jsonElement.get( "StationName" ).textValue(), station.getStationName() ),
				() -> Assertions.assertEquals( jsonElement.get( "BasinNo" ).textValue(), station.getBasinId() ),
				() -> Assertions.assertEquals( jsonElement.get( "BasinName" ).textValue(), station.getBasinName() ),
				() -> Assertions.assertEquals( jsonElement.get( "CityCode" ).textValue(), station.getCityCode() ),
				() -> Assertions.assertEquals( jsonElement.get( "Latitude" ).decimalValue(), station.getLatitude() ),
				() -> Assertions.assertEquals( jsonElement.get( "Longitude" ).decimalValue(), station.getLongitude() )
		);

		Assertions.assertAll( "ActualTypeCheck",
				() -> Assertions.assertEquals( jsonElement.get( "WarningLevel1" ).decimalValue(), station.getWarningLevel1() ),
				() -> Assertions.assertEquals( jsonElement.get( "WarningLevel2" ).decimalValue(), station.getWarningLevel2() )
		);
	}
}
