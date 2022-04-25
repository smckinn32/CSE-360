/************************************************************
 * Author: Aften Elliott, Emerson Carter.
 * Date: 3/25/2022
 * Class: CSE360 Mon 3pm
 ************************************************************/
package application;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import file.ButtonFXML;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import profiles.Profile;
import profiles.UserHolder;
import javafx.scene.control.TextField;

public class PipeLine extends Main {

	/* -------------------------------------------------------------------------- */
	/*                                DECLARATIONS:                               */
	/* -------------------------------------------------------------------------- */

	// Creates the primary stage, scene, and root.
	public Stage stage;
	public Scene scene;
	public Parent root;

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
	public TextField searchButton;

	// Creates FXML List-view to act as the search-box in the format of strings.
	@FXML
	public ListView<String> searchBox;

	// Creates node used in scene switching
	@FXML
	private Node MainNode;

	// Textfield for quanity of items
	@FXML
	public TextField QuantityField;

	// Label that shows if there's no quantity selected.
	@FXML
	public Label quantityError;

	@FXML
	public URL location;

	/* ------------------------------ Menu Array List: ------------------------------ */
	ArrayList <String> menuList = new ArrayList<>(Arrays.asList());

	/* ------------------------------ Array List for Search Box: ------------------------------ */
	ArrayList <String> searchMenuArrayList = new ArrayList<>(Arrays.asList());
	
	/* ------------------------------ FXML Scenes ------------------------------ */
	private static ArrayList<String> fxmlscene = ButtonFXML.getDirectoryAsResource("FXML");	//If fxmlbutton gets new buttons/updated - make potential controller changes in changeScene OR ButtonFXML
	private static int totalID = fxmlscene.size();
	private ArrayList<String> menuscene = ButtonFXML.getDirectoryAsResource("MENU");
	private int totalMenuID = menuscene.size();

	/* ------------------------------------------------------------------------- */
	/*                                SCENE CHANGE FUNCTION:                     */
	/* ------------------------------------------------------------------------- */

