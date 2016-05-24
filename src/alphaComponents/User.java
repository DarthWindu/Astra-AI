package alphaComponents;

import java.io.File;


public class User {
	private final String userName;//User Name of person logged in
	private String sessionName;//Displayed name of person logged in - can be changed.
	private File userConfig;
		
	User(String enteredUserName, File configFile) {
		userName = enteredUserName;
		sessionName = enteredUserName;
		userConfig = configFile;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getSessionName() {
		return sessionName;
	}
	
	public File getUserConfigFile() {
		return userConfig;
	}

}
