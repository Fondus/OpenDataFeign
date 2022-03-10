package tw.fondus.openfeign.wra.fhy.v1.dto.record;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * The parent model of real-time record.
 *
 * @author Brad Chen
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class BasicRealTimeRecord {
	@JsonProperty( "StationNo" )
	private String stationId;

	@JsonSerialize( using = TimeSerializer.class )
	@JsonDeserialize( using = TimeDeserializer.class )
	@JsonProperty( "Time" )
	private OffsetDateTime time;

	private static class TimeSerializer extends JsonSerializer<OffsetDateTime> {
		@Override
		public void serialize( OffsetDateTime offsetDateTime, JsonGenerator jsonGenerator,
				SerializerProvider serializerProvider ) throws IOException {
			String time = offsetDateTime.format( DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss" ) );
			jsonGenerator.writeString( time );
		}
	}

	private static class TimeDeserializer extends JsonDeserializer<OffsetDateTime> {
		@Override
		public OffsetDateTime deserialize( JsonParser jsonParser, DeserializationContext deserializationContext )
				throws IOException, JsonProcessingException {
			LocalDateTime localDateTime = LocalDateTime.parse( jsonParser.getText() );
			return OffsetDateTime.of( localDateTime, ZoneOffset.ofHours( 8 ) );
		}
	}
}
