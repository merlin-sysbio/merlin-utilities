package pt.uminho.sysbio.merlin.utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utilities {

	/**
	 * @param value
	 * @param places
	 * @return
	 */
	public static double round(double value, int places) {
		
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	/**
	 * @param value
	 * @param places
	 * @return
	 */
	public static String round(String value, int places) {
		
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return String.valueOf(bd.doubleValue());
	}
}
