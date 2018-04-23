package pt.uminho.sysbio.merlin.utilities.containers.capsules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Oscar Dias
 *
 */
public class DatabaseReactionContainer {

	private String reaction_id,
	name,
	equation,
	source,
	lowerBound,
	upperBound, notes;
	private boolean reversible, 
	inModel, 
	isGeneric, 
	isSpontaneous, 
	isNonEnzymatic;
	private Map<String, List<String>> ecnumbers_protein_id;
	private List<String> pathways, protein_id, ecnumbers;
	private List<String> 
			stoichiometric_coefficients, 
			numbersofchains;
	private List<Integer> compartment_idcompartment, compound_idcompounds;


	/**
	 * @param reaction_id
	 * @param name_compartmentIntegration
	 * @param equation_compartmentIntegration
	 * @param source_compartmentIntegration
	 * @param reversible
	 * @param inModel
	 * @param isGeneric
	 * @param isSpontaneous
	 * @param isNonEnzymatic
	 */
	public DatabaseReactionContainer(String reaction_id,
			String name_compartmentIntegration,
			String equation_compartmentIntegration,
			String source_compartmentIntegration, boolean reversible,
			boolean inModel, boolean isGeneric, boolean isSpontaneous,
			boolean isNonEnzymatic) {
		super();
		this.name = name_compartmentIntegration;
		this.equation = equation_compartmentIntegration;
		this.source = source_compartmentIntegration;
		this.reversible = reversible;
		this.inModel = inModel;
		this.isGeneric = isGeneric;
		this.isSpontaneous = isSpontaneous;
		this.isNonEnzymatic = isNonEnzymatic;
		this.ecnumbers_protein_id = new HashMap<>();
		this.pathways = new ArrayList<>();
		this.compound_idcompounds = new ArrayList<>();
		this.stoichiometric_coefficients = new ArrayList<String>();
		this.numbersofchains = new ArrayList<String>();
		this.ecnumbers = new ArrayList<>();
		this.protein_id = new ArrayList<>();
		this.compartment_idcompartment = new ArrayList<>();
	}
	
	/**
	 * @param databaseReactionContainer
	 */
	public DatabaseReactionContainer (DatabaseReactionContainer databaseReactionContainer) {
		
		super();
		this.name = databaseReactionContainer.getName();
		this.equation = databaseReactionContainer.getEquation();
		this.source = databaseReactionContainer.getSource();
		this.reversible = databaseReactionContainer.isReversible();
		this.inModel = databaseReactionContainer.isInModel();
		this.isGeneric = databaseReactionContainer.isGeneric();
		this.isSpontaneous = databaseReactionContainer.isSpontaneous();
		this.isNonEnzymatic = databaseReactionContainer.isNonEnzymatic();
		this.ecnumbers_protein_id = databaseReactionContainer.getEcnumbers_protein_id();
		this.pathways = databaseReactionContainer.getPathways();
		this.compound_idcompounds = databaseReactionContainer.getCompound_idcompounds();
		this.stoichiometric_coefficients = databaseReactionContainer.getStoichiometric_coefficients();
		this.numbersofchains = databaseReactionContainer.getNumbersofchains();
		this.ecnumbers = databaseReactionContainer.getEcnumbers();
		this.protein_id = databaseReactionContainer.getProtein_id();
		this.compartment_idcompartment = databaseReactionContainer.getCompartment_idcompartment();
	}
	
	/**
	 * @param compound_idcompound
	 * @param stoichiometric_coefficient
	 * @param numberofchains
	 */
	public void addEntry(int compound_idcompound, String stoichiometric_coefficient, String numberofchains) {
		
		this.compound_idcompounds.add(this.compound_idcompounds.size(), compound_idcompound);
		this.stoichiometric_coefficients.add(this.stoichiometric_coefficients.size(), stoichiometric_coefficient);
		this.numbersofchains.add(this.numbersofchains.size(), numberofchains);
	}
	
	/**
	 * @param compound_idcompound
	 * @param stoichiometric_coefficient
	 * @param numberofchains
	 * @param compartment
	 */
	public void addEntry(int compound_idcompound, String stoichiometric_coefficient, String numberofchains, int compartment) {
		
		this.compound_idcompounds.add(this.compound_idcompounds.size(), compound_idcompound);
		this.stoichiometric_coefficients.add(this.stoichiometric_coefficients.size(), stoichiometric_coefficient);
		this.numbersofchains.add(this.numbersofchains.size(), numberofchains);
		this.compartment_idcompartment.add(this.compartment_idcompartment.size(), compartment);
	}
	
