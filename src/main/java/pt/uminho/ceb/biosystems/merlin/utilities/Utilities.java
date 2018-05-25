package pt.uminho.ceb.biosystems.merlin.utilities;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;

import pt.uminho.ceb.biosystems.merlin.utilities.io.FileUtils;
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
	 * retrieve merlin current version
	 * 
	 * @return
	 */
	public static String getMerlinVersion(){
		
		List<String> readerConfFile = null;
		String merlinVersion = null;
		try {
			String path = FileUtils.getConfFolderPath().concat("workbench.conf");
			readerConfFile = FileUtils.readLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int i = 0;
		while(i<readerConfFile.size() && merlinVersion==null){
//		for(String line : readerConfFile)
			String line = readerConfFile.get(i);
			if(line.trim().startsWith("#merlin-version")){
				merlinVersion = line.split(":")[1].trim();
//				break;
			}
			i++;
		}
		return merlinVersion;
	}
}
