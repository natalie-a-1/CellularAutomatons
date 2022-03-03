import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Automaton is an abstract class that generates either an Elementary Cellular
 * Automaton or a Totalistic Automaton given a rule.
 * 
 * @author Natalie Hill
 *
 */

public abstract class Automaton {

	private Rule rule;
	private ArrayList<Generation> generations = new ArrayList<Generation>();
	public char falseSymbol = '0';
	public char trueSymbol = '1';

	protected Automaton(int ruleNum, Generation initial) throws RuleNumException {

		generations.add(initial);

		rule = createRule(ruleNum);

	}

	protected Automaton(String filename) throws IOException, RuleNumException {

		Scanner sc = new Scanner(new File(filename));

		rule = createRule(sc.nextInt());

		falseSymbol = sc.next().charAt(0);

		trueSymbol = sc.next().charAt(0);

		sc.nextLine();

		generations = new ArrayList<Generation>();

		generations.add(new Generation(sc.nextLine(), trueSymbol));

		sc.close();

	}

	/**
	 * This method uses the Rule classes ruleTable String to create a new rule
	 * table.
	 * 
	 * @return a String representation of all possible rules and their outcomes
	 */

	public String ruleTableString() {

		return rule.ruleTableString(falseSymbol, trueSymbol);

	}

	protected abstract Rule createRule(int ruleNum) throws RuleNumException;

	/**
	 * This method creates either an Elementary or Totalistic Automaton using enums.
	 * 
	 * @param ca      the current Cellular Automaton
	 * @param ruleNum the rule number
	 * @param initial the first created generation
	 * @return either a Totalistic or Elementary Automaton
	 * @throws RuleNumException if the ruleNum is not in the range for either
	 *                          Elementary or Totalistic rules.
	 */

	public static Automaton createAutomaton(CellularAutomaton ca, int ruleNum, Generation initial)
			throws RuleNumException {

		if (ca == null) {

			return null;

		} else if (ca == CellularAutomaton.ECA) {

			return new ElementaryAutomaton(ruleNum, initial);

		} else if (ca == CellularAutomaton.TCA) {

			return new TotalisticAutomaton(ruleNum, initial);

		} else {

			return null;

		}

	}

	/**
	 * This method creates the amount of generations passed in numSteps, so long as
	 * numSteps is not less than or equal to 0.
	 * 
	 * @param numSteps the number steps the Automaton should evolve
	 * @return the number of steos the Automaton should evolve
	 */

	public int evolve(int numSteps) {

		if (numSteps <= 0) {

			return 0;

		} else {

			for (int i = 0; i < numSteps; i++) { // works at zero

				generations.add(rule.evolve(getCurrentGeneration()));

			}
			return numSteps;
		}

	}

	/**
	 * This method shows a certain generation and if it is not as large as stepNum
	 * it evolves it to that number.
	 * 
	 * @param stepNum the generation number to be returned
	 * @return the generation wanted
	 */

	public Generation getGeneration(int stepNum) {

		if (getTotalSteps() < stepNum) {

			int diff = stepNum - getTotalSteps();

			evolve(diff);

			return generations.get(stepNum);

		} else {

			return generations.get(stepNum);

		}

	}

	/**
	 * This method returns the current generation.
	 * 
	 * @return the current generation
	 */

	public Generation getCurrentGeneration() {

		return generations.get(generations.size() - 1);
	}

	/**
	 * This method retrieves the current rule number.
	 * 
	 * @return the rule number from the Rule class
	 */

	public int getRuleNum() {

		return rule.getRuleNum();
	}

	/**
	 * This method retrieves the total number of generations created.
	 * 
	 * @return the last element in generations
	 */

	public int getTotalSteps() {

		return generations.size() - 1;
	}

	/**
	 * This method saves each evolution of the Automaton.
	 * 
	 * @param filename the file to be searched
	 * @throws IOException if input from filename is not readable
	 */

	public void saveEvolution(String filename) throws IOException {

		FileWriter fileOverRide = new FileWriter(filename, false);

		fileOverRide.write(this.toString());

		fileOverRide.close();

	}

	/**
	 * Displays a String representation of the Automaton.
	 * 
	 * @return the String representation of the Automaton
	 */

	public String toString() {

		String output;

		StringJoiner jr = new StringJoiner(System.lineSeparator());

		for (int i = 0; i < generations.size(); i++) {

			jr.add(generations.get(i).getStates(falseSymbol, trueSymbol));

		}
		output = jr.toString();
		return output;
	}
}