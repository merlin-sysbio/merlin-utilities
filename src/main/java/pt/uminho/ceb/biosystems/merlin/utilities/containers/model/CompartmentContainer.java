package pt.uminho.ceb.biosystems.merlin.utilities.containers.model;

public class CompartmentContainer {
	
	
	private String compartmentID;
	private String name;
	private String abbreviation;
	
	/**
	 * @param compartmentID
	 * @param name
	 * @param abbreviation
	 */
	public CompartmentContainer(String compartmentID, String name,
			String abbreviation) {
		super();
		this.setCompartmentID(compartmentID);
		this.setName(name);
		this.setAbbreviation(abbreviation);
	}

	/**
	 * @return the compartmentID
	 */
	public String getCompartmentID() {
		return compartmentID;
	}

	/**
	 * @param compartmentID the compartmentID to set
	 */
	public void setCompartmentID(String compartmentID) {
		this.compartmentID = compartmentID;
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
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	
}