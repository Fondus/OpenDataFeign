package tw.fondus.openfeign.cwb.weather.v1.dto.seasurface;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

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

/**
 * The JSON model of observation.
 * 
 * @author Chao
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class Observation {
	@JsonSerialize( using = TimeSerializer.class )
	@JsonDeserialize( using = TimeDeserializer.class )
	@JsonProperty( "dataTime" )
	private OffsetDateTime time;

	@JsonProperty( "weatherElements" )
	private Attributes attributes;
	
	private static class TimeSerializer extends JsonSerializer<OffsetDateTime> {
		@Override
		public void serialize( OffsetDateTime offsetDateTime, JsonGenerator jsonGenerator,
				SerializerProvider serializerProvider ) throws IOException {
			String time = offsetDateTime.format( DateTimeFormatter.ISO_OFFSET_DATE_TIME );
			jsonGenerator.writeString( time );
		}
	}

	private static class TimeDeserializer extends JsonDeserializer<OffsetDateTime> {
		@Override
		public OffsetDateTime deserialize( JsonParser jsonParser, DeserializationContext deserializationContext )
				throws IOException, JsonProcessingException {
			return OffsetDateTime.parse( jsonParser.getText(), DateTimeFormatter.ISO_OFFSET_DATE_TIME );
		}
	}
}
