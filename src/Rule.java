
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

	//Collaborated with Keon on getNeighborhoodByRadius
	public static boolean[] getNeighborhoodByRadius(int idx, int radius, Generation gen) {


		boolean [] tempo = new boolean[(2*radius)+1];

		//idx = idx + radius;

			for (int i = -radius; i < radius+1; i++) {

				int x = Math.floorMod(idx+i, gen.size());
				tempo[radius+i]= gen.getState(x);

			}

		return tempo;

	}

}
