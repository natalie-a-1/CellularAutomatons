import java.io.IOException;

/**
 * This method creates an Elementary Automaton by extending the 
 * parent Automaton class.
 * 
 * @author Natalie Hill
 *
 */

public class TotalisticAutomaton extends Automaton{

	protected TotalisticAutomaton(int ruleNum, Generation initial) throws RuleNumException {
		
		super(ruleNum, initial);

	}
	

	protected TotalisticAutomaton(String filename) throws IOException, RuleNumException {

		super(filename);

	}

	@Override
	protected Rule createRule(int ruleNum) throws RuleNumException {

		Rule toalisticRule = new TotalisticRule(ruleNum);

		return toalisticRule;
	}

}
