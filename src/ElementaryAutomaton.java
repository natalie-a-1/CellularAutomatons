import java.io.IOException;

/**
 * This method creates an Elementary Automaton by extending the 
 * parent Automaton class.
 * 
 * @author Natalie Hill
 *
 */

public class ElementaryAutomaton extends Automaton {

	protected ElementaryAutomaton(int ruleNum, Generation initial) throws RuleNumException {

		super(ruleNum, initial);

	}

	protected ElementaryAutomaton(String filename) throws IOException, RuleNumException {

		super(filename);

	}

	@Override
	protected Rule createRule(int ruleNum) throws RuleNumException {

		Rule elementaryRule = new ElementaryRule(ruleNum);

		return elementaryRule;
	}

}
