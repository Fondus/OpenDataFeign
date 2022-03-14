package tw.fondus.openfeign.cwb.weather.v1.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import tw.fondus.openfeign.cwb.weather.TestApplication;
import tw.fondus.openfeign.cwb.weather.v1.dto.rainfall.Rainfall;
import tw.fondus.openfeign.cwb.weather.vo.StationRecord;

/**
 * The unit test of rainfall utils.
 * 
 * @author Chao
 *
 */
@SpringBootTest( classes = { TestApplication.class } )
public class RainfallDataExtractorTest {
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void test() throws IOException {
		String jsonString = Files.readString( Paths.get( "src/test/resources/json/Rainfall.json" ) );
		Rainfall rainfall = this.mapper.readValue( jsonString, Rainfall.class );

		List<StationRecord> records = RainfallDataExtractor.getRecords( rainfall, RainfallType.HOUR01 );
		Assertions.assertAll( "Station record test",
				() -> Assertions.assertEquals( rainfall.getRecords().getLocations().size(), records.size() ),
				() -> Assertions.assertEquals( rainfall.getRecords()
						.getLocations()
						.get( 0 )
						.getWeatherElements()
						.stream()
						.filter( element -> element.getElementName().equals( RainfallType.HOUR01.getType() ) )
						.findAny()
						.get()
						.getElementValue(), records.get( 0 ).getValue().toString() ) );
	}

}
