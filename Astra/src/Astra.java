/**
 * The main abstract class that all of the A.I. programs
 * are based off of. This class will contain a list of abstract
 * methods that can be specialized as necessary, because different A.I.
 * will use different methods.
 * @author jshin5021
 *
 */
public abstract class Astra {
	//Methods used for initiating
	public abstract String simpleGrammarAnalyzer(String userInput);
	public abstract void complexGrammarAnalyzer();
	public abstract void mainGUI();
}
