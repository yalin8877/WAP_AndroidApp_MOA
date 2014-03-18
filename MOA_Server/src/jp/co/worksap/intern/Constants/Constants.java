package jp.co.worksap.intern.Constants;


/**
 * Constants class.
 * 
 */
public final class Constants {

	// Must not be instantiated
	private Constants() {
	}
	
	public static final int PORT = 5522;
	
	public static final String DEFAULT_APPLICATION_FILE = "output/APPLICATION.res";

	/** Directory name of CSV files for read */
	public static final String DEFAULT_CSV_FOLDER = "files/";

	/** Directory name of CSV files to write in */
	public static final String DEFAULT_CSV_OUTPUT_FOLDER = "output/";

	/** Default csv separator */
	public static final char DEFAULT_CSV_SEPARATOR = ',';

	/** default csv quote char */
	public static final char DEFAULT_CSV_QUOTECHAR = '\"';

	

}
