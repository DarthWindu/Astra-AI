package alphaComponents;

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
	
	GridPane grid;
	Scene scene;
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Welcome to Deneb!");
		
		initGrid();
		
		
		primaryStage.show();
	}
	
	
	private void initSignInButton() {
		Button btnSignIn = new Button("Sign in");
		HBox hbBtnSignIn = new HBox(10);
		hbBtnSignIn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtnSignIn.getChildren().add(btnSignIn);
		grid.add(hbBtnSignIn, 1, 4);
		
		final Text signInActiontarget = new Text();
        grid.add(signInActiontarget, 1, 6);
        
        btnSignIn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
                signInActiontarget.setFill(Color.FIREBRICK);
                signInActiontarget.setText("Sign in button pressed");
            }
        });
	}
	
	private void setScene (Stage primaryStage) {	
		initSignInButton();
		
		Text sceneTitle = new Text("Welcome! Please login.");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(sceneTitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);
		
		
		scene = new Scene(grid, 300, 275);
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
