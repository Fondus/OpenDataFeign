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
public class ReservoirRealTimeRecordModelTest {
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void test() throws IOException {
		// ShouldDeserialize
		String jsonString = Files.readString( Paths.get( "src/test/resources/json/real-time-record_v1_reservoir.json" ) );
		JsonNode jsonElement = this.mapper.readTree( jsonString );

		ReservoirRealTimeRecord record = this.mapper.readValue( jsonString, ReservoirRealTimeRecord.class );
		Assertions.assertAll( "BasicTypeCheck",
				() -> Assertions.assertEquals( jsonElement.get( "StationNo" ).textValue(), record.getStationId() ),
				() -> Assertions.assertEquals( LocalDateTime.parse( jsonElement.get( "Time" ).textValue() ), record.getTime().toLocalDateTime() )
		);

		Assertions.assertAll( "ActualTypeCheck",
				() -> Assertions.assertEquals( jsonElement.get( "WaterHeight" ).decimalValue(), record.getWaterHeight() ),
				() -> Assertions.assertEquals( jsonElement.get( "EffectiveStorage" ).decimalValue(), record.getEffectiveStorage() ),
				() -> Assertions.assertEquals( jsonElement.get( "PercentageOfStorage" ).decimalValue(), record.getPercentageOfStorage() ),
				() -> Assertions.assertEquals( jsonElement.get( "Status" ).intValue(), record.getStatus() )
		);
	}
}
