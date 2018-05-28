package pt.uminho.ceb.biosystems.merlin.utilities.External;

import java.io.Serializable;

public interface IExternalRef extends Serializable{
	
	ExternalRefSource getExternalRefSource();
	
	String getId();
	String getName();
	String getURLLink();
	Boolean hasMiriamCode();
	String getMiriamCode();

	String getIdentifierCode();
	
}
