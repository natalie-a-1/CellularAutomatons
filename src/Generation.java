import java.util.Arrays;

public class Generation {
	
private boolean[] cellStates;

	public boolean[] getStates() {

		boolean[] output = new boolean[cellStates.length];

		for (int i = 0; i < cellStates.length; i++) {

			output[i] = cellStates[i];
		}
		return output;
	}

	public boolean getState(int idx) {
		
		boolean[] arr = Arrays.copyOf(cellStates, cellStates.length);
		
		return arr[idx];
	}

	// getStates is from Keon
	public String getStates(char falseSymbol, char trueSymbol) {

		String output = "";

		for (int i = 0; i < size(); i++) {

			if (cellStates[i] == true) {

				output = output + trueSymbol;

			} else {

				output = output + falseSymbol;
			}
		}
		return output;
	}

	public int size() {
		
		boolean[] arr = Arrays.copyOf(cellStates, cellStates.length);
		
		return arr.length;
	}

	public Generation(boolean... states) {

		if (states == null || states.length == 0) {

			boolean[] falseB = { false };

			cellStates = Arrays.copyOf(falseB, falseB.length);

		} else {

			cellStates = Arrays.copyOf(states, states.length);
		}
	}

	// Generation (states,trueSymbol) is from Keon
	public Generation(String states, char trueSymbol) {

		boolean[] f = { false };

		if (states == null || states == "") {

			cellStates = f;

		} else {

			cellStates = new boolean[states.length()];

			for (int i = 0; i < states.length(); i++) { 

				if (states.charAt(i) == trueSymbol) {

					cellStates[i] = true;

				} else {

					cellStates[i] = false;
				}
			}
		}
	}
}