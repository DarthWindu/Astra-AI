package alphaComponents;

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
	
	private Charset utf8 = StandardCharsets.UTF_8;
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Welcome to Deneb!");
		
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
                //Check if file exists. Check if username and password match. Open Deneb with username
            }
        });
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
	
	private void createUser() {
		File user = new File("./lib/users/" + userTextField.getText() + ".txt");
		if (user.exists() && user.canRead()) {
			//Would you like to sign in Dialog
		} else if (!user.exists()) {
			try {
				user.createNewFile();
				try {
					//<Works>
					List<String> lines = Arrays.asList(userTextField.getText(), pwBox.getText());
					Files.write(Paths.get(user.getPath()), lines, utf8);
					        //  ./ indictates the parent folder to the current folder
				} catch (IOException e) {
					outputMessage.setText("Could not create user. (IO Error. See troublshooting guide.)");
				}catch(InvalidPathException invalidPath) {
					outputMessage.setText("Could not create user. (Invalid Path Error. See troublshooting guide.)");
				}
				
				outputMessage.setText("Creating user and signing in...");
				//Open Deneb with User Name
			} catch (IOException e) {
				outputMessage.setText("Could not create user. (IO Error. See troublshooting guide.)");
			}
			
		}
	}
	
	private void initGuestSIButton() {
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
                //Open with Default property
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
