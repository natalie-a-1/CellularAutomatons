/**
 * This is a subclass of the class Exception. This class throws an exception
 * when the ruleNum is outside of a given range.
 * 
 * 
 * @author Natalie Hill
 *
 */

public class RuleNumException extends Exception {

	private static final long serialVersionUID = 0;

	/**
	 * 
	 * @param min the smallest value allowed in a range
	 * @param max the largest value allowed in a range
	 */

	public RuleNumException(int min, int max) {

		super("ruleNum is outside the range " + "[" + min + ", " + max + "].");
	}
}
