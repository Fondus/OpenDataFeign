package tw.fondus.openfeign.cwb.weather.v1.util;

/**
 * The rainfall data type for cwb weather opendata.
 * 
 * @author Chao
 *
 */
public enum RainfallType {
	ELEVATION( "ELEV" ),
	MINUTE10( "MIN_10" ),
	HOUR01( "RAIN" ),
	HOUR03( "HOUR_3" ),
	HOUR06( "HOUR_6" ),
	HOUR12( "HOUR_12" ),
	HOUR24( "HOUR_24" ),
	DAY_CURRENT( "NOW" ),
	LATEST2DAY( "latest_2days" ),
	LATEST3DAY( "latest_3days" );

	private final String type;

	RainfallType(String type) {
		this.type = type;
	}

	/**
	 * Get the rainfall type.
	 * 
	 * @return rainfall type
	 */
	public String getType() {
		return type;
	}
}
