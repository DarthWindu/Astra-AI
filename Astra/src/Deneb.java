import java.util.*;
import java.util.Arrays;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import javax.swing.border.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

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
	private static int friendship;
	private static int startupCount;

	/**Default Constructor
	 * This constructor creates the GUI
	 */
	Deneb ()
	{
		this.mainGUI();
		int lineNumber = 0;
		String fileThing = null;
		File text = new File("c:/Users/Owner/Desktop/textFile.txt");
		Scanner input;
		try 
		{
			text.createNewFile();
			input = new Scanner(text);
			for (int lineNumberCounter = 0; lineNumberCounter <lineNumber && input.hasNextLine(); lineNumberCounter++)
				fileThing = input.nextLine();
		}

		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}



	//|||||||||||||||||||||||||||||||||||End of Constructors |||||||||||||||||||||||||||||||||||||||||||||
	//=================================================================================================|||
	//|||||||||||||||||||||||||||||||||||Extended Methods|||||||||||||||||||||||||||||||||||||||||||||||||



	/**
	 * Put code here to make the GUI
	 */
	public void mainGUI() 
	{

	}


	//Extended analzyers
	public void complexGrammarAnalyzer(){}


	/**Scans for simple signs that could differentiate mathematical equations from strings. 
	 * 
	 * @param userInput
	 */
	public void simpleGrammarAnalyzer(String userInput) 
	{ 
		if (easterEggDetector()){
			easterEggReturner(userInput);
		} else if (terminateSequence(userInput)){

		} 

	}
	//End of simpleGrammarAnalyzer method





	//|||||||||||||||||||||||||||||||||||End of Extended Methods|||||||||||||||||||||||||||||||||||
	//|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	//|||||||||||||||||||||||||||||||||||Methods|||||||||||||||||||||||||||||||||||||||||||||||||||


	//If the userInput contians a terminate sequence String, then terminate becomes true, and the program terminates.
	//Add more test cases.
	public boolean terminateSequence(String userInput){
		if (userInput.contains("terminate sequence")){
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
