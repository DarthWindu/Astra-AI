import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	static ArrayList <String> commandsList = new ArrayList();


	/**Default Constructor
	 * This constructor creates the GUI
	 */
	Deneb ()
	{
		try{
			Scanner input = new Scanner(System.in);
			File file = new File("./lib/FriendshipCounter.txt");
			input = new Scanner(file);

			String counter = input.nextLine();
			int countedInt = Integer.parseInt(counter);
			countedInt++;
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			counter = Integer.toString(countedInt);
			for (int i = 0; i< 1;i++)
			{
				bw.write(counter);
				bw.newLine();
			}
			bw.close();
			MainGuiFramework.setFriendship(countedInt);

		} catch (IOException e) {
			e.printStackTrace();
		}

		this.mainGUI();

	}

	Deneb (String userInput)
	{

	}


	//|||||||||||||||||||||||||||||||||||End of Constructors |||||||||||||||||||||||||||||||||||||||||||||
	//=================================================================================================|||
	//|||||||||||||||||||||||||||||||||||Extended Methods|||||||||||||||||||||||||||||||||||||||||||||||||



	/**
	 * Startup method. This method starts up the mainGui by calling the main method
	 * from the MainGuiFrameword class. This is done at the bottom by sending a
	 * null String[].
	 * 
	 * edit: no longer is used. Build path was changed. 
	 * 
	 */
	public void mainGUI() 
	{
		//int lineNumber = 0;
		//String fileThing = null;
		//File text = new File("./res/counters.txt");
		//Scanner input;
		/*	try 
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


		 */ //Comment is for friendship and stuff. Implement later.

	}


	//Extended analzyers
	public void complexGrammarAnalyzer(){}


	/**Scans for small distinctions. Haven't gotten to too much true analyzing, so still a WIP.
	 * @param userInput
	 */
	public String simpleGrammarAnalyzer(String userInput) 
	{ 
		if (userInput.contains("yes"))
			return "Ok. Try /commands";
		else if (userInput.contains("you") && userInput.contains("like"))
			return "I haven't thought about that yet. Sorry :)";
		else if (userInput.contains("how") && (userInput.contains("are")|| userInput.contains("is")))
			return "Pretty peppy";
		else
			return "I'm not quite sure I understand. I'll leave a note though for josh to fix it.";
		



	}
	//End of simpleGrammarAnalyzer method

	public static String simpleActivator(String userInput)
	{
		Deneb usage = new Deneb(userInput);
		return usage.simpleGrammarAnalyzer(userInput);
	}





	//|||||||||||||||||||||||||||||||||||End of Extended Methods|||||||||||||||||||||||||||||||||||
	//|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	//|||||||||||||||||||||||||||||||||||Methods|||||||||||||||||||||||||||||||||||||||||||||||||||


	/*
	 * List of Commands
	 *  /Commands
	 *  /Search (GOOGLE)
	 *  /Calculate (MATHEMATICS)
	 *  /CalculateTB (BRACKETS CHALLONGE)
	 *  /Terminate (CLOSE)
	 *  /Define (GOOGLE DEF?)
	 *  /Open (URL)
	 */

	//Still WIP
	//This should technically be void, because the commands are going in not to return anything. However,
	//Some will return stuff, like calculate. Figure out how to implement
	//WIP
	public static void executeCommandLine(String userInput)
	{



		if (userInput.equals("/commands"))
		{
			MainGuiFramework.setCommands();
		} 

		else if (userInput.equals("/terminate"))
		{

		}	
		else if (userInput.equals("/calculatetb"))
		{	
			String [] args = null;
			tempoDeneb.main(args);
		}
		
		else if (userInput.equals("/calculator"))
		{
			Calculator calc = new Calculator();
			calc.launchCalculator();
		} 
		
		else if (userInput.substring(0,userInput.indexOf(" ")).equals("/search"))
		{
			openWebPage.googleSearch(userInput);
		}

		

		else if (userInput.substring(0, userInput.indexOf(" ")).equals("/define"))
		{
			openWebPage.googleDefine(userInput);
		}
		else if (userInput.substring(0, userInput.indexOf(" ")).equals("/open"))
		{
			openWebPage.urlGenerator(userInput);
		} 
		else
		{

		}

	}

	//If the userInput contains a terminate sequence String, then terminate becomes true, and the program terminates.
	//Add more test cases.
	public static boolean terminateSequence(String userInput)
	{
		if (userInput.contains("terminate sequence"))
		{
			return true;
		}
		return false;
	}

	//Detects for command line command words. Uses .equals() method
	//Also checks for validity of words.
	public static boolean commandLine(String userInput)
	{

		if (userInput.equals("/commands"))
		{
			return true;
		}

		if (userInput.equals("/terminate"))
		{
			return true;
		}
		
		if (userInput.equals("/calculator"))
		{
			return true;
		}

		if (userInput.substring(0,1).equals("/"))
		{
			for (String item: commandsList)
			{

				if(userInput.contains(" "))
				{
					if (userInput.substring(0,userInput.indexOf(" ")).equals(item))
					{
						return true;
					}
				} else {
					if (userInput.equals(item))
					{
						return true;
					}
				}

			}
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

	//Used to reference friendship counter as necessary
	public int getFriendship()
	{
		return friendship;
	}

	//Used to reference startupCount as necessary.
	public int getStartup()
	{
		return startupCount;
	}


	/**
	 * Adds the commands into an ArrayList. Should be called at startup.
	 * It could easily be initialized, but I put it in it's separate
	 * method in order to easily add and subtract commands.
	 */
	public void commandLineStartup()
	{
		commandsList.add("/commands");
		commandsList.add("/search");
		commandsList.add("/calculator");
		commandsList.add("/calculatetb");
		commandsList.add("/define");
		commandsList.add("/terminate");
		commandsList.add("/open");
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
		deneb.commandLineStartup();
		args = null;
		MainGuiFramework.main(args);
	}

}
