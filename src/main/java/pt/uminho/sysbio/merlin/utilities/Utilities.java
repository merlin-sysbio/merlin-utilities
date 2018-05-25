package pt.uminho.sysbio.merlin.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Set;

import pt.uminho.ceb.biosystems.mew.utilities.datastructures.pair.Pair;

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

	/**
	 * Parse boolean rules to string.
	 * 
	 * @param new_rules
	 * @return
	 */
	public static String parseRuleToString(Set<Set<String>> new_rules) {

		String ret = "";
		boolean not_first_or = false;
		
		for(Set<String> rules : new_rules) {

			if(not_first_or)
				ret = ret.concat(" OR ");

			boolean not_first_and = false;

			for(String new_rule : rules) {	

				if(not_first_and)
					ret = ret.concat(" AND ");

				ret = ret.concat(new_rule);

				not_first_and = true;
			}

			not_first_or = true;
		}
		return ret;
	}
	
	/**
	 * Parse boolean rules to string.
	 * 
	 * @param new_rules
	 * @return
	 */
	public static String parseRuleListToString(List<List<Pair<String,String>>> new_rules) {

		String ret = "";
		boolean not_first_or = false;
		
		for(List<Pair<String,String>> rules : new_rules) {

			if(not_first_or)
				ret = ret.concat(" OR ");

			boolean not_first_and = false;

			for(Pair<String,String> new_rule : rules) {	

				if(not_first_and)
					ret = ret.concat(" AND ");

				ret = ret.concat(new_rule.getA());
				
//				if(new_rule.getB() != null && !new_rule.getB().isEmpty())
//					ret = ret.concat(" (").concat(new_rule.getB()).concat(")");

				not_first_and = true;
			}

			not_first_or = true;
		}
		return ret;
	}
	
	
	/**
	 * @param url
	 * @param savePath
	 * @throws IOException 
	 */
	public void downloadFileFromHttpUrl(String httpUrl, String savePath) throws IOException{
		
		int BUFFER_SIZE = 4096;  
		
		URL u = new URL (httpUrl);
		HttpURLConnection huc =  ( HttpURLConnection )  u.openConnection (); 
		huc.setRequestMethod ("HEAD"); 
		HttpURLConnection.setFollowRedirects(false);
		huc.connect () ; 
		int code = huc.getResponseCode();

		if(code == HttpURLConnection.HTTP_OK){

			URL url = new URL(httpUrl);
			URLConnection conn = url.openConnection();
			InputStream inputStream = conn.getInputStream();
			

			FileOutputStream outputStream = new FileOutputStream(savePath);

			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			
			outputStream.close();
			inputStream.close();
		} 
	}
}
