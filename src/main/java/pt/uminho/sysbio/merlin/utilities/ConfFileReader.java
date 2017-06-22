package pt.uminho.sysbio.merlin.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfFileReader {

	public static Map<String,String> loadConf(String path) throws IOException{
		
		HashMap<String, String> conf = new HashMap<String,String>();
		
		File file = new File(path);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

		String text, key, value;
		while ((text = bufferedReader.readLine()) != null) {
			if(text.toLowerCase().matches("^[a-z].*")){
				text = text.replaceAll("\\s","");
				key = text.split(":")[0];
				value = text.split(":")[1];
				
				conf.put(key,value);
			}
		}
		bufferedReader.close();
		
		if(conf.isEmpty()){
			throw new IOException("required configuration file is empty!! check "+path);
		}
		return conf;
	}
}