	/** This class will change the scene based on a list of predefined scenes in a String[] format
	 * 
	 * @param e The event & object that was interacted with
	 * @throws IOException with un-handled errors
	 */
	public void changeScene(Event e) throws IOException {
		FXMLLoader loader = null;
		Parent root = null;
		Control control = (Control) e.getSource();
		Control updater = null;
		String tempID = control.getId();
		int id = ButtonFXML.linkButtonToFXML(tempID);

		//Set the loader
		//Find the page ID to go to, based on the button name
		Profile tempUser = UserHolder.getUserInstance().getUser();
		String temp = null;
		if (tempID.compareTo("searchBox") == 0) {

			//Gets the item selected from the search box
			temp = searchBox.getSelectionModel().getSelectedItem();

			//loader = new FXMLLoader(getClass().getResource("/FXML/ItemPlaceholder.fxml"));

			loader = new FXMLLoader(getClass().getResource("/MENU/" + temp + ".fxml"));

			// TODO: Need to create a way to be able to create object of a controller at runtime, take the name of the pressed item in the searchBox and assign that to a class object somehow?

			// TODO: This function is not being called for some reason?
			updateSearchBox();

		} else if (tempID.compareTo("Login") == 0 && tempUser.isAdmin()) {
			loader = new FXMLLoader(getClass().getResource("/FXML/AdminChangeMenu.fxml"));
		} else
			loader = new FXMLLoader(getClass().getResource(fxmlscene.get(id)));

		System.out.println("Loading: " + fxmlscene.get(id));

		//Set & show scene
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

		root = loader.load();

		//Call secondary controllers functions
		switch (tempID) {
			case "Login", "homeButton", "changeBackToMenu1", "changeBackToMenu2":
				if (!tempUser.isAdmin()) {
					MenuController MenuController = loader.getController();
					MenuController.updateMenu();
					MenuController.updateSearchBox();
				}
				break;
			case "shoppingCartButton":
				ShoppingCartController ShoppingCartController = loader.getController();
				ShoppingCartController.updateShoppingCart();
				ShoppingCartController.updateSearchBox();
				break;
			case "settingsButton", "YourAccountButton":
				AccountSettingsController AccountSettingsController = loader.getController();
				AccountSettingsController.updateSearchBox();
				break;
			case "YourOrdersButton":
				OrdersController OrdersController = loader.getController();
				OrdersController.updateSearchBox();
				break;
			case "SearchPreferencesButton":
				SearchPreferencesController SearchPreferencesController = loader.getController();
				SearchPreferencesController.updateSearchBox();
				SearchPreferencesController.updateSearchPreferences();
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

	// Function checks to see if quantity field has a value in it, if it does it then transitions to the shopping cart.
	public void quantityCheck(ActionEvent event) throws IOException {
		// Checks to make sure the quantity field isn't empty.
		if (QuantityField.getText() == null || QuantityField.getText().trim().isEmpty()) {
			quantityError.setText("You haven't entered the quantity!");
			quantityError.setTextFill(Color.color(1,0,0));
		}
		// Switches to the shopping cart and adds both the item and quantity to the table view.
		else {

			Integer Quantity = Integer.valueOf(QuantityField.getText());

			// Gets FX:ID of the button that is pressed.
			Button btn = (Button) event.getSource();
			String id = btn.getId();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ShoppingCart.fxml"));

			root = loader.load();

			// Creates ShoppingCartController obj in order to be able to communicate between controllers and pass data between them.
			ShoppingCartController ShoppingCartController = loader.getController();


			// Adds the FX:ID of the button pressed as a parameter into the shopping cart function, adds to the shopping cart and updates it.
			ShoppingCartController.addToShoppingCart(id, Quantity);

			quantityError.setText("Item Successfully added to Cart!");
			quantityError.setTextFill(Color.FORESTGREEN);
		}
	}

	// Ensures that the cart text field is limited to valid inputs only. Can only add up to 9 items of the same type in the cart.
	@FXML
	public void limitTextFields(KeyEvent event) {
		int maxLength = 3;
		TextField tf = (TextField) event.getSource();

		if (tf.getText().length() > maxLength) {
			tf.deletePreviousChar();
		}
		else if(!tf.getText().matches("[1-9]")) {
			tf.deletePreviousChar();
		}
	}

	// Function to change visibility of a password check-box.
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

	// TODO: TEMPORARY FUNCTION USED UNTIL MAIN CHANGESCENE WORKS WITH THE SEARCHBOX! This is hard coded so it wont work with the admin functionalities...
	public void changeSearchBox(MouseEvent event) throws IOException {

		//Gets the item selected from the search box
		String temp = searchBox.getSelectionModel().getSelectedItem();

		switch (temp) {
			case "BuffaloWings":
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/MENU/BuffaloWings.fxml"));

				root = loader.load();

				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

				scene = new Scene(root);

				stage.setScene(scene);

				stage.show();

				String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

				scene.getStylesheets().add(css);

				// Updates the searchbox.
				BuffaloWingsController BuffaloWingsController = loader.getController();
				BuffaloWingsController.updateSearchBox();

				break;
			case "ChickenMarsala":
				loader = new FXMLLoader(getClass().getResource("/MENU/ChickenMarsala.fxml"));

				root = loader.load();

				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

				scene = new Scene(root);

				stage.setScene(scene);

				stage.show();

				css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

				scene.getStylesheets().add(css);

				// Updates the searchbox.
				ChickenMarsalaController ChickenMarsalaController = loader.getController();
				ChickenMarsalaController.updateSearchBox();

				break;
			case "FrenchFries":
				loader = new FXMLLoader(getClass().getResource("/MENU/FrenchFries.fxml"));

				root = loader.load();

				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

				scene = new Scene(root);

				stage.setScene(scene);

				stage.show();

				css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

				scene.getStylesheets().add(css);

				// Updates the searchbox.
				FrenchFriesController FrenchFriesController = loader.getController();
				FrenchFriesController.updateSearchBox();

				break;
			case "Lasagna":
				loader = new FXMLLoader(getClass().getResource("/MENU/Lasagna.fxml"));

				root = loader.load();

				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

				scene = new Scene(root);

				stage.setScene(scene);

				stage.show();

				css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

				scene.getStylesheets().add(css);

				// Updates the searchbox.
				LasagnaController LasagnaController = loader.getController();
				LasagnaController.updateSearchBox();

				break;
			case "Spaghetti":
				loader = new FXMLLoader(getClass().getResource("/MENU/Spaghetti.fxml"));

				root = loader.load();

				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

				scene = new Scene(root);

				stage.setScene(scene);

				stage.show();

				css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

				scene.getStylesheets().add(css);

				// Updates the searchbox.
				SpaghettiController SpaghettiController = loader.getController();
				SpaghettiController.updateSearchBox();

				break;
		}

	}

	// Function to update the search text file.
	public void refreshSearchFile() {
		// Creates a copy of the menu to be used in the search bar functions.
		File originalMenuFile = new File("MENU/Menu.txt");
		File searchMenuFile = new File("TextFiles/SearchMenu.txt");

		try {
			Files.copy(originalMenuFile.toPath(),searchMenuFile.toPath());
		}
		catch (Exception e) {
		}
	}

	public void copySearchFile() {
		// Creates a copy of the menu to be used in the search bar functions.
		File originalMenuFile = new File("MENU/Menu.txt");
		File searchMenuFile = new File("TextFiles/SearchMenu.txt");

		try {
			Files.copy(originalMenuFile.toPath(),searchMenuFile.toPath());
		}
		catch (Exception e) {

		}
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

			// Clears the contents of the cart when logging out. Also deletes the search menu text file as well.
			try {
				new FileWriter("TextFiles/cartContents.csv", false).close();

				File SearchMenuObj = new File("TextFiles/SearchMenu.txt");
				SearchMenuObj.delete();
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
		searchBox.getItems().addAll(searchArray(searchButton.getText(), searchMenuArrayList));

	}

	// Function to search the menu array list
	private List<String> searchArray(String searchWords, List<String> listOfStrings) {

		List<String> searchMenuArray = Arrays.asList(searchWords.trim().split(" "));

		return listOfStrings.stream().filter(input -> {
			return searchMenuArray.stream().allMatch(word -> input.toLowerCase().contains(word.toLowerCase()));
		}).collect(Collectors.toList());
	}

	// Changes the list-view visibility if user enters any text to the text field. Adds menu items to the list view as well.
	public void searchVisibility() {

		if (searchButton.getText().trim().equals("")) {
			searchBox.setVisible(false);
		} else {
			searchBox.setVisible(true);
			System.out.println(searchMenuArrayList);

		}
	}

	// Function to update the search box when switching between scenes.
	public void updateSearchBox() {
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader("TextFiles/SearchMenu.txt"));

			String line;

			while ((line = br.readLine()) != null) {
				String fields = line.split(" ")[0];

				searchMenuArrayList.add(fields);
			}

			br.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}

		// Adds the contents of the arraylist into the list view
		searchBox.getItems().addAll(searchMenuArrayList);

		// Refreshes the list view.
		searchBox.refresh();
	}

}