package tw.fondus.openfeign.cwb.weather.autoconfigure;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * The configuration of cwb weather feign.
 * 
 * @author Chao
 *
 */
@EnableFeignClients( basePackages = {
		"tw.fondus.openfeign.cwb.weather"
})
@Configuration
public class CwbWeatherFeignAutoConfiguration {

}
