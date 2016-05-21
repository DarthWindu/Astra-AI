
public class Academia {
	//Implement BCD here
	public static double addition(String userInput)
	{
		
		return 0;
	}
	public static double subtraction(String userInput)
	{
		return 0;
	}
	//Implement BCD here via an if statement. If the string shows decimals, then convert to double.
	public static double multiplication(String userInput)
	{
		return 0;
	}
	public static double division(String userInput)
	{
		return 0;
	}
	public static int roots()
	{
		return 0;
	}
	public static double square()
	{
		return 0;
	}
	public static int power()
	{
		return 0;
	}
	public static void algebraCalculator()
	{
		
	}
	
	//Uses contains methods to find which calculation it needs to execute.
	public static double figureOutCalculation(String userInput)
	{
		String modUserInput = userInput.substring(1);
		
		if (userInput.contains("+"))
		{
			return addition(modUserInput);
		} else if (userInput.contains("-"))
		{
			return subtraction(modUserInput);
		} else if (userInput.contains("*"))
		{
			return multiplication(modUserInput);
		} else if (userInput.contains("/")) 
		{
			return division(modUserInput);
		} else
		{
			return 0; //Change this to a statement that says it failed or something.
		}
	}
	
}

