import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.File;
import javax.swing.border.*;


/**
 * The first of the Artificial Intelligence programs. This program is meant to be able to do all of the 
 * functions that I don't feel like doing myself, such as sending emails, calculating tournament brackets,
 * and finding definitions of words. Deneb will use keywords in order to distinguish commands,
 * and will utilize a grammar structure analyzer in order to be able to chat.
 * @author Joshua Shin + Pujit Mehrotra
 */
public class Deneb extends Astra implements Entertania, Miscellania, Clubs
{
	//|||||||||||||||||||||||||||||||||||Class variables and Constructors|||||||||||||||||||||||||||||||||
	public static int friendship;
	public static int startupCount;

	/**Default Constructor
	 * This constructor creates the GUI
	 */
	Deneb ()
	{
		this.mainGUI();
	}



	//|||||||||||||||||||||||||||||||||||End of Constructors |||||||||||||||||||||||||||||||||||||||||||||
	//=================================================================================================|||
	//|||||||||||||||||||||||||||||||||||Extended Methods|||||||||||||||||||||||||||||||||||||||||||||||||



	/**
	 * Startup method. This method starts up the mainGui by calling the main method
	 * from the MainGuiFrameword class. This is done at the bottom by sending a
	 * null String[].
	 * 
	 * This method also checks the friendship counter and the startup counter.
	 * It does that by finding the file
	 */
	public void mainGUI() 
	{
		int lineNumber = 0;
		String fileThing = null;
		File text = new File("G:/SPRITES/counters.txt");
		Scanner input;
		try 
		{
			text.createNewFile();
			input = new Scanner(text);
			for (int lineNumberCounter = 0; lineNumberCounter <= lineNumber && input.hasNextLine(); lineNumberCounter++)
				friendship = Integer.parseInt(input.nextLine());

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		lineNumber=1;

		try 
		{
			text.createNewFile();
			input = new Scanner(text);
			for (int lineNumberCounter = 0; lineNumberCounter <= lineNumber && input.hasNextLine(); lineNumberCounter++)
				startupCount = Integer.parseInt(input.nextLine());

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		System.out.println(friendship);
		System.out.println(startupCount);

		String[] args = null;
		MainGuiFramework.main(args);
	}


	//Extended analzyers
	public void complexGrammarAnalyzer(){}


	/**Scans for simple signs that could differentiate mathematical equations from strings. 
	 * 
	 * @param userInput
	 */
	public void simpleGrammarAnalyzer(String userInput) 
	{ 
		if (easterEggDetector())
		{
			easterEggReturner(userInput);
		} 

		else if (terminateSequence(userInput))
		{

		} 

	}
	//End of simpleGrammarAnalyzer method





	//|||||||||||||||||||||||||||||||||||End of Extended Methods|||||||||||||||||||||||||||||||||||
	//|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	//|||||||||||||||||||||||||||||||||||Methods|||||||||||||||||||||||||||||||||||||||||||||||||||


	//If the userInput contians a terminate sequence String, then terminate becomes true, and the program terminates.
	//Add more test cases.
	public boolean terminateSequence(String userInput)
	{
		if (userInput.contains("terminate sequence"))
		{
			return true;
		}
		return false;
	}



	//Cuts the initial Deneb off of the userInput to make it easier to comprehend.
	public String subStringCutter(String userInput)
	{
		while (userInput.substring(0,7).equals("Deneb, ") || userInput.substring(0,6).equals("Deneb "))
		{
			if (userInput.substring(0,7).equals("Deneb, "))
				userInput = userInput.substring(0,7);
			else 
				userInput = userInput.substring(0,6);
		}
		return userInput;
	}


	//calls to EasterEggsDetector
	public static boolean easterEggDetector()
	{
		if (EasterEggsDetector.easterEggDetector())
		{
			return true;
		}

		return false;
	}

	//calls to EasterEggsDetector
	public static String easterEggReturner(String userInput)
	{
		String easterEgg;
		easterEgg = EasterEggsDetector.easterEggReturner(userInput);
		return easterEgg;
	}

	public int getFriendship()
	{
		return friendship;
	}

	public int getStartup()
	{
		return startupCount;
	}


	//|||||||||||||||||||||||||||||||||||||||||||||End of Methods||||||||||||||||||||||||||||||||||||||||||
	//|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	//|||||||||||||||||||||||||||||||||||||||||||||||main||||||||||||||||||||||||||||||||||||||||||||||||||



	/**
	 * The main method should open up a GUI for Deneb. 
	 * Still WIP, remove comment after completion.
	 * 
	 * @param args
	 */
	public static void main(String [] args)
	{
		Deneb deneb = new Deneb();
	}

}
