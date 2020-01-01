package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.WeatherSystem;
import view.*;
import controller.*;
import javafx.scene.Scene;

public class WeatherApplication extends Application {
	
	Stage window;
	
	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		
		// MODEL
		WeatherSystem weatherModel = new WeatherSystem("Oakville,CA");
		
		// VIEW setup
		WeatherSystemView weatherView = new WeatherSystemView(window);
		LoginPageView loginView = new LoginPageView(window);
		SignupPageView signupView = new SignupPageView(window);
		
		// CONTROLLERS setup and CONTROLLERS -> MODEL hookup
		SceneChangeController sceneController = new SceneChangeController(weatherView, loginView, signupView);
		sceneController.setStageReference(window);
		
		// MODEL -> VIEW hookup
		weatherModel.attach(weatherView);
		
		loginView.accountButton.setOnAction(sceneController);
		loginView.loginButton.setOnAction(new LoginController
				(loginView.getUsername(), loginView.getPassword(), sceneController));
		
		
		//routes to login screen if user already has an account
		signupView.accountButton.setOnAction(sceneController);
		//setting up the login controller
		signupView.signupButton.setOnAction(new LoginController
				(signupView.getUsername(), signupView.getPassword(), sceneController));
		
		//routes back to login screen from weather menu
		weatherView.goBackButton.setOnAction(sceneController);
		
		
		// SCENES SETUP
		Scene loginScene = new Scene(loginView);
		Scene signupScene = new Scene(signupView);
		Scene weatherScene = new Scene(weatherView);
		
		// ROUTING BETWEEN SCENES
		sceneController.setSceneReference(loginScene); //0
		sceneController.setSceneReference(signupScene); //1
		sceneController.setSceneReference(weatherScene); //2
		
		// STAGE
		//change this to be login screen at start, when all is set up.
		window.setScene(loginScene);
		window.setTitle("Cloudy Skies");
	    
		// LAUNCH THE GUI
		window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
