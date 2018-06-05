package pt.uminho.ceb.biosystems.merlin.utilities.containers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pt.uminho.ceb.biosystems.merlin.utilities.Utilities;
import pt.uminho.ceb.biosystems.merlin.utilities.io.FileUtils;


public class ModelSeedReactionsDB {
	
	private Map<String, ArrayList<String>> modelSeedReactions;


	public ModelSeedReactionsDB(){

		this.modelSeedReactions = new HashMap<String, ArrayList<String>>();

		readReactionsDBFile();
	}
	
	/**
	 * reader for modelSeed compounds database '.tsv' file 
	 * @return
	 */
	public void readReactionsDBFile() {

		String filePath = FileUtils.getConfFolderPath().concat("ModelSeedReactions.tsv");
		String httpFileUrl = "https://raw.githubusercontent.com/ModelSEED/ModelSEEDDatabase/master/Biochemistry/reactions.tsv";
		
		List<String> reactionsList = new ArrayList<>();

		try {
			if(new File(filePath).exists())
				reactionsList = FileUtils.readLines(filePath);
			else
				reactionsList = Utilities.getFileFromHttpUrl(httpFileUrl);
		} 

		catch (IOException e) {
			e.printStackTrace();
		} 

		parseReactionsFile(reactionsList);
	}


	/**
	 * @param compoundsList
	 */
	public void parseReactionsFile(List<String> reactionsList){

		for(String line : reactionsList){

			ArrayList<String> reactionInfo = new ArrayList<>();

			String[] infoList = line.split("\t");

			reactionInfo.add(infoList[1]); //abbreviation
			reactionInfo.add(infoList[2]); //enzyme name
			reactionInfo.add(infoList[4]); //stoichiometry
			reactionInfo.add(infoList[5]); //isTrasnport
			reactionInfo.add(infoList[7]); //equation
			
			if(infoList[9].equals("="))   //isReversible
				reactionInfo.add(Boolean.toString(true));
			else
				reactionInfo.add(Boolean.toString(false));
			
			reactionInfo.add(infoList[9]); //direction
			reactionInfo.add(infoList[16]); //compounds in reaction
			reactionInfo.add(infoList[19]); //linked reactions
			

			this.modelSeedReactions.put(infoList[0], reactionInfo);
		}
	}


	/**
	 * verify if a given reactionID is present in ModelSeed Reactions tsv file
	 * 
	 * @param reactionID
	 * @return
	 */
	public boolean existsReactionID(String reactionID){

		if(this.modelSeedReactions.containsKey(reactionID))
			return true;

		return false;
	}

	/**
	 * method to get the reaction enzyme name
	 * @param reactionID
	 * @return enzyme name
	 */
	public String getEnzymeName(String reactionID){
		
//		System.out.println(reactionID);
//		System.out.println(modelSeedReactions.get(reactionID));
//		System.out.println(modelSeedReactions.get(reactionID).get(1));

		return this.modelSeedReactions.get(reactionID).get(1);
	}

	/**
	 * method to get reaction abbreviation
	 * @param reactionID
	 * @return reaction abbreviation
	 */
	public String getReactionAbbreviation(String reactionID){

		return this.modelSeedReactions.get(reactionID).get(0);	

	}

	
	/**
	 * @param reactionID
	 * @return
	 */
	public String getReactionStoichiometry(String reactionID){

		return this.modelSeedReactions.get(reactionID).get(2);	
	}

	
	/**
	 * @param reactionID
	 * @return
	 */
	public boolean isTransportReaction(String reactionID){

		return Boolean.parseBoolean(this.modelSeedReactions.get(reactionID).get(3));	
	}
	
	
	/**
	 * @param reactionID
	 * @return
	 */
	public String getReactionEquation(String reactionID){

		return this.modelSeedReactions.get(reactionID).get(4);	
	}
	
	
	/**
	 * @param reactionID
	 * @return
	 */
	public boolean isReactionReversible(String reactionID){

		return Boolean.parseBoolean(this.modelSeedReactions.get(reactionID).get(5));	
	}
	
	
	/**
	 * @param reactionID
	 * @return
	 */
	public String getReactionDirection (String reactionID){

		return this.modelSeedReactions.get(reactionID).get(6);	
	}
	
	
	/**
	 * @param reactionID
	 * @return
	 */
	public String[] getCompoundsInReaction(String reactionID){

		return this.modelSeedReactions.get(reactionID).get(7).split(";");	
	}
	
	
	/**
	 * @param reactionID
	 * @return
	 */
	public String[] getLinkedReactions(String reactionID){
		
		if(this.modelSeedReactions.get(reactionID).get(8).equals("null"))
			return null;

		return this.modelSeedReactions.get(reactionID).get(8).split(";");	
	}
}
