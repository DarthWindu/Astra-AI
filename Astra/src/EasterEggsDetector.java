
public class EasterEggsDetector {
	

	String finalEasterString;
	
	public static String easterEggReturner(String userInput)
	{
		if (userInput.contains("What")){
			whatAnalyzer();
		} else if (userInput.contains("How")){
			howAnalyzer();
		} else if (userInput.contains("Who")){
			whoAnalyzer();
		} else if (userInput.contains("Why")){
			whyAnalyzer();
		} else if (userInput.contains("Where")){
			whereAnalyzer();
		} else if (userInput.contains("When")){
			whenAnalyzer();
		} else {
			regularEasterEggAnalyzer();
		}
		
		return null;
	}
	
	public static boolean easterEggDetector()
	{
		
		return false;
	}

	private static void whenAnalyzer() {
		// TODO Auto-generated method stub
		
	}

	private static void whereAnalyzer() {
		// TODO Auto-generated method stub
		
	}

	private static void whyAnalyzer() {
		// TODO Auto-generated method stub
		
	}

	private static void whoAnalyzer() {
		// TODO Auto-generated method stub
		
	}

	private static void howAnalyzer() {
		// TODO Auto-generated method stub
		
	}

	private static void whatAnalyzer() {
		// TODO Auto-generated method stub
		
	}

	private static void regularEasterEggAnalyzer() {
		// TODO Auto-generated method stub
		
	}
}
