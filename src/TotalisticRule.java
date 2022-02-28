import java.util.StringJoiner;

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
		
		char[] holder = new char[6];

        for (int i = 0; i < 6; i++) {
        	
            if(rules[6-i-1] == false) {
            	
                holder[i] = falseSymbol;
            }
            else {
            	
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
		
		String output = sj.toString() + System.lineSeparator() + holder[0] + " " + holder[1] + " " + holder[2] + " " + holder[3] +  " " + holder[4] + " " + holder[5];
		return output;
	}

}
