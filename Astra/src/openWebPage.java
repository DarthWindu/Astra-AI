import java.awt.Desktop;
import java.net.URL;
//import java.awt.*; not necessary, keep as a reference
//import java.net.*; not necessary, keep as a reference


public class openWebPage {
	public static void openWebpage(String urlString) {
		try {
			Desktop.getDesktop().browse(new URL(urlString).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//https://www.google.com/#q=does+googles+url+stay+the+same
	//^^Example of a google search URL.^^
	
	/**
	 * This method is to generate a google search URL to make searching easier to do.
	 * @param userInput
	 * @return
	 */
	public static String googleUrlGenerator(String userInput)
	{
		userInput = userInput.replaceAll(" ", "+");
		String googleUrl = "https://www.google.com/#q=" + userInput;
		return googleUrl;
	}
	
	
	/**
	 * Trys to open a webpage directly from a user's String. It has a few error checkers in case something
	 * does go wrong, which it could.
	 * @param userUrl
	 */
	public static void openSpecificWebpage(String userUrl)
	{
		try 
		{
			openWebpage(userUrl);
		} catch (Exception E)
		{
			
		}
	}
	public static void main(String[] args) {
		//openWebpage("http://google.com"); //Opens up google's home page.
		//openWebpage(googleUrlGenerator("What is the best coding language?"));  //Opens up "What is the best coding language in google
		openSpecificWebpage("htp://google.com");
	}
}