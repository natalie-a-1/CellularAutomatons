import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

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
	
	public String ruleTableString() {
		
		return rule.ruleTableString(falseSymbol, trueSymbol);
		
	}
	
	protected abstract Rule createRule(int ruleNum) throws RuleNumException;
	
	public static Automaton createAutomaton(CellularAutomaton ca, int ruleNum, Generation initial) throws RuleNumException {
		
		if (ca == null) {
			
			return null;

		} else if (ca == CellularAutomaton.ECA) {
			
			return new ElementaryAutomaton(ruleNum, initial);
			
		} else if  (ca == CellularAutomaton.TCA) {
			
			return new TotalisticAutomaton(ruleNum, initial);
			
		} else {
			
			return null;
			
		}
		
		
	}
	public int evolve(int numSteps) {

		if (numSteps <= 0) {

			return 0;

		} else {

			for (int i = 0; i < numSteps; i++) { //works at zero

				generations.add(rule.evolve(getCurrentGeneration()));

			}
			return numSteps;
		}

	}
	
	public Generation getGeneration(int stepNum) {

		if (getTotalSteps() < stepNum) {

			int diff = stepNum - getTotalSteps();

			evolve(diff);
			
			return generations.get(stepNum);

		} else {
			
			return generations.get(stepNum);
			
		}

	}
	
	public Generation getCurrentGeneration() {

		return generations.get(generations.size() - 1);
	}

	public int getRuleNum() {
		
		return rule.getRuleNum();
	}

	public int getTotalSteps() {

		return generations.size() - 1;
	}
	
	public void saveEvolution(String filename) throws IOException {
		
		FileWriter fileOverRide = new FileWriter(filename, false);
		
		fileOverRide.write(this.toString());
		
		fileOverRide.close();
		
	}
	
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