package tw.fondus.openfeign.cwb.weather.v1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.fondus.openfeign.cwb.weather.v1.dto.rainfall.Rainfall;
import tw.fondus.openfeign.cwb.weather.v1.dto.seasurface.SeaState;

/**
 * The open feign client of CWB weather API.
 *
 * @author Chao
 *
 */
@FeignClient(
		name= "opendata-cwb-weather",
		url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore"
)
public interface CwbWeatherFeignClient {
	/**
	 * Get tide and buoy data.
	 * 
	 * @param token cwb opendata token
	 * @return
	 */
	@GetMapping( value = "O-B0075-001", produces = MediaType.APPLICATION_JSON_VALUE )
	SeaState getSeaState( @RequestParam( "Authorization" ) String token );
	
	/**
	 * Get rainfall data.
	 * 
	 * @param token cwb opendata token
	 * @return
	 */
	@GetMapping( value = "O-A0002-001", produces = MediaType.APPLICATION_JSON_VALUE )
	Rainfall getRainfall( @RequestParam( "Authorization" ) String token );
}
