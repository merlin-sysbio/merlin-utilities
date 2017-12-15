package pt.uminho.sysbio.merlin.utilities.containers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Oscar
 *
 */
public class MetaboliteContainer {
	
	private String metaboliteID;
	private String name;
	private String formula;
	private String stoichiometric_coefficient;
	private String numberofchains;
	private String compartment_name;
	private String entryID;
	private String molecular_weight;
	private List<String> names;
	private List<String> enzymes;
	private List<String> reactions;
	private Map<String, String> pathways;
	private List<String> dblinks;
	private List<String> same_as;
	
	
	/**
	 * @param entry
	 */
	public MetaboliteContainer(String entryID) {
		this.setEntryID(entryID);
		this.setSame_as(new ArrayList<String>());
	}


	/**
	 * @param metaboliteID
	 * @param name
	 * @param formula
	 * @param stoichiometric_coefficient
	 * @param numberofchains
	 * @param compartment_name
	 */
	public MetaboliteContainer(String metaboliteID, String name, String formula, String stoichiometric_coefficient, String numberofchains, String compartment_name) {
		
		this.setMetaboliteID(metaboliteID);
		this.setFormula(formula);
		this.setName(name);
		this.setStoichiometric_coefficient(stoichiometric_coefficient);
		this.setNumberofchains(numberofchains);
		this.setCompartment_name(compartment_name);
	}

	/**
	 * @return the metaboliteID
	 */
	public String getMetaboliteID() {
		return metaboliteID;
	}

	/**
	 * @param metaboliteID the metaboliteID to set
	 */
	public void setMetaboliteID(String metaboliteID) {
		this.metaboliteID = metaboliteID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the stoichiometric_coefficient
	 */
	public String getStoichiometric_coefficient() {
		return stoichiometric_coefficient;
	}

	/**
	 * @param stoichiometric_coefficient the stoichiometric_coefficient to set
	 */
	public void setStoichiometric_coefficient(String stoichiometric_coefficient) {
		this.stoichiometric_coefficient = stoichiometric_coefficient;
	}

	/**
	 * @return the numberofchains
	 */
	public String getNumberofchains() {
		return numberofchains;
	}

	/**
	 * @param numberofchains the numberofchains to set
	 */
	public void setNumberofchains(String numberofchains) {
		this.numberofchains = numberofchains;
	}

	/**
	 * @return the compartment_name
	 */
	public String getCompartment_name() {
		return compartment_name;
	}

	/**
	 * @param compartment_name the compartment_name to set
	 */
	public void setCompartment_name(String compartment_name) {
		this.compartment_name = compartment_name;
	}

	/**
	 * @return the entryID
	 */
	public String getEntryID() {
		return entryID;
	}

	/**
	 * @param entryID the entryID to set
	 */
	public void setEntryID(String kegg_id) {
		this.entryID = kegg_id;
	}

	/**
	 * @return the formula
	 */
	public String getFormula() {
		return formula;
	}

	/**
	 * @param formula the formula to set
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}

	@Override
	public String toString() {
		return "MetaboliteContainer [metaboliteID=" + metaboliteID + ", name="
				+ name + ", formula=" + formula
				+ ", stoichiometric_coefficient=" + stoichiometric_coefficient
				+ ", numberofchains=" + numberofchains + ", compartment_name="
				+ compartment_name + ", entryID=" + entryID + "]";
	}


	/**
	 * @return the same_as
	 */
	public List<String> getSame_as() {
		return same_as;
	}


	/**
	 * @param same_as the same_as to set
	 */
	public void setSame_as(List<String> same_as) {
		this.same_as = same_as;
	}
	
	
	/**
	 * @param same_as
	 */
	public void setSame_as(String same_as) {
		this.same_as.add(same_as);		
	}

	/**
	 * @return the molecular_weight
	 */
	public String getMolecular_weight() {
		return molecular_weight;
	}


	/**
	 * @param molecular_weight the molecular_weight to set
	 */
	public void setMolecular_weight(String molecular_weight) {
		this.molecular_weight = molecular_weight;
	}


	/**
	 * @return the names
	 */
	public List<String> getNames() {
		return names;
	}


	/**
	 * @param names the names to set
	 */
	public void setNames(List<String> names) {
		this.names = names;
	}


	/**
	 * @return the enzymes
	 */
	public List<String> getEnzymes() {
		return enzymes;
	}


	/**
	 * @param enzymes the enzymes to set
	 */
	public void setEnzymes(List<String> enzymes) {
		this.enzymes = enzymes;
	}


	/**
	 * @return the reactions
	 */
	public List<String> getReactions() {
		return reactions;
	}


	/**
	 * @param reactions the reactions to set
	 */
	public void setReactions(List<String> reactions) {
		this.reactions = reactions;
	}


	/**
	 * @return the pathways
	 */
	public Map<String, String> getPathways() {
		return pathways;
	}


	/**
	 * @param pathways the pathways to set
	 */
	public void setPathways(Map<String, String> pathways) {
		this.pathways = pathways;
	}


	/**
	 * @return the dblinks
	 */
	public List<String> getDblinks() {
		return dblinks;
	}


	/**
	 * @param dblinks the dblinks to set
	 */
	public void setDblinks(List<String> dblinks) {
		this.dblinks = dblinks;
	}
	
}
