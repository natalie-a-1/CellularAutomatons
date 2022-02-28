
public class TotalisticRule extends Rule {
	
	public boolean rules[] = new boolean[6];

	protected TotalisticRule(int ruleNum) throws RuleNumException {
		super(ruleNum);
		
		if (ruleNum > 63 || ruleNum < 0) {
			
			throw new RuleNumException(0,63);
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

	@Override
	public boolean[] getNeighborhood(int idx, Generation gen) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean evolve(boolean[] neighborhood) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String ruleTableString(char falseSymbol, char trueSymbol) {
		// TODO Auto-generated method stub
		return null;
	}

}
