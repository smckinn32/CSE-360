/************************************************************
 * Author: Aften Elliott
 * Date: 3/25/2022
 * Class: CSE360 Mon 3pm
 ************************************************************/
package application;
import  javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;

public class Main extends Application {
	@Override
	public void start(Stage stage) {

		try {

			Parent root = FXMLLoader.load(getClass().getResource("/FXML/CreateAccountScene.fxml"));
			
			Scene scene = new Scene(root);

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
				
			logoutFunction(stage); });

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	// Creates a function with the passed in parameter Stage that creates a dialogue box to make sure the user wants to exit the program.
	public void logoutFunction(Stage stage) {
		
		
		// Creates confirmation dialogue window before exiting program.
		Alert logoutAlert = new Alert(AlertType.CONFIRMATION);
		logoutAlert.setTitle("Logout");
		logoutAlert.setHeaderText("You're about to logout!");
		logoutAlert.setContentText("Are you sure you want to logout?");
		
		// Finds current stage and changes the Icon of the window
		stage = (Stage) logoutAlert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("images/ApplicationIcon.png"));
		
		// Changes icon of the pop out box.
		logoutAlert.getDialogPane().setGraphic(new ImageView("images/ErrorIcon.png"));
		
		// Exits the program if the user selects yes.
		if(logoutAlert.showAndWait().get() == ButtonType.OK) {
		Platform.exit();
		}
	}
	
	public static void main(String[] args) {

		launch(args);

	}

}
