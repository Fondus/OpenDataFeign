package tw.fondus.openfeign.wra.fhy.v1.dto.request;

import feign.QueryMapEncoder;
import feign.codec.EncodeException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The encoder of request query parameters used with WRA FHY REST API.
 *
 * @author Brad Chen
 *
 */
public class QueryOptionsEncoder implements QueryMapEncoder {
	@Override
	public Map<String, Object> encode( Object object ) {
		List<Field> fields = Stream.of( object.getClass().getDeclaredFields() )
				.filter(field -> !field.isSynthetic() )
				.peek(field -> field.setAccessible( true ) )
				.collect( Collectors.toList());

		Map<String, Object> fieldNameToValue = new HashMap<>();
		fields.forEach( field -> {
			try {
				Object value = field.get( object );
				if ( Objects.nonNull( value ) && value != object) {
					String name = "$" + field.getName();
					fieldNameToValue.put( name, value);
				}
			} catch (IllegalAccessException e) {
				throw new EncodeException( "Failure encoding object into query map", e );
			}
		} );
		return fieldNameToValue;
	}
}
