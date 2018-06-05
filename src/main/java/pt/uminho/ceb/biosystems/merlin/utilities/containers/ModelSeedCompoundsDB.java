package pt.uminho.ceb.biosystems.merlin.utilities.containers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pt.uminho.ceb.biosystems.merlin.utilities.Utilities;
import pt.uminho.ceb.biosystems.merlin.utilities.io.FileUtils;


public class ModelSeedCompoundsDB {

	private Map<String, ArrayList<String>> compoundsDB;


	public ModelSeedCompoundsDB(){

		this.compoundsDB = new HashMap<String, ArrayList<String>>();

		readCompoundsDBFile();
	}



	/**
	 * reader for modelSeed compounds database '.tsv' file 
	 * @return
	 */
	public void readCompoundsDBFile() {

		String filePath = FileUtils.getConfFolderPath().concat("ModelSeedCompounds.tsv");
		String httpFileUrl = "https://raw.githubusercontent.com/ModelSEED/ModelSEEDDatabase/master/Biochemistry/compounds.tsv";

		List<String> compoundsList = new ArrayList<>();

		try {
			if(new File(filePath).exists())
				compoundsList = FileUtils.readLines(filePath);
			else
				compoundsList = Utilities.getFileFromHttpUrl(httpFileUrl);
		} 

		catch (IOException e) {
			e.printStackTrace();
		} 
		parseCompoundsFile(compoundsList);
	}


	/**
	 * @param compoundsList
	 */
	public void parseCompoundsFile(List<String> compoundsList){

		for(String line : compoundsList){

			ArrayList<String> compoundInfo = new ArrayList<>();

			String[] infoList = line.split("\t");

			for(int i=1 ; i<8 ; i++)
				compoundInfo.add(infoList[i]);

			this.compoundsDB.put(infoList[0], compoundInfo);
		}
	}


	/**
	 * verify if a given compoundID is present in ModelSeed Compound tsv file
	 * 
	 * @param compoundID
	 * @return
	 */
	public boolean existsCompoundID(String compoundID){

		if(this.compoundsDB.containsKey(compoundID))
			return true;

		return false;
	}


	/**
	 * method to get compound name
	 * @param compoundID
	 * @return
	 */
	public String getCompoundName(String compoundID){

		return this.compoundsDB.get(compoundID).get(1);
	}

	/**
	 * method to get compound abbreviation
	 * @param compoundID
	 * @return
	 */
	public String getCompoundAbbreviation(String compoundID){

		return this.compoundsDB.get(compoundID).get(0);	

	}

	/**
	 * method to get compound formula
	 * @param compoundID
	 * @return
	 */
	public String getCompoundFormula(String compoundID){

		return this.compoundsDB.get(compoundID).get(2);	
	}
	
	/**
	 * method to get compound charge
	 * @param compoundID
	 * @return
	 */
	public String getCompoundCharge(String compoundID){

		return this.compoundsDB.get(compoundID).get(6);	
	}

	/**
	 * method to get compound molecular weight
	 * @param compoundID
	 * @return
	 */
	public String getCompoundMolecularWeight(String compoundID){

		return this.compoundsDB.get(compoundID).get(3);
	}

	/**
	 * method to get compound Inchikey
	 * @param compoundID
	 * @return
	 */
	public String getCompoundInchikey(String compoundID){

		return this.compoundsDB.get(compoundID).get(5);
	}
}
