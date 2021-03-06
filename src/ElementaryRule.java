import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Elementary rule is a subclass of the abstract class Rule. This class
 * specifically creates one the 256 rules of an Elementary Cellular Automaton.
 * 
 * @author Natalie Hill
 *
 */

public class ElementaryRule extends Rule {
	
	/**
	 * This is an array of true and/or false values depending on which rule is chosen.
	 */

	public boolean[] rules = new boolean[8];

	/**
	 * Elementary Rule takes in a number and given that it is between 0 and 255 it
	 * converts the number to binary and assigns each number a false/true symbol.
	 * 
	 * 
	 * @param ruleNum Constructor for Elementary Cellular Automaton Rule
	 * @throws RuleNumException if rule number is greater than 255 or less than 0
	 */

	public ElementaryRule(int ruleNum) throws RuleNumException {

		super(ruleNum);

		if (ruleNum > 255 || ruleNum < 0) {

			throw new RuleNumException(0, 255);

		} else {

			String temp = String.format("%8s", Integer.toBinaryString(ruleNum));

			for (int i = 0; i < temp.length(); i++) {

				if (temp.charAt(temp.length() - i - 1) == '0') {

					rules[i] = false;

				} else if (temp.charAt(temp.length() - i - 1) == '1') {

					rules[i] = true;
				}
			}
		}

	}

	/**
	 * The evolve method takes in a neighborhood and checks to see which rule the
	 * neighborhood corresponds to.
	 * 
	 * @param neighborhood a boolean array of cell a neighborhood's cell states
	 * @return the state of the next cell given the rule
	 */
	

	public boolean evolve(boolean[] neighborhood) {

		boolean value = false;

		boolean[] t1 = { false, false, false };

		boolean[] t2 = { false, false, true };

		boolean[] t3 = { false, true, false };

		boolean[] t4 = { false, true, true };

		boolean[] t5 = { true, false, false };

		boolean[] t6 = { true, false, true };

		boolean[] t7 = { true, true, false };

		boolean[] t8 = { true, true, true };

		if (Arrays.equals(neighborhood, t1)) {

			value = rules[0];

		} else if (Arrays.equals(neighborhood, t2)) {

			value = rules[1];

		} else if (Arrays.equals(neighborhood, t3)) {

			value = rules[2];

		} else if (Arrays.equals(neighborhood, t4)) {

			value = rules[3];

		} else if (Arrays.equals(neighborhood, t5)) {

			value = rules[4];

		} else if (Arrays.equals(neighborhood, t6)) {

			value = rules[5];

		} else if (Arrays.equals(neighborhood, t7)) {

			value = rules[6];

		} else if (Arrays.equals(neighborhood, t8)) {

			value = rules[7];
		}
		return value;

	}

	/**
	 * GetNeighborhood gets the cell states of neighbors of the index.
	 * 
	 * @param idx the index of the Generation
	 * @param gen Generation to search for neighbors
	 * @return a boolean array of the indeice's neighbor's states
	 */

	public boolean[] getNeighborhood(int idx, Generation gen) {

		boolean[] temp = new boolean[3];

		// circular boundaries

		if (gen.getStates().length == 1) {

			temp[0] = gen.getState(idx);

			temp[1] = gen.getState(idx);

			temp[2] = gen.getState(idx);

		} else if (idx == 0) {

			temp[0] = gen.getState(gen.size() - 1);

			temp[1] = gen.getState(idx);

			temp[2] = gen.getState(idx + 1);

		} else if (idx == gen.size() - 1) {

			temp[0] = gen.getState(idx - 1);

			temp[1] = gen.getState(idx);

			temp[2] = gen.getState(0);

		} else {

			temp[0] = gen.getState(idx - 1);

			temp[1] = gen.getState(idx);

			temp[2] = gen.getState(idx + 1);

		}

		return temp;

	}

	/**
	 * Shows all the possible rules of an Elementary Cellular Automaton and their
	 * outputs in the form of a String table.
	 * 
	 * @param falseSymbol sets the value of the falseSymbol
	 * @param trueSymbol  sets the value of a trueSymbol
	 * @return a table of 8 rules and their outputs
	 */

	// Collaborated with Keon
	public String ruleTableString(char falseSymbol, char trueSymbol) {

		char[] holder = new char[8];

		for (int i = 0; i < 8; i++) {

			if (rules[8 - i - 1] == false) {

				holder[i] = falseSymbol;
			} else {

				holder[i] = trueSymbol;
			}
		}

		String first = "";
		first = first + trueSymbol + trueSymbol + trueSymbol;

		String second = "";
		second = second + trueSymbol + trueSymbol + falseSymbol;

		String third = "";
		third = third + trueSymbol + falseSymbol + trueSymbol;

		String fourth = "";
		fourth = fourth + trueSymbol + falseSymbol + falseSymbol;

		String fifth = "";
		fifth = fifth + falseSymbol + trueSymbol + trueSymbol;

		String sixth = "";
		sixth = sixth + falseSymbol + trueSymbol + falseSymbol;

		String seventh = "";
		seventh = seventh + falseSymbol + falseSymbol + trueSymbol;

		String eighth = "";
		eighth = eighth + falseSymbol + falseSymbol + falseSymbol;

		StringJoiner sj = new StringJoiner(" ");
		sj.add(first);
		sj.add(second);
		sj.add(third);
		sj.add(fourth);
		sj.add(fifth);
		sj.add(sixth);
		sj.add(seventh);
		sj.add(eighth);

		String output = sj.toString() + System.lineSeparator() + " " + holder[0] + " " + " " + " " + holder[1] + " "
				+ " " + " " + holder[2] + " " + " " + " " + holder[3] + " " + " " + " " + holder[4] + " " + " " + " "
				+ holder[5] + " " + " " + " " + holder[6] + " " + " " + " " + holder[7] + " ";

		return output;
	}
}
