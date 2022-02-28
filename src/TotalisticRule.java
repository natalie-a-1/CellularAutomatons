import java.util.Arrays;
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

	//collaborated with Keon
	@Override
	public boolean[] getNeighborhood(int idx, Generation gen) {
		
		boolean[] temp = new boolean[5];
        if (idx - 2 == -1) {
            temp[0] = gen.getState(gen.size()-1);
            temp[1] = gen.getState(0);
            temp[2] = gen.getState(1);
            temp[3] = gen.getState(2);
            temp[4] = gen.getState(3);
        }
        else if (idx - 1 == -1) {
            temp[0] = gen.getState(gen.size()-2);
            temp[1] = gen.getState(gen.size()-1);
            temp[2] = gen.getState(idx);
            temp[3] = gen.getState(idx+1);
            temp[4] = gen.getState(idx+2);
        }
        else if (idx + 2 == gen.size()) {
            temp[0] = gen.getState(idx-2);
            temp[1] = gen.getState(idx-1);
            temp[2] = gen.getState(idx);
            temp[3] = gen.getState(idx+1);
            temp[4] = gen.getState(0);
        }
        else if (idx + 1 == gen.size()) {
            temp[0] = gen.getState(idx-2);
            temp[1] = gen.getState(idx-1);
            temp[2] = gen.getState(idx);
            temp[3] = gen.getState(0);
            temp[4] = gen.getState(1);
        }
        else {
            temp[0] = gen.getState(idx-2);
            temp[1] = gen.getState(idx-1);
            temp[2] = gen.getState(idx);
            temp[3] = gen.getState(idx+1);
            temp[4] = gen.getState(idx+2);
        }
        return temp;
	}

	//Recived help on evolve method from Keon
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
        	
            output = false;
            
        }
        else if (counter == 1) {
        	
            output = true;
            
        }
        else if (counter == 2) {
        	
            output = true;
            
        }
        else if (counter == 3) {
        	
            output = false;
        }
        else if (counter == 4) {
        	
            output = true;
        }
        else if (counter == 5) {
        	
            output = false;
        }
        return output;

	}

	//collaborated with Keon on rule table
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
