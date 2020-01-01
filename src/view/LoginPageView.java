package view;

import controller.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPageView extends FlowPane {

	private Stage stage;
	public Button loginButton = new Button("Login");
	public Button accountButton = new Button("Create an account");
	TextField username = new TextField();
	PasswordField password = new PasswordField();
	
	public LoginPageView(Stage stage) {
		this.stage = stage;
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(40, 10, 40, 10));
		this.setStyle("-fx-background-color:"
		+ "linear-gradient(from 25% 25% to 100% 100%, rgb(169, 169, 252), rgb(177, 249, 254));"
		+ " -fx-border-color:black;");
		
		VBox loginBox = new VBox(15);
		
		username.setPrefColumnCount(17);
		username.setMinSize(30,  30);
		username.setPromptText("enter your username");
		username.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background,-30%); }");
		
		password.setPrefColumnCount(17);
		password.setMinSize(30,  30);
		password.setPromptText("enter your password");
		password.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background,-30%); }");
		
		HBox buttonsBox = new HBox(10);
		
		loginButton.setMinSize(60, 30);
		
		accountButton.setMinHeight(30);
		
		buttonsBox.getChildren().addAll(loginButton, accountButton);
		buttonsBox.setAlignment(Pos.CENTER);
		
		//setting up the login controller
		
		//routes to register screen if user does not have an account
		
		//setting up enter key to work for logging in
		username.setOnKeyPressed(new EnterKeypressHandler(loginButton));
		password.setOnKeyPressed(new EnterKeypressHandler(loginButton));
		
		loginBox.getChildren().addAll(username, password, buttonsBox);
		
		this.getChildren().addAll(loginBox);
	}
	
	public TextField getUsername() {
		return this.username;
	}
	
	public TextField getPassword() {
		return this.password;
	}

}
