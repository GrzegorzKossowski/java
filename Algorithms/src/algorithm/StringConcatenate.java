package algorithm;

/**
 * Concatenate strings using a specific separator.<br>
 * For arguments = ["Code", "Fight", "On", "!"] and <br>
 * separator = "/", the output should be <br>
 * myConcat(arguments, separator) = "Code/Fight/On/!/". 
 * @author grze<br>
 * <a href="http://www.codefights.com">source of challenge</a>
 *
 */
public class StringConcatenate {

	private static String [] arguments = {"Code", "Fight", "On", "!"};
	private static String separator = "/";
	
	public static String myConcat(String[] arguments, String separator) {
	    String string = "";
	    for (String var : arguments) {
	        string += var + separator;
	    }
	    return string;
	}
	
	/**
	 * Concatenate strings using a specific separator.
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(StringConcatenate.myConcat(arguments, separator));

	}

}
