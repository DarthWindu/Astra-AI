/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Outside resources were used.
 * The word reference texts http://www.gutenberg.org/ebooks/3201 <- Moby Word Lists by Grady Ward
 * The words in the text file are credited to him: Moby Word ListsLanguage EnglishLoC Class
 * @author WinPM
 */
public class MainGuiFramework extends JFrame {

	static ArrayList <String> commandsList = new ArrayList();
	static double answer;
	static int friendship;
	
	private String userName;
	/**
	 * Creates new form Chatbox
	 */
	public MainGuiFramework() {
		initComponents();
		this.setTitle("Deneb: " + System.getProperty("user.name"));
		String ini = this.chooseInitialSaying();
		consoleOutputArea.setText(ini);
		ImageIcon icon = new ImageIcon("./res/Denebhead.png");
		this.setIconImage(icon.getImage());
		userName = System.getProperty("user.name");
	}
	
	public MainGuiFramework(User user) {
		initComponents();
		this.setTitle("Deneb: " + user.getSessionName());
		String ini = this.chooseInitialSaying();
		consoleOutputArea.setText(ini);
		ImageIcon icon = new ImageIcon("./res/Denebhead.png");
		this.setIconImage(icon.getImage());
		userName = user.getUserName();
	}


	/**
	 * Code for choosing what initial saying
	 */
	public String chooseInitialSaying(){
		int lineNumber = friendship;
		String fileThing = null;
		File text = new File("./lib/Sayings.txt");
		Scanner input;
		try 
		{
			text.createNewFile();
			input = new Scanner(text);
			for (int lineNumberCounter = 0; lineNumberCounter <= lineNumber && input.hasNextLine(); lineNumberCounter++)
				fileThing = input.nextLine();

		}

		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return fileThing;
	}



	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	public void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		consoleOutputArea = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		inputTextArea = new javax.swing.JTextArea();
		btnSendInput = new javax.swing.JButton();
		pictureLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		consoleOutputArea.setEditable(false);
		consoleOutputArea.setColumns(20);
		consoleOutputArea.setRows(5);
		jScrollPane1.setViewportView(consoleOutputArea);

		inputTextArea.setColumns(20);
		inputTextArea.setRows(5);
		jScrollPane2.setViewportView(inputTextArea);

