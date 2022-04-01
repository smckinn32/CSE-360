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
import javafx.event.Event;
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
import javafx.scene.control.Control;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class Controller implements Initializable{

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
	
	public void updateShoppingCart() {
		
	}
	
	
	public void addToShoppingCart(ActionEvent event) {
		cartList.getItems().add("Test");
		menuList.add("Test");
		cartList.getItems().addAll(menuList);

		//controller.setData(cartArray);
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

	
	//Position in array should match the object ID and the fxml page to load for all pages
	//Both fxmlscene and fxmlbutton should be the exact same size array
	private static String[] fxmlscene = { "/FXML/AccountSettings.fxml", "/FXML/CreateAccountScene.fxml", "/FXML/ItemPlaceholder.fxml",  "/FXML/LoginScreen.fxml", "/FXML/Menu.fxml", 
											"/FXML/Menu.fxml", "/FXML/OrderPlaced.fxml", "/FXML/SearchPreferences.fxml", "/FXML/ShoppingCart.fxml", "/FXML/YourOrders.fxml", 
											 /*Default to login screen if error*/"/FXML/LoginScreen.fxml"  };
	private static String[] fxmlbutton = {"settingsButton", "createAccountButton", "searchBox", "SignIn", "homeButton", "Login", "orderPlacedButton", "searchPreferencesButton", 
											"shoppingCartButton", "yourOrdersButton",  /*Default to login screen if error*/"" };
	private static int totalID = fxmlscene.length;

	
	/** This class will change the scene based on a list of predefined scenes listed
	 * 
	 * @param e The event & object that was interacted with
	 * @throws IOException unhandled errors
	 */
	public void changeScene(Event e) throws IOException{
			Parent root = null;
			Control things = (Control) e.getSource();
			String tempID = things.getId();
			
			//tempID = tempButton.getId();
			int id = 0;
			while(tempID.compareTo(fxmlbutton[id]) != 0 && id < totalID-1) {
				id++;
			}
			
			
			//Find the page ID to go to, based on the button name
			if(tempID.compareTo("searchBox") == 0)
			{
				String temp = searchBox.getSelectionModel().getSelectedItem();
				root = FXMLLoader.load(getClass().getResource("/FXML/Item" + temp + ".fxml"));
			}
			else
				root = FXMLLoader.load(getClass().getResource(fxmlscene[id]));

			
			//Set & show scene
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

			scene = new Scene(root);

			stage.setScene(scene);

			stage.show();

			String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
			
			scene.getStylesheets().add(css);
	}
}
