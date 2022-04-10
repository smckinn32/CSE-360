/************************************************************
 * Author: Dominic Rodriguez
 * Date: 4/1/2022
 * Class: CSE360 Mon 3pm
 ************************************************************/
package application;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.imageio.IIOParam;
import java.io.*;
import javafx.collections.FXCollections;
import java.util.Arrays;


public class ShoppingCartController extends PipeLine {

    /* -------------------------------------------------------------------------- */
    /*                                DECLARATIONS:                               */
    /* -------------------------------------------------------------------------- */
    @FXML
    private Button loginScreenButton;
    @FXML
    private TextField cardNameField;
    @FXML
    private TextField cardNumField;
    @FXML
    private TextField cardDateField;
    @FXML
    private TextField cardCvvField;
    @FXML
    private Label cardError;
    @FXML
    private Label myLabel;

    private IIOParam loader;

    private Parent root;

    private Stage stage;

    private Scene scene;

    String cardName;
    String cardNumber;
    String cardDate;
    String cardCvv;
    // Creates an array that contains the users card information.
    ArrayList<String> card = new ArrayList<String>();
    BigInteger numberCheck;

    // Creates new files for FileIO
    public String paymentInfo = "TextFiles/paymentInfo.csv";
    public String cartContents = "TextFiles/cartContents.csv";

    // Instantiates the cartListView so that it can be used in functions.
    @FXML
    public ListView<String> cartListView;

    // Declares an observable arrayList that will populate the shopping cart.
    public ObservableList<String> cartArray = FXCollections.observableArrayList();

    /* -------------------------------------------------------------------------- */
    /*                                FUNCTIONS:                                  */
    /* -------------------------------------------------------------------------- */


    // Function to add specific item to the shoppingCart, takes a String as an argument.
    public void addToShoppingCart(String MenuItem) {
        try {
            FileWriter fWriter = new FileWriter(cartContents, true);

            BufferedWriter bWriter = new BufferedWriter(fWriter);

            String list = MenuItem.toString().replaceAll("[\\[\\]]", "");

            bWriter.write(String.valueOf(list) + "\n");

            bWriter.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        // Sets the contents of the array into the list view on the shopping cart page.
        cartListView.getItems().addAll(cartArray);

        // Refreshes the list view.
        cartListView.refresh();

        System.out.println(cartArray);
    }

    // Populates the cartArray based on contents of the text-file, then pushes those to the listview when switching to the shopping cart.
    public void updateShoppingCart() {

        // Reads teh text file and puts all of those items into the array.
        try {
            Scanner s = new Scanner(new File(cartContents));
            while (s.hasNext()) {
                cartArray.add(s.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Adds the contents of the array to the list-view.
        cartListView.getItems().addAll(cartArray);

        System.out.print(cartArray);

        // Refreshes the list view.
        cartListView.refresh();
    }

    /*saves input into a text file in array format and comma format
     * also adds each part of the card information to an array list in the order
     * cardName cardnumber carddate cardcvv*/
    public void submit(ActionEvent event) {
        cardName = cardNameField.getText();
        cardNumber = cardNumField.getText();
        cardDate = cardDateField.getText();
        cardCvv = cardCvvField.getText();
        /*bunch of conditionals to make sure user input meets card information requirements*/
        try {
            numberCheck = new BigInteger(cardNumber + cardDate + cardCvv);
            try {
                if (cardNumber.length() != 16) {
                    cardError.setText("Your card number is incorrect");
                    cardError.setTextFill(Color.color(1,0,0));
                } else if(cardDate.length() != 4)
                {
                    cardError.setText("Your card date is incorrect");
                    cardError.setTextFill(Color.color(1,0,0));
                }else if(cardCvv.length() != 3)
                {
                    cardError.setText("Your card CVV is incorrect");
                    cardError.setTextFill(Color.color(1,0,0));
                }else {
                    card.add(cardName);
                    card.add(cardNumber);
                    card.add(cardDate);
                    card.add(cardCvv);
                    cardError.setTextFill(Color.color(0,1,0));
                    cardError.setText("Payment information saved");
                    /* Writes information from text fields to file (.csv) */
                    FileWriter fWriter = new FileWriter(paymentInfo, true);
                    BufferedWriter bWriter = new BufferedWriter(fWriter);
                    bWriter.write(String.valueOf(card) + "\n");
                    bWriter.close();
                    System.out.println(card + "\n");
                    card.clear();
                    /*switches scene to order placed*/
                    Parent root = FXMLLoader.load(getClass().getResource("/FXML/OrderPlaced.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();
                    scene.getStylesheets().add(css);
                }
            } catch (Exception e)
            {
                System.out.println(e);
            }
        } catch (NumberFormatException e)
        {
            cardError.setText("Character not recognized. Numbers only please");
            cardError.setTextFill(Color.color(1,0,0));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    // Function to remove selected item from the shopping cart.
    @FXML
    void removeCart(MouseEvent event) {
        int selectedItem = cartListView.getSelectionModel().getSelectedIndex();
        // if selected == 0
        if (selectedItem < 1) {
            myLabel.setText("Nothing Selected, please select an item to remove.");
        } else {
            cartListView.getItems().remove(selectedItem);
            myLabel.setText("");
        }
    }

    // Function to clear the entire cart.
    @FXML
    public void clearCart(ActionEvent event) {

    }

    /* -------------------------------------------------------------------------- */
    /*                                TESTING:                                    */
    /* -------------------------------------------------------------------------- */
    @FXML
    private TableView<Cart> cartTableView;

    @FXML
    private TableColumn<Cart, String> menuItemType;

    @FXML
    private TableColumn<Cart, Integer> menuItemAmount;

    public final ObservableList <Cart> menuTableList = FXCollections.observableArrayList();

    // Function to add items to the shopping cart table that takes the amount of items and the type of menu items as parameters.
    public void addToCartTable(int Amount, String Type) {

        menuTableList.add(new Cart(Amount, Type));
    }

    // Function to update the cart when switching to it.
    public void testfunc() {
        //menuItemAmount.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("menuItemAmount"));
        //menuItemType.setCellValueFactory(new PropertyValueFactory<Cart, String>("menuItemType"));

        addToCartTable(20, "Value");

        cartTableView.setItems(menuTableList);

        cartTableView.refresh();

        System.out.println(menuTableList);
    }
}