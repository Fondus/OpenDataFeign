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
import tw.fondus.openfeign.cwb.weather.v1.dto.seasurface.SeaState;
import tw.fondus.openfeign.cwb.weather.vo.TideRecord;

/**
 * The unit test of tide extractor.
 * 
 * @author Chao
 *
 */
@SpringBootTest( classes = { TestApplication.class } )
public class TideDataExtractorTest {
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void test() throws IOException {
		String jsonString = Files.readString( Paths.get( "src/test/resources/json/SeaState.json" ) );
		SeaState seaState = this.mapper.readValue( jsonString, SeaState.class );

		List<TideRecord> records = TideDataExtractor.getRecords( seaState );
		Assertions.assertAll( "Tide record test", () -> Assertions.assertEquals(
				seaState.getRecords().getSeaSurfaceObs().getLocations().get( 0 ).getStationObsTimes().getList().size(),
				records.size() ),
				() -> Assertions.assertEquals( seaState.getRecords()
						.getSeaSurfaceObs()
						.getLocations()
						.get( 0 )
						.getStationObsTimes()
						.getList()
						.get( 0 )
						.getWeatherElements()
						.getTideLevel(), records.get( 0 ).getLevel() ) );
	}

}
