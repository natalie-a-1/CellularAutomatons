import java.util.StringJoiner;

/**
 * TotalisticRule is a subclass of the abstract class Rule. This class
 * specifically the rules for a Totalistic Cellular Automaton.
 * 
 * @author Natalie Hill
 *
 */

public class TotalisticRule extends Rule {

	public boolean rules[] = new boolean[6];

	protected TotalisticRule(int ruleNum) throws RuleNumException {

		super(ruleNum);

		if (ruleNum > 63 || ruleNum < 0) {

			throw new RuleNumException(0, 63);
		} else {

			String temp = String.format("%5s", Integer.toBinaryString(ruleNum));

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
	 * This method shows the cell states around a given index.
	 * 
	 * @param idx the index of the Generation
	 * @param gen Generation to search for neighbors
	 * @return a boolean array of the indeice's neighbor's states
	 */

	// collaborated with Keon
	@Override
	public boolean[] getNeighborhood(int idx, Generation gen) {

		boolean[] temp = getNeighborhoodByRadius(idx, 2, gen);
		return temp;
	}

	/**
	 * The evolve method takes in a neighborhood and checks to see which rule the
	 * neighborhood corresponds to.
	 * 
	 * @param neighborhood a boolean array of cell a neighborhood's cell states
	 * @return the state of the next cell given the rule
	 */

	// Recived help on evolve method from Keon
	@Override
	public boolean evolve(boolean[] neighborhood) {

		boolean output = false;

		int counter = 0;

		for (int i = 0; i < neighborhood.length; i++) {

			if (neighborhood[i] == true) {

				counter++;
			}
		}
		if (counter == 0) {

			output = rules[0];

		} else if (counter == 1) {

			output = rules[1];

		} else if (counter == 2) {

			output = rules[2];

		} else if (counter == 3) {

			output = rules[3];
			
		} else if (counter == 4) {

			output =rules[4];
			
		} else if (counter == 5) {

			output = rules[5];
		}
		return output;

	}

	/**
	 * Shows all the possible rules of an Elementary Cellular Automaton and their
	 * outputs in the form of a String table.
	 * 
	 * @param falseSymbol sets the value of the falseSymbol
	 * @param trueSymbol  sets the value of a trueSymbol
	 * @return a table of 6 rules and their outputs
	 */

	// collaborated with Keon on rule table
	@Override
	public String ruleTableString(char falseSymbol, char trueSymbol) {

		char[] holder = new char[6];

		for (int i = 0; i < 6; i++) {

			if (rules[6 - i - 1] == false) {

				holder[i] = falseSymbol;
			} else {

				holder[i] = trueSymbol;
			}
		}

		String first = "5";

		String second = "4";

		String third = "3";

		String fourth = "2";

		String fifth = "1";

		String sixth = "0";

		StringJoiner sj = new StringJoiner(" ");
		sj.add(first);
		sj.add(second);
		sj.add(third);
		sj.add(fourth);
		sj.add(fifth);
		sj.add(sixth);

		String output = sj.toString() + System.lineSeparator() + holder[0] + " " + holder[1] + " " + holder[2] + " "
				+ holder[3] + " " + holder[4] + " " + holder[5];

		return output;
	}

}
