/**
 * This class was created to create either an ECA or TCA depending in the parameters given.
 * 
 * @author nataliehill
 *
 */

public enum CellularAutomaton {

	ECA,
	TCA;
	
	/**
	 * 
	 * @param s	String of either ECA or TCA value
	 * @return either an Elementary or Totalistic Cellular Automaton
	 * @throws CellularAutomatonNotFoundException	this is thrown if either ECA or TCA is not the value of s
	 */
	
	public static CellularAutomaton parse(String s) throws CellularAutomatonNotFoundException {
		if (s.equalsIgnoreCase("ECA")) { 
			return ECA;
		}
		else if (s.equalsIgnoreCase("TCA")) {
			return TCA;
		}
		else {
			throw new CellularAutomatonNotFoundException(s);
		}
	}
}
