import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ElementaryAutomaton extends Automaton {

	protected ElementaryAutomaton(int ruleNum, Generation initial) {
		super(ruleNum, initial);

	}

	protected ElementaryAutomaton(String filename) throws IOException {
		
		super(filename);

//		Scanner sc = new Scanner(new File(filename));
//
//		rule = new Rule(sc.nextInt());
//
//		falseSymbol = sc.next().charAt(0);
//
//		trueSymbol = sc.next().charAt(0);
//
//		sc.nextLine();
//
//		generations = new ArrayList<Generation>();
//
//		generations.add(new Generation(sc.nextLine(), trueSymbol));
//
//		sc.close();
	}

	@Override
	protected Rule createRule(int ruleNum) {
		//creates and returns an object of a particular Rule subclass
		//use method not new
		
		
		Rule elementaryRule = new ElementaryRule(ruleNum);
		//elementaryRule.getRuleNum();
		
		return elementaryRule;
	}

}
