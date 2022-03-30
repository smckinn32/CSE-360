/************************************************************
 * Author: Aften Elliott
 * Date: 3/25/2022
 * Class: CSE360 Mon 3pm
 ************************************************************/
package application;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class Controller implements Initializable {

	// Creates primary scene/stage
	private Stage stage;
	private Scene scene;
	private Parent root;
 
	// Creates FXML fields to be used in the password visibility function.
	@FXML
	private PasswordField passwordHidden;

	@FXML
	private TextField passwordText;

	@FXML
	private CheckBox checkBox;
	
	// Creates FXML buttons and pane to be able to create exit confirmation button.
	@FXML
	private Button exitButton;

	@FXML
	private AnchorPane scenePane;
	
	// Creates FXML text-field for the search button
	@FXML
	private TextField searchButton;
	
	// Creates FXML List-view to act as the search-box in the format of strings.
	@FXML
	private ListView<String> searchBox;
	
	// Creates the FXML List-view for the shopping cart functionality.
	@FXML
	public ListView<String> cartList;
	
	// Creates String Array used for Search bar
	ArrayList<String> menuList = new ArrayList<>(
			Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Rho"));
	
	// Creates String Array used for Shopping Cart
	public ObservableList<String> cartArray = FXCollections.observableArrayList("Test - !", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Rho");

	// MULTIPLE CONTROLLER FUNCTIONALITY DEMONSTRATION FUNCTION:
	public void addToShoppingCart(ActionEvent event) throws IOException {

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

		// Runs the updateShoppingCart function present in the seperate controller.
		ShoppingCartController.updateShoppingCart();
	}


	public void changetoShoppingCartTEST(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ShoppingCart.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		root = loader.load();

		ShoppingCartController ShoppingCartController = loader.getController();

		scene = new Scene(root);

		stage.setScene(scene);

		stage.show();

		// Adds CSS styling to new scene
		String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
		scene.getStylesheets().add(css);

		// Updates shopping cart upon switching to the shopping cart scene.
		//updateShoppingCart();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//cartList.setItems(cartArray);
	}

	// Function to change visibility of password check-box.
	@FXML
	void changeVisibility(ActionEvent event) {
		if (checkBox.isSelected()) {
			passwordText.setText(passwordHidden.getText());
			passwordText.setVisible(true);
			passwordHidden.setVisible(false);
			return;
		}
		passwordHidden.setText(passwordText.getText());
		passwordHidden.setVisible(true);
		passwordText.setVisible(false);
	}

// Function used by button to switch to Login Screen From the Create Account Screen
	public void changetoLoginScreen(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/LoginScreen.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		scene = new Scene(root);

		stage.setScene(scene);

		stage.show();

		// Adds CSS styling to new scene
		String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
		scene.getStylesheets().add(css);
	}

// Function used by button to switch to the Main Menu
	public void changetoMenu(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Menu.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		scene = new Scene(root);

		stage.setScene(scene);

		stage.show();

		// Adds CSS styling to new scene
		String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
		scene.getStylesheets().add(css);
	}

	// Function used to switch scene to the main account settings page.
	public void changetoAccountSettings(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/AccountSettings.fxml"));
		
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		scene = new Scene(root);

		stage.setScene(scene);

		stage.show();

		// Adds CSS styling to new scene
		String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
		scene.getStylesheets().add(css);
	}
	
	// Function used to switch to the shopping cart page.
	public void changetoShoppingCart(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/ShoppingCart.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		scene = new Scene(root);

		stage.setScene(scene);

		stage.show();

		// Adds CSS styling to new scene
		String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
		scene.getStylesheets().add(css);
		
		// Updates shopping cart upon switching to the shopping cart scene.
		//updateShoppingCart();
	}

	// Function to change to your order section under account settings.
	public void changetoYourOrders(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/YourOrders.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		scene = new Scene(root);

		stage.setScene(scene);

		stage.show();

		// Adds CSS styling to new scene
		String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
		scene.getStylesheets().add(css);
	}

	// Function to switch to search preferences under account settings.
	public void changetoSearchPreferences(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/SearchPreferences.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		scene = new Scene(root);

		stage.setScene(scene);

		stage.show();

		// Adds CSS styling to new scene
		String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
		scene.getStylesheets().add(css);
	}

	// Function to change to order placed scene
	public void changetoOrderPlaced(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/OrderPlaced.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		scene = new Scene(root);

		stage.setScene(scene);

		stage.show();

		// Adds CSS styling to new scene
		String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
		scene.getStylesheets().add(css);
	}

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
			// Exits the program
			Platform.exit();
		}
	}

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

	// Checks if the currently selected search item matches the String, if it does it moves to that given scene.
	public void searchFunction(MouseEvent event) throws IOException {

		// Creates a string that holds the contents of the currently selected item from the pane view.
		String selected = searchBox.getSelectionModel().getSelectedItem();

		if (selected == "Alpha") {
			Parent root = FXMLLoader.load(getClass().getResource("/FXML/ItemPlaceholder.fxml"));

			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

			scene = new Scene(root);

			stage.setScene(scene);

			stage.show();

			String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
			
			scene.getStylesheets().add(css);
			
		} else if (selected == "Beta") {
			Parent root = FXMLLoader.load(getClass().getResource("/FXML/CreateAccountScene.fxml"));

			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

			scene = new Scene(root);

			stage.setScene(scene);

			stage.show();

			String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
			
			scene.getStylesheets().add(css);
		}
	}
}
