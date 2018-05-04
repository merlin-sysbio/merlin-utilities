package pt.uminho.sysbio.merlin.utilities.containers.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pt.uminho.ceb.biosystems.mew.utilities.datastructures.pair.Pair;

public class ReactionContainer implements EntityContainer {

	private String entryID;
	private String reactionID;
	private boolean reversible, inModel;
	private Double lowerBound, upperBound;
	private String name, localisation, notes;
	private List<String> names;
	private List<String> dblinks;
	private String equation;
	private	Map<String, String[]> reactantsStoichiometry;
	private	Map<String, String[]> productsStoichiometry;
	private Set<String> enzymes, comments, pathways;
	private Set<Pair<String, String>> genes;
	private	Map<String, String> pathwaysMap;
	private String geneRule;
	
	private boolean isGeneric, non_enzymatic, spontaneous;
	
	/**
	 * @param entryID
	 */
	public ReactionContainer(String entryID) {
		this.setEntryID(entryID);
	}
	
	/**
	 * Constructor to build container using the following parameters
	 * Null for all others
	 * 
	 * @param reactionID
	 * @param name
	 * @param equation
	 * @param reversible
	 * @param localisation
	 * @param entryID
	 */
	public ReactionContainer(String reactionID, String name, String equation, 
			boolean reversible, String localisation, String entryID) {
		super();
		this.setReactionID(reactionID);
		this.setName(name);
		this.setEquation(equation);
		this.setReversible(reversible);
		this.setLocalisation(localisation);
		this.setEntryID(entryID);
		this.setLowerBound(null);
		this.setUpperBound(null);
	}
	
	/**
	 * @param entryID the entryID to set
	 */
	public void setEntryID(String entry) {
		this.entryID = entry;
	}
	/**
	 * @return the entryID
	 */
	public String getEntryID() {
		return entryID;
	}
	
	/**
	 * @param reactantsStoichiometry the reactantsStoichiometry to set
	 */
	public void setReactantsStoichiometry(Map<String, String[]> reactantsStoichiometry) {
		this.reactantsStoichiometry = reactantsStoichiometry;
	}
	/**
	 * @return the reactantsStoichiometry
	 */
	public Map<String, String[]> getReactantsStoichiometry() {
		return reactantsStoichiometry;
	}
	/**
	 * @param pathwaysMap the pathwaysMap to set
	 */
	public void setPathwaysMap(Map<String, String> pathways) {
		this.pathwaysMap = pathways;
	}
	/**
	 * @return the pathwaysMap
	 */
	public Map<String, String> getPathwaysMap() {
		return pathwaysMap;
	}
	/**
	 * @param enzymes the enzymes to set
	 */
	public void setEnzymes(Set<String> enzymes) {
		this.enzymes = enzymes;
	}
	/**
	 * @return the enzymes
	 */
	public Set<String> getEnzymes() {
		return enzymes;
	}
	/**
	 * @param productsStoichiometry the productsStoichiometry to set
	 */
	public void setProductsStoichiometry(Map<String, String[]> productsStoichiometry) {
		this.productsStoichiometry = productsStoichiometry;
	}
	/**
	 * @return the productsStoichiometry
	 */
	public Map<String, String[]> getProductsStoichiometry() {
		return productsStoichiometry;
	}
	/**
	 * @param equation the equation to set
	 */
	public void setEquation(String equation) {
		this.equation = equation;
	}
	/**
	 * @return the equation
	 */
	public String getEquation() {
		return equation;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param isGeneric the isGeneric to set
	 */
	public void setGeneric(boolean isGeneric) {
		this.isGeneric = isGeneric;
	}

	/**
	 * @return the isGeneric
	 */
	public boolean isGeneric() {
		return isGeneric;
	}

	/**
	 * @param spontaneous the spontaneous to set
	 */
	public void setSpontaneous(boolean spontaneous) {
		this.spontaneous = spontaneous;
	}

	/**
	 * @return the spontaneous
	 */
	public boolean isSpontaneous() {
		return spontaneous;
	}

	/**
	 * @param non_enzymatic the non_enzymatic to set
	 */
	public void setNon_enzymatic(boolean non_enzymatic) {
		this.non_enzymatic = non_enzymatic;
	}

	/**
	 * @return the non_enzymatic
	 */
	public boolean isNon_enzymatic() {
		return non_enzymatic;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(Set<String> comments) {
		this.comments = comments;
	}

	/**
	 * @return the comments
	 */
	public Set<String> getComments() {
		return comments;
	}
	

	/**
	 * @param names the names to set
	 */
	public void setNames(List<String> names) {
		this.names = names;
	}
	
	/**
	 * @return the names
	 */
	public List<String> getNames() {
		return names;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 10;
		return String
				.format(
						"ReactionContainer [comments=%s, entryID=%s, enzymes=%s, equation=%s, isGeneric=%s, name=%s, non_enzymatic=%s, pathwaysMap=%s, productsStoichiometry=%s, reactantsStoichiometry=%s, spontaneous=%s]",
						comments != null ? toString(comments, maxLen) : null,
						entryID, enzymes != null ? toString(enzymes, maxLen)
								: null, equation, isGeneric, name,
						non_enzymatic, pathwaysMap != null ? toString(pathwaysMap
								.entrySet(), maxLen) : null,
						productsStoichiometry != null ? toString(
								productsStoichiometry.entrySet(), maxLen)
								: null,
						reactantsStoichiometry != null ? toString(
								reactantsStoichiometry.entrySet(), maxLen)
								: null, spontaneous);
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext()
				&& i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
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
	 * @return the localisation
	 */
	public String getLocalisation() {
		return localisation;
	}

	/**
	 * @param localisation the localisation to set
	 */
	public void setLocalisation(String compartment) {
		this.localisation = compartment;
	}

	/**
	 * @return the lowerBound
	 */
	public Double getLowerBound() {
		return lowerBound;
	}

	/**
	 * @param lowerBound the lowerBound to set
	 */
	public void setLowerBound(Double lowerBound) {
		this.lowerBound = lowerBound;
	}

	/**
	 * @return the upperBound
	 */
	public Double getUpperBound() {
		return upperBound;
	}

	/**
	 * @param upperBound the upperBound to set
	 */
	public void setUpperBound(Double upperBound) {
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
	 * @return the genes
	 */
	public Set<Pair<String, String>> getGenes() {
		return genes;
	}

	/**
	 * @param genes the genes to set
	 */
	public void setGenes(Set<Pair<String, String>> genes) {
		this.genes = genes;
	}

	/**
	 * @return the reactionID
	 */
	public String getReactionID() {
		return reactionID;
	}

	/**
	 * @param reactionID the reactionID to set
	 */
	public void setReactionID(String reactionID) {
		this.reactionID = reactionID;
	}

	/**
	 * @return the pathways
	 */
	public Set<String> getPathways() {
		return pathways;
	}

	/**
	 * @param pathways the pathways to set
	 */
	public void setPathways(Set<String> pathways) {
		this.pathways = pathways;
	}

	/**
	 * @return the geneRule
	 */
	public String getGeneRule() {
		return geneRule;
	}

	/**
	 * @param geneRule the geneRule to set
	 */
	public void setGeneRule(String geneRule) {
		this.geneRule = geneRule;
	}
	
	
	/**
	 * @param geneLocus
	 * @param geneName
	 */
	public void addGene(String geneLocus, String geneName){
		
		if(this.genes==null)
			this.genes = new HashSet<>();
		
		this.genes.add(new Pair<String, String> (geneLocus, geneName));
	}


}
