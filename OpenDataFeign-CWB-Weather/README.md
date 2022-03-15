## CWB open weather data API token
1. Register and login [CWB open weather data](https://opendata.cwb.gov.tw)，
2. The website page will move to API authorization.
```!
If the page did not move to API authorization. You can press MemberInformation(會員資訊) → API authorization(API授權碼) to the page.
```
4. Press the button 'get authorization (取得授權碼)' to get the account authorization.
5. Using the authorization to CWB weather feign client.

```java=
// Fill the authorization to TOKEN
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
```
