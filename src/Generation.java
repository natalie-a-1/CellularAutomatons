import java.util.Arrays;

/**
 * The Generation class creates each Generation in a given automaton.
 * 
 * @author Natalie Hill
 *
 */

public class Generation {

	private boolean[] cellStates;

	/**
	 * This method creates a new cellStates object with the cellStates values.
	 * 
	 * @return a boolean array of the cell states
	 */

	public boolean[] getStates() {

		boolean[] output = new boolean[cellStates.length];

		for (int i = 0; i < cellStates.length; i++) {

			output[i] = cellStates[i];
		}
		return output;
	}

	/**
	 * This method creates a copy of cellStates and uses it to find a given index.
	 * 
	 * @param idx index of the private array cellStates
	 * @return the current state of an index in cellStates
	 */

	public boolean getState(int idx) {

		boolean[] arr = Arrays.copyOf(cellStates, cellStates.length);

		return arr[idx];
	}

	/**
	 * This method creates a String representation of cellStates with given
	 * false/true symbols.
	 * 
	 * @param falseSymbol symbol that represents a false value
	 * @param trueSymbol  symbol that represents a true value
	 * @return the current state of an index in cellStates with specified values
	 */

	// getStates is from Keon
	public String getStates(char falseSymbol, char trueSymbol) {

		String output = "";

		for (int i = 0; i < size(); i++) {

			if (cellStates[i] == true) {

				output = output + trueSymbol;

			} else {

				output = output + falseSymbol;
			}
		}
		return output;
	}

	/**
	 * This method keeps track of the length of cellStates.
	 * 
	 * @return the length of cellStates
	 */

	public int size() {

		boolean[] arr = Arrays.copyOf(cellStates, cellStates.length);

		return arr.length;
	}

	/**
	 * This constructs a Generation of states. Unless the passed states parameter is
	 * null or the length is 0, then it creates a boolean array with on index set to
	 * false value.
	 * 
	 * @param states A re-sizable boolean array of cellState values
	 */

	public Generation(boolean... states) {

		if (states == null || states.length == 0) {

			boolean[] falseB = { false };

			cellStates = Arrays.copyOf(falseB, falseB.length);

		} else {

			cellStates = Arrays.copyOf(states, states.length);
		}
	}

	/**
	 * This constructs a Generation of states. Unless the passed states parameter is
	 * null or the empty, then it sets cellStates to a single false value.
	 * 
	 * @param states     A String of cellState values
	 * @param trueSymbol symbol that represents a true value
	 */ 

	// Generation (states,trueSymbol) is from Keon
	public Generation(String states, char trueSymbol) {

		boolean[] f = { false };

		if (states == null || states == "") {

			cellStates = f;

		} else {

			cellStates = new boolean[states.length()];

			for (int i = 0; i < states.length(); i++) {

				if (states.charAt(i) == trueSymbol) {

					cellStates[i] = true;

				} else {

					cellStates[i] = false;
				}
			}
		}
	}
}