//*****************************************************************
// Group: Monday Team 23
// Members: 
//	Abou Saleh, Laith
//	Carter, Emerson
//	Elliot, Aften
//	Rodriguez, Dominic
//  Mckinnon, Sean
// Class: CSE 360
// Time: 3:00pm Mon
// Instructor: Nicole Ang-Wanek 
// Description: This program is designed first to allow customers to place 
//	orders, and purchase food with convenience. It additionally provides
//	stores the tools to update their menu and provide benefits to their
//	loyal customers.
//*****************************************************************


package application;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application implements Initializable {
	@Override
	public void start(Stage stage) throws IOException {

		try {

			@SuppressWarnings("ConstantConditions") Parent root = FXMLLoader.load(getClass().getResource("/FXML/CreateAccountScene.fxml"));
			
			Scene scene = new Scene(root);

			// Applies CSS to the first pane.
			String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

			scene.getStylesheets().add(css);

			stage.setScene(scene);

			stage.show();
			
			// Changes icon of the application
			stage.getIcons().add(new Image("/images/ApplicationIcon.png"));
			
			// Makes it so that when clicking exit button the logoutFunction is run.
			stage.setOnCloseRequest(event -> {
				
			// 'Consumes' the event if the user presses cancel so that the program doesn't close.
			event.consume();

				try {
					logoutFunction(stage);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	// Creates a function that creates a pop-up dialogue to make sure the user wants to exit the program.
	public void logoutFunction(Stage stage) throws IOException {

		// Creates confirmation dialogue window before exiting program.
		Alert logoutAlert = new Alert(AlertType.CONFIRMATION);

		logoutAlert.setTitle("Logout");

		logoutAlert.setHeaderText("You're about to close the program!");

		logoutAlert.setContentText("Are you sure you exit?");
		
		// Finds current stage and changes the Icon of the window
		stage = (Stage) logoutAlert.getDialogPane().getScene().getWindow();

		stage.getIcons().add(new Image("images/ApplicationIcon.png"));
		
		// Changes icon of the pop out box.
		logoutAlert.getDialogPane().setGraphic(new ImageView("images/ErrorIcon.png"));
		
		// Exits the program if the user selects yes. Deletes any contents within specified files.
		if(logoutAlert.showAndWait().get() == ButtonType.OK) {
			// Clears the contents of the cart from text file
			new FileWriter("TextFiles/cartContents.csv", false).close();

			// Exits the program.
			Platform.exit();
		}
	}
	
	public static void main(String[] args) {

		launch(args);

	}
	@FXML
	Pane MainPane;
	Pane AccountCreationPane;
	Pane LoginPane;
	Pane AccountSettings;
	Pane Menu;
	Pane OrderPlaced;
	Pane SearchPreferences;
	Pane ShoppingCart;
	Pane YourOrders;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		//LoginPane = FXMLLoader.load(getClass().getResource("/FXML/LoginScreen.fxml"));


		MainPane = new StackPane();


	}
}
