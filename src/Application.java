
public class Application {

	private static final int NUM_EXPECTED_ARGS = 6;

	private static final int IDX_CA = 0;
	private static final int IDX_RULE_NUM = 1;
	private static final int IDX_FALSE_SYMBOL = 2;
	private static final int IDX_TRUE_SYMBOL = 3;
	private static final int IDX_INITIAL_GENERATION = 4;
	private static final int IDX_NUM_EVOLVE = 5;

	private static final String ARG_NAMES = "ca rule-num false-symbol true-symbol initial-generation num-evolutions";

	// Source and class file names must match, so Application can be hard-coded
	private static final String USAGE_FMT_STRING_CLASS = "Usage: java Application " + ARG_NAMES;

	// The jar file may be renamed, so this will be varied
	private static final String USAGE_FMT_STRING_JAR = "Usage: java -jar %s " + ARG_NAMES;

	private String[] appArgs;
	
	/**
	 * This is a constructor for an Application.
	 * 
	 * @param args	is a list of features which determine the creation of the Automaton and Application
	 */

	public Application(String[] args) {

		validateNumArgs(args);

		appArgs = args;
	}

	private void validateNumArgs(String[] args) {

		if (args.length != NUM_EXPECTED_ARGS) {

			throwRuntimeExceptionWithUsageMessage();
		}
	}

	private void throwRuntimeExceptionWithUsageMessage() {
		// Implementation provided
		if (runningAsJar()) {
			// Get the path to the executing file
			String path = Application.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			// Only take path after last slash (to get file name).
			// A hard-coded slash is fine since Java URLs use /
			String file = path.substring(path.lastIndexOf("/") + 1);
			throw new RuntimeException(String.format(USAGE_FMT_STRING_JAR, file));
		} else {
			throw new RuntimeException(String.format(USAGE_FMT_STRING_CLASS));
		}
	}

	private boolean runningAsJar() {
		// Implementation provided
		return Application.class.getResource("Application.class").toString().startsWith("jar");
	}

	// Collaborated with Keon
	private void parseArgs(String[] args) {

		try {

			// assigning variables
			CellularAutomaton ca = CellularAutomaton.parse(args[0]);

			int ruleNum = Integer.parseInt(args[1]);

			char falseSymbol = args[2].charAt(0);

			char trueSymbol = args[3].charAt(0);

			String gen = args[4];

			int num_evolutions = Integer.parseInt(args[5]);

			// creating objects
			Generation initial = new Generation(gen, trueSymbol);

			Automaton automaton = Automaton.createAutomaton(ca, ruleNum, initial);
			
			automaton.falseSymbol = falseSymbol;
			automaton.trueSymbol = trueSymbol;

			automaton.evolve(num_evolutions);

			System.out.println(automaton);

		} catch (Exception e) {

			throw new RuntimeException(e.getMessage());

		}
	}
	
	/**
	 * This method uses parseArgs to take in the given parameters and run the program.
	 */

	public void run() {

		parseArgs(appArgs);
	}
	
	/**
	 * This is the main method which executes the program.
	 * 
	 * @param args	is a list of features which determine the creation of the Automaton and Application
	 */

	// collaborated with Keon
	public static void main(String[] args) {

		try {

			Application temp = new Application(args);

			temp.run();

		} catch (Exception RuntimeException) {

			System.err.println(RuntimeException.getMessage());

		}
	}

	private static void Application(String[] args) {

	}
}
