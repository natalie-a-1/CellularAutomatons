
public abstract class Rule {

	private int ruleNum;
	
	public boolean[] rules = new boolean[8];

	
	protected Rule(int ruleNum) {
		
		this.ruleNum = ruleNum;
		
	}
		
	
	public int getRuleNum() {
		
		int code = ruleNum;
		
		return code;
		
	}
	
	public abstract boolean[] getNeighborhood(int idx, Generation gen);
	
	public abstract boolean evolve(boolean[] neighborhood);
	
	public Generation evolve(Generation gen) {
		
		boolean[] arr = new boolean[gen.size()];

		// for loop from Aaron Coker

		for (int i = 0; i < gen.size(); i++) {

			arr[i] = evolve(getNeighborhood(i, gen));

		}
		return new Generation(arr);
		
	}
	
	public abstract String ruleTableString(char falseSymbol, char trueSymbol);
	
	public static boolean[] getNeighborhoodByRadius(int idx, int radius, Generation gen) {
		
		return null;
		
	}
	
}
