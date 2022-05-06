/**
 * This is an exception class that is thrown when the Cellular Automaton class
 * is not given a valid parameter to create a Cellular Automaton.
 * 
 * @author nataliehill
 *
 */
public class CellularAutomatonNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * This is to throw the message provided.
	 * 
	 * @param s	invalid input for Cellular Automaton class 
	 */
	
	public CellularAutomatonNotFoundException(String s) {
		super("Unknown cellular automaton type " + s);
	}
}
