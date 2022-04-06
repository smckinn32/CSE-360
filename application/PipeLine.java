/************************************************************
 * Author: Aften Elliott
 * Date: 3/25/2022
 * Class: CSE360 Mon 3pm
 ************************************************************/
package application;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class PipeLine extends Main {

	/* -------------------------------------------------------------------------- */
	/*                                DECLARATIONS:                               */
	/* -------------------------------------------------------------------------- */

	// Creates the primary stage, scene, and root.
	private Stage stage;
	private Scene scene;
	private Parent root;

	// Creates FXML fields to be used in the password visibility function.
	@FXML
	private PasswordField password;

	@FXML
	private TextField passwordText;

	@FXML
	private CheckBox checkBox;

	// Creates FXML buttons and pane to be able to create exit confirmation button.
	@FXML
	private Button exitButton;

	// Creates FXML text-field for the search button
	@FXML
	private TextField searchButton;

	// Creates FXML List-view to act as the search-box in the format of strings.
	@FXML
	private ListView<String> searchBox;

	// Creates node used in scene switching
	@FXML
	private Node MainNode;

	/* ------------------------------ Menu Array List: ------------------------------ */
	ArrayList <String> menuList = new ArrayList<>(Arrays.asList("French Fries", "Buffalo Wings", "Spaghetti", "Lasagna", "Chicken Masala"));

	/* -------------------------------------------------------------------------- */
	/*                                SCENE CHANGE FUNCTIONS:                     */
	/* -------------------------------------------------------------------------- */

	//To be implemented and stored elsewhere - temporary accommodations for initial implementation
	//Position in array should match the object ID and the fxml page to load for all pages
	//Both fxmlscene and fxmlbutton should be the exact same size array
	private static String[] fxmlscene = { "/FXML/AccountSettings.fxml", "/FXML/AccountSettings.fxml", "/FXML/CreateAccountScene.fxml", "/FXML/ItemPlaceholder.fxml",  "/FXML/LoginScreen.fxml", "/FXML/Menu.fxml", 
											"/FXML/Menu.fxml", "/FXML/OrderPlaced.fxml", "/FXML/SearchPreferences.fxml", "/FXML/ShoppingCart.fxml", "/FXML/YourOrders.fxml", 
											 /*Default to login screen if error*/"/FXML/LoginScreen.fxml"  };
	//If fxmlbutton gets new buttons/updated - make potential controller changes in changeScene
	private static String[] fxmlbutton = {"settingsButton", "YourAccountButton", "createAccountButton", "searchBox", "SignIn", "homeButton", "Login", "orderPlacedButton", "SearchPreferencesButton",
											"shoppingCartButton", "YourOrdersButton",  /*Default to login screen if error*/"" };
	private static int totalID = fxmlscene.length;

	
	/** This class will change the scene based on a list of predefined scenes in a String[] format
	 * 
	 * @param e The event & object that was interacted with
	 * @throws IOException with un-handled errors
	 */
	public void changeScene(Event e) throws IOException{
			FXMLLoader loader = null;
			Parent root = null;
			Control control = (Control) e.getSource();
			Control updater = null;
			String tempID = control.getId();
			
			//tempID = tempButton.getId();
			int id = 0;
			while(tempID.compareTo(fxmlbutton[id]) != 0 && id < totalID-1) {
				id++;
			}
			
			
			//Set the loader
			//Find the page ID to go to, based on the button name
			if(fxmlbutton[id].compareTo("searchBox") == 0) {
				
				//Gets the item selected from the search box
				String temp = searchBox.getSelectionModel().getSelectedItem();
				loader = new FXMLLoader(getClass().getResource("/FXML/ItemPlaceholder.fxml"));
				//loader = new FXMLLoader(getClass().getResource("/FXML/Item" + temp + ".fxml"));
			}
			else
				loader = new FXMLLoader(getClass().getResource(fxmlscene[id]));
			

			//Set & show scene
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			
			root = loader.load();
			
			
			//Call secondary controllers functions
			switch(fxmlbutton[id]) {
			case "Login", "homeButton" :
				MenuController MenuController = loader.getController();
				MenuController.updateMenuListView();
				break;
			case "shoppingCartButton" :
				ShoppingCartController ShoppingCartController = loader.getController();
				ShoppingCartController.updateShoppingCart();
				break;
			}
			
			
			scene = new Scene(root);

			stage.setScene(scene);

			stage.show();

			String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
			scene.getStylesheets().add(css);
	}

	/* ------------------------------------------------------------------------------------------------ */
	/*                                FUNCTIONS USING MULTIPLE CONTROLLERS:                             */
	/* ------------------------------------------------------------------------------------------------ */

	// MULTIPLE CONTROLLER FUNCTIONALITY DEMONSTRATION FUNCTION:
	public void addToShoppingCartButton(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ShoppingCart.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		root = loader.load();

		// Creates ShoppingCartController obj in order to be able to communicate between controllers and pass data between them.
		ShoppingCartController ShoppingCartController = loader.getController();

		scene = new Scene(root);

		stage.setScene(scene);

		stage.show();

		// Adds CSS styling to new scene
		String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
		scene.getStylesheets().add(css);

		// Runs the addToShoppingCart function present in the ShoppingCartcontroller to add a specific item to the shopping cart.
		ShoppingCartController.addToShoppingCart("Test");
		ShoppingCartController.updateShoppingCart();
	}

	/* -------------------------------------------------------------------------- */
	/*                                LOGOUT FUNCTION                             */
	/* -------------------------------------------------------------------------- */

	// Function designed to ensure user wants to close the program.
	public void logoutFunction(ActionEvent event) {

		// Creates confirmation dialogue window before exiting program.
		Alert logoutAlert = new Alert(AlertType.CONFIRMATION);

		// Finds current stage and changes the Icon
		stage = (Stage) logoutAlert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("images/ApplicationIcon.png"));

		// Changes main icon of pop out window
		logoutAlert.getDialogPane().setGraphic(new ImageView("images/ErrorIcon.png"));
		// Sets the title of the dialogue pop out
		logoutAlert.setTitle("Logout");

		// Creates confirmation dialogue warning the user they're about to logout.
		logoutAlert.setHeaderText("You're about to logout!");

		// Asks the user if they want to logout
		logoutAlert.setContentText("Are you sure you want to logout?");

		// If the user presses the confirmation button the program closes. If not the program continues normally.
		if (logoutAlert.showAndWait().get() == ButtonType.OK) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LoginScreen.fxml"));

			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

			try {
				root = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}

			scene = new Scene(root);

			stage.setScene(scene);

			stage.show();

			// Adds CSS styling to new scene
			String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
			scene.getStylesheets().add(css);

			// Clears the contents of the cart when logging out.
			try {
				new FileWriter("TextFiles/cartContents.csv", false).close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/* -------------------------------------------------------------------------- */
	/*                                SEARCH FUNCTIONS:                           */
	/* -------------------------------------------------------------------------- */

	// When the search button is pressed, list-view is cleared and adds result of the new search appear.
	@FXML
	void search(ActionEvent event) {
		// Clears populated list view.
		searchBox.getItems().clear();

		// Runs search function and populates list view with the results from that search.
		searchBox.getItems().addAll(searchArray(searchButton.getText(), menuList));
	}

	// Function to search the menu array list
	private List<String> searchArray(String searchWords, List<String> listOfStrings) {

		List<String> searchMenuArray = Arrays.asList(searchWords.trim().split(" "));

		return listOfStrings.stream().filter(input -> {
			return searchMenuArray.stream().allMatch(word -> input.toLowerCase().contains(word.toLowerCase()));
		}).collect(Collectors.toList());
	}

	// Changes the list-view visibility if user enters any text to the text field.
	public void searchVisibility() {
		if (searchButton.getText().trim().equals("")) {
			searchBox.setVisible(false);
		} else {
			searchBox.setVisible(true);
		}
	}

	// Function to change visibility of password check-box.
	@FXML
	void changeVisibility(ActionEvent event) {
		// Grabs the source, that being the selected button, and then puts it into a temporary button/
		if (checkBox.isSelected()) {
			passwordText.setText(password.getText());
			passwordText.setVisible(true);
			password.setVisible(false);
			return;
		}
		password.setText(passwordText.getText());
		password.setVisible(true);
		passwordText.setVisible(false);
	}

	@FXML
	Pane AccountCreationPane2;
	public void fuckmyass() {
		try {
			AccountCreationPane2 = FXMLLoader.load(getClass().getResource("/FXML/AccountSettings.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void changeTest(ActionEvent event) {
		Button btn = (Button) event.getSource();
		String id = btn.getId();

		switch (id) {
			case "homeButton":
				//MainPane.getChildren().clear();
				//MainPane.getChildren().add(AccountCreationPane);

				String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

				scene.getStylesheets().add(css);
				break;
			case "shoppingCartButton":

				break;
			case "settingsButton":


				break;
			case "YourAccountButton":

				break;
			case "YourOrdersButton":

				break;
			case "SearchPreferencesButton":

				break;

			case "Login":

				break;

			case "SignIn":

				break;
		}

	}
}