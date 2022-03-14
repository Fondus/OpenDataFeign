package tw.fondus.openfeign.cwb.weather.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import tw.fondus.openfeign.cwb.weather.TestApplication;

/**
 * The end-to-end test of CwbWeatherFeignClient.
 *
 * @author Chao
 *
 */
@Disabled
public class CwbWeatherFeignClientTest {
	private final ApplicationContextRunner runner = new ApplicationContextRunner()
			.withConfiguration( AutoConfigurations.of( TestApplication.class ) );

	private final static String TOKEN = "";

	@Test
	public void testTideAndBuoy() {
		this.runner.run( context -> assertThat( context )
						.getBean( CwbWeatherFeignClient.class )
						.extracting( client -> client.getSeaState( TOKEN ) )
						.matches( response -> response.getSuccess().equals( "true" ) )
		);
	}
	
	@Test
	public void testRainfall() {
		this.runner.run( context -> assertThat( context )
						.getBean( CwbWeatherFeignClient.class )
						.extracting( client -> client.getRainfall( TOKEN ) )
						.matches( response -> response.getSuccess().equals( "true" ) )
		);
	}
}
