package pt.uminho.ceb.biosystems.merlin.utilities;

import pt.uminho.ceb.biosystems.merlin.utilities.io.FileUtils;

/**
 * @author davidelagoa
 *
 */
public class DatabaseFilesPaths {
	
	static String path = FileUtils.getUtilitiesFolderPath();
	
	public static String[] getPathsList(boolean databaseMYSQL){
		
		String[] filePath = new String[7];
		
		if (databaseMYSQL){
			filePath=new String[8];
			filePath[7]=path +"functions_transporters_annotation.sql";
		}
		filePath[0]=path +"schema_model.sql";
		filePath[1]=path +"schema_interpro.sql";
		filePath[2]=path +"schema_enzymes_annotation.sql";
		filePath[3]=path +"schema_transporters_annotation.sql";
		filePath[4]=path +"schema_compartments_annotation.sql";
		filePath[5]=path +"schema_transporters_identification.sql";
		filePath[6]=path +"triage_database.sql";
	
		return filePath;
	}
	
	public static String getModelPath(){
		
		return path +"schema_model.sql";
	}
	
	public static String getTransportersIdentificationPath(){
		
		return path +"schema_transporters_identification.sql";
	}
	
	public static String getEnzymesAnnotationPath(){
		
		return path +"schema_enzymes_annotation.sql";
	}
	
	public static String getCompartmentsAnnotationPath(){
		
		return path +"schema_compartments_annotation.sql";
	}
	
	public static String getInterproAnnotationPath(){
		
		return path +"schema_interpro.sql";
	}
	
	public static String[] getTransportAnnotationPath(boolean databaseTypeMYSQL){
		
		String[] filePath=new String[2];
		
		if (databaseTypeMYSQL){
			
			filePath=new String[3];
			filePath[2]=path +"functions_transporters_annotation.sql";
		}
		filePath[0]=path+"schema_transporters_annotation.sql";
		filePath[1]=path+"triage_database.sql";
		
		return filePath;
	}
	
	
	
}