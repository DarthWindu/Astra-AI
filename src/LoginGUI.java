

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import javax.swing.JDialog;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//guidance from:    http://docs.oracle.com/javase/8/javafx/get-started-tutorial/form.htm

public class LoginGUI extends Application {
	
	private GridPane grid;
	private Scene scene;
	private TextField userTextField;
	private PasswordField pwBox;
	private Button btnSignIn;
	private Text outputMessage;
	private Button btnCreateUser;
	private Button btnGuestSI;
	private Stage parentStage;
	
	private Charset utf8 = StandardCharsets.UTF_8;
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Welcome to Deneb!");
		parentStage = primaryStage;
		initGrid();
		setScene(primaryStage);
		
		primaryStage.show();
	}
	
	
	private void initSignInButton() {
		btnSignIn = new Button("Sign in");
		HBox hbBtnSignIn = new HBox(10);
		hbBtnSignIn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtnSignIn.getChildren().add(btnSignIn);
		grid.add(hbBtnSignIn, 1, 4);
		
		outputMessage = new Text();
        grid.add(outputMessage, 1, 6);
        
        eventHandle_SignInButton();
	}
	
	private void eventHandle_SignInButton() {
		btnSignIn.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent e) {
                outputMessage.setFill(Color.FIREBRICK);
                outputMessage.setText("Signing in...");
                signIn();
            }
        });
	}
	
	private void forceClick_SignInButton() {
		outputMessage.setFill(Color.FIREBRICK);
        outputMessage.setText("Signing in...");
        signIn();
	}
	
	private void signIn() {
		File user = new File("./lib/Users/" + userTextField.getText() + ".txt");
		if (user.exists() && user.canRead()) {
			List<String> lines = WriterTest1.readLines(user);
			if (lines.get(0).equals(userTextField.getText()) && lines.get(1).equals(pwBox.getText())) {
				MainGuiFramework.launch(new User(lines.get(0)));//Pass username to User
				parentStage.close();
			} else {
				/*System.out.println(lines.get(0).equals(userTextField.getText()));
				System.out.println(lines.get(1).equals(userTextField.getText()));*/
				outputMessage.setText("Incorrect username or password");
			}
		} else {
			JDialog dialog = new JDialog();
			ChoiceContainer parentContainer = new ChoiceContainer();
			dialog.setModal(true);
			dialog.add(new CreateUserPanel(parentContainer));
			dialog.pack();
			dialog.setVisible(true);
			
			if (parentContainer.getUserSaysYes()) {
				forceClick_CreateUserButton();
			} else {
				outputMessage.setText("");
			}
		}
	}
	
	private void initCreateUserButton() {
		btnCreateUser = new Button("Create User");
		HBox hbBtnCreateUser = new HBox(10);
		hbBtnCreateUser.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtnCreateUser.getChildren().add(btnCreateUser);
		grid.add(hbBtnCreateUser, 0, 4);
        
        eventHandle_CreateUserButton();
	}
	
	private void eventHandle_CreateUserButton() {
		btnCreateUser.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent e) {
                outputMessage.setFill(Color.BLACK);
                outputMessage.setText("Creating User...");
                createUser();
            }
        });
	}
	
	private void forceClick_CreateUserButton() {
		outputMessage.setFill(Color.BLACK);
        outputMessage.setText("Creating User...");
        createUser();
	}
	
	private void signIn_Inquiry() {
		JDialog dialog = new JDialog();
		ChoiceContainer parentContainer = new ChoiceContainer();
		dialog.setModal(true);
		dialog.add(new SignInPanel(parentContainer));
		dialog.pack();
		dialog.setVisible(true);
		
		if (parentContainer.getUserSaysYes()) {
			forceClick_SignInButton();
		} else {
			outputMessage.setText("");
		}
	}
	
	private void createUser() {
		File user = new File("./lib/users/" + userTextField.getText() + ".txt");
		if (user.exists() && user.canRead()) {
			signIn_Inquiry();
		} else if (!user.exists()) {
			try {
				user.createNewFile();
				try {
					//<Works>
					List<String> lines = Arrays.asList(userTextField.getText(), pwBox.getText());
					Files.write(Paths.get(user.getPath()), lines, utf8);
					        //  ./ indictates the parent folder to the current folder
					outputMessage.setText("Creating user and signing in...");
					signIn();
				} catch (IOException e) {
					outputMessage.setText("Could not create user. (IO Error. See troublshooting guide.)");
				}catch(InvalidPathException invalidPath) {
					outputMessage.setText("Could not create user. (Invalid Path Error. See troublshooting guide.)");
				}
			} catch (IOException e) {
				outputMessage.setText("Could not create user. (IO Error. See troublshooting guide.)");
			}
			
		}
	}
	
	private void initGuestSIButton() {//Works
		btnGuestSI = new Button("Sign in as Guest");
		HBox hbBtnGuestSI = new HBox(10);
		hbBtnGuestSI.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtnGuestSI.getChildren().add(btnGuestSI);
		grid.add(hbBtnGuestSI, 1, 5);
        
        eventHandle_GuestSIButton();
	}
	
	private void eventHandle_GuestSIButton() {
		btnGuestSI.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent e) {
                outputMessage.setFill(Color.BLUE);
                outputMessage.setText("Signing in with default user...");
                MainGuiFramework.launch();//Pass username to User
				parentStage.close();
            }
        });
	}
	
	private void setScene (Stage primaryStage) {	
		initSignInButton();
		initCreateUserButton();
		initGuestSIButton();
		
		Text sceneTitle = new Text("Welcome! Please login.");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(sceneTitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);

		userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);
		
		
		scene = new Scene(grid, 500, 500);
		primaryStage.setScene(scene);
	}
	
	private void initGrid() {
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
	}

}