		btnSendInput.setText("Enter");
		btnSendInput.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSendInputActionPerformed(evt);
			}
		});

		ImageIcon im = new ImageIcon("./res/DenebSpriteOne.png");
		pictureLabel.setIcon(im); // NOI18N
		pictureLabel.setToolTipText("");
		pictureLabel.setName(""); // NOI18N

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnSendInput, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
												.addComponent(jScrollPane1))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(pictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGap(12, 12, 12))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(pictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnSendInput, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
				);

		pack();
	}// </editor-fold>                        

	

	/**
	 * Error word checking. This else if statement is to check using a database
	 * of nearly 600K words (Stored in 2 different text files) that would validate
	 * whether words are spelled correctly or if words actually exist.
	 * 
	 * File location home: G:/Downloads/words.txt
	 * File location home: G:/Downloads/words2.txt
	 * File location project: ./res/words.txt and ./res/words2.txt
	 */
	public void btnSendInputActionPerformed(java.awt.event.ActionEvent evt) {                                             
		// TODO add your handling code here:
		try
		{
			String newText = inputTextArea.getText();
			if (newText.isEmpty())
			{//Do nothing
			}

			else if (wordChecker(newText))
			{
				consoleOutputArea.setText(consoleOutputArea.getText()+ "\n" + userName + ": " +newText);
				inputTextArea.setText("");
				consoleOutputArea.setText(consoleOutputArea.getText()+ "\nDeneb: "+Deneb.simpleActivator(newText));

				ImageIcon im = new ImageIcon("./res/DenebSpriteIdle.jpg");
				pictureLabel.setIcon(im);
			}
			
			
			else if (Deneb.commandLine(newText))
			{
				consoleOutputArea.setText(consoleOutputArea.getText()+ "\n"+userName+": "+newText);
				inputTextArea.setText("");
				Deneb.executeCommandLine(newText);
				
				if (newText.equals("/commands"))
				{
					ImageIcon im = new ImageIcon("./res/DenebSpriteThinking.jpg");
					pictureLabel.setIcon(im);
					ImageIcon icon = new ImageIcon("./res/DenebSpriteThinking.png");
					this.setIconImage(icon.getImage());
					consoleOutputArea.setText(consoleOutputArea.getText()+ "\nDeneb: " + commandsList);
					consoleOutputArea.setText(consoleOutputArea.getText()+ "\nDeneb:\n/commands shows a list of commands,"
							+"\n/search <insert what you want to search> will bring up a google search,"
							+"\n/calculate <insert number [operand] number> will work as a four function"
							+"\n/calculatetb will calculate brackets in the notepad and post results in a new one."
							+"\n/terminate will close out of the programs"
							+"\n/define <insert word/words> will bring up a google search for the define"
							+"\n/open <URL> opens that URL");
				}
				else if (newText.substring(0,10).equals("/calculate"))
				{
					System.out.println(answer);
				}
				
				else if(newText.equals("/terminate"))
				{
					System.out.println(" **** ");
					this.dispose();
					this.setVisible(false);
					
				}
			}
			

			else if (Deneb.commandLine(newText) == false)
			{
				consoleOutputArea.setText(consoleOutputArea.getText()+ "\nDeneb: I'm sorry, \""+newText+"\" is invalid in my databanks. Try \"/commands\" for a list of commands.");
				inputTextArea.setText("");
			}

			else
			{
				consoleOutputArea.setText(consoleOutputArea.getText() + "\n"+userName+": " + newText);
				inputTextArea.setText("");
			}
		}
		catch(Exception e)
		{       
			
		}
	}                                            


	/**
	 * This method checks whether the words are valid or not. This method
	 * references two different text files with words inside them.
	 * @param needsChecking
	 * @return wordsExist
	 */
	public static boolean wordChecker(String needsChecking)
	{
		File text = new File("./res/words.txt");
		File text2 = new File("./res/words2.txt");

		boolean wordsExist=false;
		needsChecking = needsChecking.toLowerCase();

		//Word Splitter method. This method gets each word in the sentence its
		//own space in an ArrayList of Strings. Then it proceeds to 
		//iterate over a loop in the try statement.

		try
		{
			text.createNewFile();
			text2.createNewFile();
		
			//needToFind is the string that is needed to be found
			//needsChecking is the string that has been unchecked and will be checked later.
			for (int counter =0;!needsChecking.isEmpty();counter++)
			{
				String needToFind = null;
				if (needsChecking.contains(" ")){
					needToFind = needsChecking.substring(0,needsChecking.indexOf(" "));
					needsChecking = needsChecking.substring(needToFind.length()+1);
				} 

			
				
				else 
				{
					needToFind = needsChecking.substring(0,needsChecking.length());
					needsChecking = needsChecking.substring(needToFind.length());
				}

				//if the word we are trying to find has punctuation, call the cutter method.
				if (punctuation(needToFind))
				{
					needToFind = changePunctuations(needToFind);
				}

				//This is just to test what string it needsToFind and
				//What string that still needs checking.
				//System.out.println(needToFind + " @ ");
				//System.out.println(needsChecking + "!");

				Scanner input;
				Scanner input2;
				input = new Scanner(text);
				input2 = new Scanner(text2);


				String wordFound = "@";
				wordsExist = false;

				//Search method 1 - Searches the file. Add binary search here.
				for (int lineNumber = 0; !wordsExist && input.hasNextLine(); lineNumber++)
				{
					wordFound = input.next();
					if (wordFound.toLowerCase().equals(needToFind))
					{
						wordsExist = true;
					}
				}


				//Search method 2 - Searches the file. Add binary search here
				for (int lineNumber = 0; !wordsExist && input2.hasNextLine(); lineNumber++)
				{
					wordFound = input2.next();
					if (wordFound.toLowerCase().equals(needToFind))
					{
						wordsExist = true;
					}
				}
				
				input.close();
				input2.close();
				if(!wordsExist)
					break;

			}

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		//System.out.println(wordsExist);

		return wordsExist;
	}


	
	/**
	 * This method returns true if the string has punctuation of any sort attached to the back of it.
	 */
	public static boolean punctuation(String needsChecking)
	{
		if (needsChecking.length()>0){
			if (needsChecking.substring(needsChecking.length()-1).equals("."))		
			{
				return true;
			} else if (needsChecking.substring(needsChecking.length()-1).equals(","))
			{
				return true;
			} else if (needsChecking.substring(needsChecking.length()-1).equals("!"))
			{
				return true;
			} else if (needsChecking.substring(needsChecking.length()-1).equals("?"))
			{
				return true;
			} else if (needsChecking.substring(needsChecking.length()-1).equals(";"))
			{
				return true;
			}
		}
		

		return false;

	}

	/**
	 * punctuation cutter. Cuts punctuation off of any unsuspecting Strings that have gotten lax.
	 */
	public static String changePunctuations(String needsWork)
	{
		needsWork = needsWork.substring(0,needsWork.length()-1);
		return needsWork;
	}

	//Sets commands. Called from deneb.
	public static void setCommands()
	{
		commandsList.add("/commands");
		commandsList.add("/search");
		commandsList.add("/calculate");
		commandsList.add("/calculatetb");
		commandsList.add("/define");
		commandsList.add("/terminate");
		commandsList.add("/open");
	}

	//sets answer variable. Called from Deneb.
	public static void setAnswer(double ans)
	{
		answer = ans;
	}
	
	public static void setFriendship(int fr)
	{
		friendship = fr;
	}
	
	public static void launch() {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainGuiFramework.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainGuiFramework.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainGuiFramework.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainGuiFramework.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainGuiFramework().setVisible(true);
			}
		});
	}
	
	public static void launch(User user) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainGuiFramework.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainGuiFramework.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainGuiFramework.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainGuiFramework.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainGuiFramework(user).setVisible(true);
			}
		});
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		//launch();
		LoginGUI.launch(LoginGUI.class);
	}

	// Variables declaration - do not modify                     
	private javax.swing.JButton btnSendInput;
	private javax.swing.JTextArea consoleOutputArea;
	private javax.swing.JTextArea inputTextArea;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel pictureLabel;
	// End of variables declaration                   
}
