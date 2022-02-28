import java.util.Arrays;
import java.util.StringJoiner;

public class ElementaryRule extends Rule {
	
	public boolean[] rules = new boolean[8];

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
	
	public String ruleTableString(char falseSymbol, char trueSymbol) {
		
		char[] h = new char[8];

        for (int i = 0; i < 8; i++) {
            if(rules[8-i-1] == false) {
                h[i] = falseSymbol;
            }
            else {
                h[i] = trueSymbol;
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
		
		StringJoiner rj = new StringJoiner("   ");
		
		String output = sj.toString() + System.lineSeparator() + " " + h[0] + " " + " "  + " " + h[1] + " " + " " + " " + h[2] + " " + " " + " " + h[3] + " " + " " + " " + h[4] + " "
                + " " + " " + h[5] + " " + " " + " " + h[6] + " " + " " + " " + h[7] + " " ;
		return output;
	}
}
