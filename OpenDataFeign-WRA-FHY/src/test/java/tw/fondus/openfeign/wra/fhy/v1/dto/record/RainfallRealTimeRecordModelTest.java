package tw.fondus.openfeign.wra.fhy.v1.dto.record;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.fondus.openfeign.wra.fhy.TestApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@SpringBootTest( classes = { TestApplication.class } )
public class RainfallRealTimeRecordModelTest {
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void test() throws IOException {
		// ShouldDeserialize
		String jsonString = Files.readString( Paths.get("src/test/resources/json/real-time-record_v1_rainfall.json" ) );
		JsonNode jsonElement = this.mapper.readTree( jsonString );

		RainfallRealTimeRecord record = this.mapper.readValue( jsonString, RainfallRealTimeRecord.class );
		Assertions.assertAll( "BasicTypeCheck",
				() -> Assertions.assertEquals( jsonElement.get( "StationNo" ).textValue(), record.getStationId() ),
				() -> Assertions.assertEquals( LocalDateTime.parse( jsonElement.get( "Time" ).textValue() ), record.getTime().toLocalDateTime() )
		);

		Assertions.assertAll( "ActualTypeCheck",
				() -> Assertions.assertEquals( jsonElement.get( "M10" ).decimalValue(), record.getRainfall10Minute() ),
				() -> Assertions.assertEquals( jsonElement.get( "H1" ).decimalValue(), record.getRainfall01Hour() ),
				() -> Assertions.assertEquals( jsonElement.get( "H3" ).decimalValue(), record.getRainfall03Hour() ),
				() -> Assertions.assertEquals( jsonElement.get( "H6" ).decimalValue(), record.getRainfall06Hour() ),
				() -> Assertions.assertEquals( jsonElement.get( "H12" ).decimalValue(), record.getRainfall12Hour() ),
				() -> Assertions.assertEquals( jsonElement.get( "H24" ).decimalValue(), record.getRainfall24Hour() )
		);
	}
}
