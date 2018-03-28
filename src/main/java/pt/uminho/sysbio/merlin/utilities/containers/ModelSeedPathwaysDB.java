package pt.uminho.sysbio.merlin.utilities.containers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pt.uminho.ceb.biosystems.mew.utilities.io.FileUtils;

public class ModelSeedPathwaysDB {

	private Map<String, ArrayList<String>> keggPathwaysDB;
	//	private List<String> keggReactionsList;
	private Map<String, List<String[]>> pathways_hierarchy;
	private Map<String, List<String>> super_pathways;
	private Map<String, List<String>> reactionsPathways;


	public ModelSeedPathwaysDB(){

		this.keggPathwaysDB = new HashMap<String, ArrayList<String>>();
		//		this.keggReactionsList = new ArrayList<>();
		this.reactionsPathways = new HashMap<String, List<String>>();
		this.pathways_hierarchy = new HashMap<String, List<String[]>>();
		this.super_pathways = new HashMap<String,List<String>>();

		readPathwaysDBFiles();
	}



	/**
	 * reader for KEGG pathways database '.tsv' file 
	 * @return
	 */
	public void readPathwaysDBFiles() {

		String keggFilePath = FileUtils.getHomeFolderPath().concat("KEGG_pathways.tsv");
		//		String modelSeedFilePath = FileUtils.getHomeFolderPath().concat("HopeScenarios.tsv");


		List<String> keggPathwaysList = new ArrayList<>();
		//		List<String> modelSeedPathwaysList = new ArrayList<>();


		try {
			keggPathwaysList = FileUtils.readLines(keggFilePath);
			//			modelSeedPathwaysList = FileUtils.readLines(modelSeedFilePath);

		} 

		catch (IOException e) {
			e.printStackTrace();
		} 

		parseKeggPathwaysFile(keggPathwaysList);
	}



	/**
	 * @param pathwayList
	 */
	public void parseKeggPathwaysFile(List<String> pathwayList){

		for(int line = 1 ; line < pathwayList.size(); line++){
			
			ArrayList<String> pathwayInfo = new ArrayList<>();

			String[] infoList = pathwayList.get(line).split("\t");

			Integer pos = 0;
			
			for(int i=2 ; i<infoList.length ; i++){
			
				pathwayInfo.add(infoList[i]);
				pos = i;
			}

			this.keggPathwaysDB.put(infoList[1].substring(3), pathwayInfo);
			
			if(pos>2){

				if(pos==4){
					
					String[] reactions = infoList[4].split("\\|");

					for(String reaction : reactions){

						if(!this.reactionsPathways.containsKey(reaction)){
							List<String> pathway = new ArrayList<>();
							pathway.add(infoList[1].substring(3));
							this.reactionsPathways.put(reaction, pathway);
						}
						else
							this.reactionsPathways.get(reaction).add(infoList[1].substring(3));
					}
				}

				String[] superPathways = infoList[3].split(";");
				
				if(!this.super_pathways.containsKey(superPathways[0])){

					List<String> superpathway = new ArrayList<>();
					superpathway.add(superPathways[1]);
					this.super_pathways.put(superPathways[0], superpathway);
				}
				else
					this.super_pathways.get(superPathways[0]).add(superPathways[1]);
				
				
				String[] pathway = new String[2];
				pathway[0] = infoList[1].substring(3); 
				pathway[1] = infoList[2].replace("\"", "");

				if(!this.pathways_hierarchy.containsKey(superPathways[1])){

					List<String[]> pathways = new ArrayList<>();
					pathways.add(pathway);
					this.pathways_hierarchy.put(superPathways[1], pathways);
				}
				else
					this.pathways_hierarchy.get(superPathways[1]).add(pathway);
			}

		}
	}


	/**
	 * verify the existence of an reactionID in KEGG pathways reactions list
	 * 
	 * @param reactionID
	 * @return boolean
	 */
	public boolean existsReactionIDinKeggPathway(String reactionID){

		if(this.reactionsPathways.containsKey(reactionID))
			return true;

		return false;
	}
	
	/**
	 * @return 
	 * @return
	 */
	public List<String> getReactionPathways(String reactionKeggID){
		
		return this.reactionsPathways.get(reactionKeggID);
	}

	/**
	 * method to get the all reactions for a given pathway
	 * @param pathwayID
	 * @return reactions list
	 */
	public String[] getPathwayReactions(String pathwayID){

		return this.keggPathwaysDB.get(pathwayID).get(2).split("\\|");
	}


	/**
	 * method to get pathway name
	 * @param pathwayID
	 * @return pathwayName
	 */
	public String getPathwayName(String pathwayID){
		
		return this.keggPathwaysDB.get(pathwayID).get(0).replace("\"", "");
	}
	
	
	/**
	 * retrieve all super pathways in Kegg_pathways '.tsv' file
	 * 
	 * @return Map<String, List<String>> superPathways
	 */
	public Map<String, List<String>> getSuperPathways(){
		
		return this.super_pathways;
	}
	
	
	/**
	 * @return
	 */
	public Map<String, List<String[]>> getPathwaysHierarchy(){
		
		return this.pathways_hierarchy;
	}

}
