/**
 * The Rule class is an abstract class designed to create new Rule objects and
 * use the rule to evolve generations and neighborhoods.
 * 
 * 
 * @author Natalie hill
 *
 */

public abstract class Rule {

	private int ruleNum;

	public boolean[] rules = new boolean[8];

	protected Rule(int ruleNum) {

		this.ruleNum = ruleNum;

	}

	/**
	 * Retrieves the rule number passed to the Rule constructor.
	 * 
	 * @return rule number that was passed to the Rule constructor
	 */

	public int getRuleNum() {

		int code = ruleNum;

		return code;

	}

	/**
	 * Retrieves cell states in the neighborhood of the cell with the given index.
	 * 
	 * @param idx index in the given Generation
	 * @param gen Generation to be searched
	 * @return boolean array of cell states according to the given index
	 */

	public abstract boolean[] getNeighborhood(int idx, Generation gen);

	/**
	 * Determines the next state of a cell given the current neighborhood.
	 * 
	 * @param neighborhood boolean array of cell states
	 * @return expected cell state given the neighborhood passed to the method
	 */

	public abstract boolean evolve(boolean[] neighborhood);

	/**
	 * Creates the next Generation given the current Generation.
	 * 
	 * @param gen Generation to be searched
	 * @return expected Generation given the previous generation of cell states
	 */

	public Generation evolve(Generation gen) {

		boolean[] arr = new boolean[gen.size()];

		// for loop from Aaron Coker

		for (int i = 0; i < gen.size(); i++) {

			arr[i] = evolve(getNeighborhood(i, gen));

		}
		return new Generation(arr);

	}

	/**
	 * Displays all of the rules and their outputs with the ability to change the
	 * false and true statements.
	 * 
	 * @param falseSymbol char that represents the false value
	 * @param trueSymbol  char that represents the true value
	 * @return table of rules and its output in the form of a String
	 */

	public abstract String ruleTableString(char falseSymbol, char trueSymbol);

	/**
	 * Retrieves the next cell states of an index by the radius' value.
	 * 
	 * @param idx    index used to specify start of method
	 * @param radius specifies how far to go from index to get other states in
	 *               generation
	 * @param gen    Generation of cell states
	 * @return boolean array of cell states a radius value away from the index
	 */

	// Collaborated with Keon on getNeighborhoodByRadius
	public static boolean[] getNeighborhoodByRadius(int idx, int radius, Generation gen) {

		boolean[] tempo = new boolean[(2 * radius) + 1];

		for (int i = -radius; i < radius + 1; i++) {

			int x = Math.floorMod(idx + i, gen.size());
			tempo[radius + i] = gen.getState(x);

		}

		return tempo;

	}

}
