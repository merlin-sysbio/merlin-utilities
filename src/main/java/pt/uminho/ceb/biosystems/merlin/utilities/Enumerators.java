package pt.uminho.ceb.biosystems.merlin.utilities;

public class Enumerators {
	
	public enum ModuleType {

		Complex,
		Pathway
	}

	/**
	 * @author Oscar
	 *
	 */
	public static enum AlignmentScoreType {
	
		ALIGNMENT,
		IDENTITY,
		SIMILARITY
	}

	/**
	 * @author ODias
	 * available methods for alignment
	 */
	public static enum AlignmentPurpose {
	
		TRANSPORT,
		ORTHOLOGS,
		OTHER
	}

	/**
	 * @author ODias
	 * available methods for alignment
	 */
	public static enum Method {
	
		SmithWaterman,
		NeedlemanWunsch
	}

	/**
	 * @author ODias
	 *
	 */
	public static enum Matrix {
	
		BLOSUM62 ("blosum62.txt"),
		PAM30 ("pam30.txt"),
		PAM70 ("pam70.txt"),
		BLOSUM80 ("blosum80.txt"),
		BLOSUM45 ("blosum45.txt");
		private String path;
	
		private Matrix(String path) {
			this.path = path;
		}
	
		public String getPath(){
			return this.path;
		}
	}
	
}
