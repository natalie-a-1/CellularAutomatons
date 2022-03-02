import java.io.IOException;

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