	/**
	 * @param protein_id
	 * @param ec_number
	 */
	public void addProteins(String protein_id, String ecnumber) {
		
		List<String> pl = new ArrayList<>();

		if(this.ecnumbers_protein_id.containsKey(ecnumber))
			pl=this.ecnumbers_protein_id.get(ecnumber);
		
		pl.add(protein_id);
		
		this.ecnumbers_protein_id.put(ecnumber, pl);
		this.ecnumbers.add(this.ecnumbers.size(), ecnumber);
		this.protein_id.add(this.protein_id.size(), protein_id);
		
	}
	
	
	/**
	 * @return the reaction_id
	 */
	public String getReaction_id() {
		return reaction_id;
	}
	/**
	 * @param reaction_id the reaction_id to set
	 */
	public void setReaction_id(String reaction_id) {
		this.reaction_id = reaction_id;
	}
	/**
	 * @return the reversible
	 */
	public boolean isReversible() {
		return reversible;
	}
	/**
	 * @param reversible the reversible to set
	 */
	public void setReversible(boolean reversible) {
		this.reversible = reversible;
	}
	/**
	 * @return the inModel
	 */
	public boolean isInModel() {
		return inModel;
	}
	/**
	 * @param inModel the inModel to set
	 */
	public void setInModel(boolean inModel) {
		this.inModel = inModel;
	}
	/**
	 * @return the isGeneric
	 */
	public boolean isGeneric() {
		return isGeneric;
	}
	/**
	 * @param isGeneric the isGeneric to set
	 */
	public void setGeneric(boolean isGeneric) {
		this.isGeneric = isGeneric;
	}
	/**
	 * @return the isSpontaneous
	 */
	public boolean isSpontaneous() {
		return isSpontaneous;
	}
	/**
	 * @param isSpontaneous the isSpontaneous to set
	 */
	public void setSpontaneous(boolean isSpontaneous) {
		this.isSpontaneous = isSpontaneous;
	}
	/**
	 * @return the isNonEnzymatic
	 */
	public boolean isNonEnzymatic() {
		return isNonEnzymatic;
	}
	/**
	 * @param isNonEnzymatic the isNonEnzymatic to set
	 */
	public void setNonEnzymatic(boolean isNonEnzymatic) {
		this.isNonEnzymatic = isNonEnzymatic;
	}
	/**
	 * @return the ecnumbers_protein_id
	 */
	public Map<String, List<String>> getEcnumbers_protein_id() {
		return ecnumbers_protein_id;
	}
	/**
	 * @param ecnumbers_protein_id the ecnumbers_protein_id to set
	 */
	public void setEcnumbers_protein_id(Map<String, List<String>> ecnumbers_protein_id) {
		this.ecnumbers_protein_id = ecnumbers_protein_id;
	}
	/**
	 * @return the pathways
	 */
	public List<String> getPathways() {
		return pathways;
	}
	/**
	 * @param pathways the pathways to set
	 */
	public void setPathways(List<String> pathways) {
		this.pathways = pathways;
	}


	/**
	 * @return the compound_idcompound
	 */
	public List<Integer> getCompound_idcompounds() {
		return compound_idcompounds;
	}
	/**
	 * @param compound_idcompound the compound_idcompound to set
	 */
	public void setCompound_idcompound(List<Integer> compound_idcompounds) {
		this.compound_idcompounds = compound_idcompounds;
	}
	/**
	 * @return the stoichiometric_coefficient
	 */
	public List<String> getStoichiometric_coefficients() {
		return stoichiometric_coefficients;
	}
	/**
	 * @param stoichiometric_coefficient the stoichiometric_coefficient to set
	 */
	public void setStoichiometric_coefficients(List<String> stoichiometric_coefficients) {
		this.stoichiometric_coefficients = stoichiometric_coefficients;
	}
	/**
	 * @return the numberofchains
	 */
	public List<String> getNumbersofchains() {
		return numbersofchains;
	}
	/**
	 * @param numberofchains the numberofchains to set
	 */
	public void setNumberofchains(List<String> numbersofchains) {
		this.numbersofchains = numbersofchains;
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
	 * @return the equation
	 */
	public String getEquation() {
		return equation;
	}
	/**
	 * @param equation the equation to set
	 */
	public void setEquation(String equation) {
		this.equation = equation;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the protein_id
	 */
	public List<String> getProtein_id() {
		return protein_id;
	}

	/**
	 * @param protein_id the protein_id to set
	 */
	public void setProtein_id(List<String> protein_id) {
		this.protein_id = protein_id;
	}

	/**
	 * @return the ecnumbers
	 */
	public List<String> getEcnumbers() {
		return ecnumbers;
	}

	/**
	 * @param ecnumbers the ecnumbers to set
	 */
	public void setEcnumbers(List<String> ecnumbers) {
		this.ecnumbers = ecnumbers;
	}

	/**
	 * @return the lowerBound
	 */
	public String getLowerBound() {
		return lowerBound;
	}

	/**
	 * @param lowerBound the lowerBound to set
	 */
	public void setLowerBound(String lowerBound) {
		this.lowerBound = lowerBound;
	}

	/**
	 * @return the upperBound
	 */
	public String getUpperBound() {
		return upperBound;
	}

	/**
	 * @param upperBound the upperBound to set
	 */
	public void setUpperBound(String upperBound) {
		this.upperBound = upperBound;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the compartment_idcompartment
	 */
	public List<Integer> getCompartment_idcompartment() {
		return compartment_idcompartment;
	}

	/**
	 * @param compartment_idcompartment the compartment_idcompartment to set
	 */
	public void setCompartment_idcompartment(
			List<Integer> compartment_idcompartment) {
		this.compartment_idcompartment = compartment_idcompartment;
	}
}