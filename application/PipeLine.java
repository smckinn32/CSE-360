/************************************************************
 * Author: Aften Elliott
 * Date: 3/25/2022
 * Class: CSE360 Mon 3pm
 ************************************************************/
package application;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
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
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class PipeLine {

    /* -------------------------------------------------------------------------- */
    /*                                DECLARATIONS:                               */
    /* -------------------------------------------------------------------------- */

    // Creates the primary stage, scene, and root.
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

    // Creates node used in scene switching
    @FXML
    private Node MainNode;

    /* ------------------------------ Menu Array List: ------------------------------ */
    ArrayList<String> menuList = new ArrayList<>(Arrays.asList("French Fries", "Buffalo Wings", "Spaghetti", "Lasagna", "Chicken Masala"));

    /* -------------------------------------------------------------------------- */
    /*                                SCENE CHANGE FUNCTIONS:                     */
    /* -------------------------------------------------------------------------- */

    // Function to switch scene depending on the FX:ID of the button pressed.
    public void changeScene(ActionEvent event) throws IOException {

        // Grabs the source, that being the selected button, and then puts it into a temporary button/
        Button FXID = (Button) event.getSource();

        // Switches to the login Screen Scene if the FXID matches the case.
        switch (FXID.getId()) {
            case "SignIn":
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LoginScreen.fxml"));

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                root = loader.load();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                // Adds CSS styling to new scene
                String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
                scene.getStylesheets().add(css);

                // Breaks Switch statement.
                break;
            // Switches to the Menu Screen if the FX:ID matches
            case "Login", "homeButton":

                loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                root = loader.load();

                // Creates MenuController so that we can activate functions from it.
                MenuController MenuController = loader.getController();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                // Adds CSS styling to new scene
                css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
                scene.getStylesheets().add(css);

                // Runs the updateMenuListView function present in the seperate controller.
                MenuController.updateMenuListView();

                // Breaks switch statement.
                break;
            case "shoppingCartButton":

                loader = new FXMLLoader(getClass().getResource("/FXML/ShoppingCart.fxml"));

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                root = loader.load();

                // Creates an object of the ShoppingCartController to be able to run functions from the pipeline.
                ShoppingCartController ShoppingCartController = loader.getController();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                // Adds CSS styling to new scene
                css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
                scene.getStylesheets().add(css);

                // Updates Shopping Cart when switching to the shopping cart scene.
                ShoppingCartController.updateShoppingCart();

                // Breaks switch statement.
                break;
            case "settingsButton", "YourAccountButton":
                loader = new FXMLLoader(getClass().getResource("/FXML/AccountSettings.fxml"));

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                root = loader.load();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                // Adds CSS styling to new scene
                css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
                scene.getStylesheets().add(css);

                // Breaks switch statement.
                break;
            case "YourOrdersButton":
                loader = new FXMLLoader(getClass().getResource("/FXML/YourOrders.fxml"));

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                root = loader.load();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                // Adds CSS styling to new scene
                css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
                scene.getStylesheets().add(css);

                // Breaks switch statement.
                break;
            case "SearchPreferencesButton":
                loader = new FXMLLoader(getClass().getResource("/FXML/SearchPreferences.fxml"));

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                root = loader.load();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                // Adds CSS styling to new scene
                css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
                scene.getStylesheets().add(css);

                // Breaks switch statement.
                break;

        }
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

    // Checks if the currently selected search item matches the String, if it does it moves to that given scene.
    public void searchFunction(MouseEvent event) throws IOException {

        // Creates a string that holds the contents of the currently selected item from the pane view.
        String selected = searchBox.getSelectionModel().getSelectedItem();

        if (selected == "Lasagna") {
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