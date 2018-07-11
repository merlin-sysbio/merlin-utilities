package pt.uminho.ceb.biosystems.merlin.utilities.io;

import java.io.File;
import java.util.StringTokenizer;

public class FileUtils extends pt.uminho.ceb.biosystems.mew.utilities.io.FileUtils{

	/**method to return utilities folder path in merlin folder
	 * @return
	 */
	public static String getUtilitiesFolderPath(){
		
		return FileUtils.getHomeFolderPath().concat("utilities/");
	}
	
	/** 
	 * Method to return merlin home folder path
	 * @return
	 */
	public static String getHomeFolderPath(){
		
		return new File(getCurrentLibDirectory()).getParent().concat("/");
	}
	
	/**
	 * @return
	 */
	public static String getCurrentLibDirectory(){
		
		String tokenizer = File.pathSeparator;
		StringTokenizer st = new StringTokenizer(System.getProperty("java.class.path"),tokenizer);
		String path = st.nextToken();
		
		String tempPath = new String(path);
		while(!tempPath.contains("lib") && st.hasMoreTokens())
			tempPath = st.nextToken();
		
		while(tempPath.contains("Java") && st.hasMoreTokens())
			tempPath = st.nextToken();
		
		if(tempPath.contains("lib"))
			path = tempPath;
		
		File f = new File(path);
		if(!f.isDirectory())
			path = f.getParent();
		
		return path;
	}
	
	/**method to return workspace folder path
	 * @return
	 */
	public static String getWorkspaceFolderPath(String databaseName){
		
		return FileUtils.getWorkspacesFolderPath().concat(databaseName).concat("/");
	}
	
	
	/**method to return taxonomy workspace folder path
	 * @return
	 */
	public static String getWorkspaceTaxonomyFolderPath(String databaseName, Long taxonomyID){
		
		return FileUtils.getWorkspaceFolderPath(databaseName).concat(taxonomyID.toString()).concat("/");
	}
	
	
	/**method to return taxonomy workspace folder path
	 * @return
	 */
	public static String getWorkspaceTaxonomyTriageFolderPath(String databaseName, Long taxonomyID){
		
		String workspaceTriageFolder = FileUtils.getWorkspaceTaxonomyFolderPath(databaseName, taxonomyID).concat("triage/");
		
		File file = new File(workspaceTriageFolder);
		file.mkdirs();
		
		return workspaceTriageFolder;
	}
	
	/**
	 * @param databaseName
	 * @param taxonomyID
	 * @return
	 */
	public static String getWorkspaceTaxonomyTempFolderPath(String databaseName, Long taxonomyID){
		
		String workspaceTempFolder = FileUtils.getWorkspaceTaxonomyFolderPath(databaseName, taxonomyID).concat("temp/");
		
		File file = new File(workspaceTempFolder);
		file.mkdirs();
		
		return workspaceTempFolder;
	}
	
	/**
	 * @param databaseName
	 * @param taxonomyID
	 * @return
	 */
	public static String getWorkspaceTaxonomyGprsFolderPath(String databaseName, Long taxonomyID){
		
		String workspaceTempFolder = FileUtils.getWorkspaceTaxonomyFolderPath(databaseName, taxonomyID).concat("gprs/");
		
		File file = new File(workspaceTempFolder);
		file.mkdirs();
		
		return workspaceTempFolder;
	}
	
	/** 
	 * Method to return merlin home folder file
	 * @return
	 */
	public static File getHomeFolder(){
		
		return new File(getCurrentLibDirectory()).getParentFile();
	}
	
	
	/**
	 * method to return merlin configuration(conf) folder
	 * @return
	 */
	public static String getConfFolderPath(){
		
		return FileUtils.getHomeFolderPath().concat("conf/");
	}
	
	
	/**
	 * method to return workspace configuration(conf) folder path
	 * @return
	 */
	public static String getWorkspaceConfFolderPath(String databaseName){
		
		return FileUtils.getWorkspaceFolderPath(databaseName).concat("conf/");
	}
	
	
	/**
	 * method to return workspaces folder (folder which contains all created workspaces)
	 * the folder "workspaces" is created if it doesn't exist
	 * @return
	 */
	public static String getWorkspacesFolderPath(){
		
		File path = new File(FileUtils.getHomeFolderPath().concat("ws").concat("/"));
		
		if(!path.exists())
			path.mkdirs();
		
		String workspacesPath = path.getAbsolutePath().concat("/");
		
		return workspacesPath;
	}
	
	
}
