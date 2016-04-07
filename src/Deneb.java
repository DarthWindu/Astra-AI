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
	Deneb () {
		this.mainGUI();
		
		int lineNumber = 0;
		String aaa = null;
		File text = new File("z:/textFile.txt");
		Scanner input;
		try 
		{
			input = new Scanner(text);
			for (int lineNumberCounter = 0; lineNumberCounter <lineNumber && input.hasNextLine(); lineNumberCounter++)
			{
				aaa = input.nextLine();
			}

		}

		catch (Exception ex)
		{
			System.out.println("didnt work");
		}
	}



	//|||||||||||||||||||||||||||||||||||End of Constructors |||||||||||||||||||||||||||||||||||||||||||||
	//=================================================================================================|||
	//|||||||||||||||||||||||||||||||||||Extended Methods|||||||||||||||||||||||||||||||||||||||||||||||||



	/**
	 * Put code here to make the GUI
	 */
	public void mainGUI() {
		
	}


	//Extended analzyers
	public void complexGrammarAnalyzer(){}
	public void simpleGrammarAnalyzer() {}
	public void academiaAnalyzer() {}
	public void entertainiaAnalyzer() {}
	public void miscellaniaAnalyzer() {}
	public void databasiaAnalyzer() {}
	public void clubsAnalzyer() {}


	/**Scans for simple signs that could differentiate mathematical equations from strings. 
	 * 
	 * @param userInput
	 */
	public void simpleGrammarAnalyzer(String userInput) 
	{
		//[P] What is the purpose of String ref. Initializations in ln 57-61
		//[J] I don't really need all different strings. I just made them because I could.
		String academiaString;

		final String space = " ";
		final String no_content = "";

		//[P] Question ln 65-74: what happens if there are multiple operations? E.x 4+3+1-4*6 
		//[J] Good question. You we should make a loop structure that takes the first and returns another, edits the string.
		//[J] then it continues with the string until all are completed.
		academiaString = userInput.replaceAll(space,no_content);
		if (academiaString.contains("+")){
			this.addition();
		} else if (academiaString.contains("-")){
			this.subtraction();
		} else if (academiaString.contains("*")){
			this.multiplication();
		} else if (academiaString.contains("/")){
			this.division();
		}

	}
	//End of simpleGrammarAnalyzer method





	//|||||||||||||||||||||||||||||||||||End of Extended Methods|||||||||||||||||||||||||||||||||||
	//|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	//|||||||||||||||||||||||||||||||||||Methods|||||||||||||||||||||||||||||||||||||||||||||||||||

	public void startup(){
		
	}
	
	
	public long addition()
	{
		Academia.addition();
		return 0;//RETURN STATEMENT ONLY TO PREVENT RUN ERROR
	}

	public long subtraction(){
		return 0;
	}

	public long multiplication(){
		return 0;
	}

	public double division(){
		return 0;
	}

	public void roots() {
	}

	public double square(){
		return 0;
	}

	public int power() {
		return 0;
	}

	public void algebraCalculator() {
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
