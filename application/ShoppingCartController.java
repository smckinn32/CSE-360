/************************************************************
 * Author: Dominic Rodriguez
 * Date: 4/1/2022
 * Class: CSE360 Mon 3pm
 ************************************************************/
package application;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
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
    private TextField myTextField4;
    @FXML
    private TextField myTextField;
    @FXML
    private TextField myTextField2;
    @FXML
    private TextField myTextField3;
    @FXML
    private Button myButton;
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

    // Creates new files for FileIO
    public String paymentInfo = "TextFiles/paymentInfo.csv";
    public String cartContents = "TextFiles/cartContents.csv";

    // Instantiates the cartListView so that it can be used in functions.
    @FXML
    public ListView <String> cartListView;

    // Creates an array that contains the users card information.
    ArrayList<String> card = new ArrayList<String>();

    // Declares an observable arrayList that will populate the shopping cart.
    public ObservableList <String> cartArray = FXCollections.observableArrayList();

    /* -------------------------------------------------------------------------- */
    /*                                FUNCTIONS:                                  */
    /* -------------------------------------------------------------------------- */


    // Function to add specific item to the shoppingCart, takes a String as an argument.
    public void addToShoppingCart(String MenuItem) {
        try {
            FileWriter fWriter = new FileWriter(cartContents, true);

            BufferedWriter bWriter = new BufferedWriter(fWriter);

            String list = MenuItem.toString().replaceAll("[\\[\\]]","");

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
            while (s.hasNext()){
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
        cardName = myTextField4.getText();
        cardNumber = myTextField.getText();
        cardDate = myTextField2.getText();
        cardCvv = myTextField3.getText();

        card.add(cardName);
        card.add(cardNumber);
        card.add(cardDate);
        card.add(cardCvv);
        try {
            //String text = cardNumber + ";" + cardDate + ";" + cardCvv + "\n";
            //System.out.println(cardNumber+ ";" + cardDate + ";" + cardCvv + "\n");
            FileWriter fWriter = new FileWriter(paymentInfo, true);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            bWriter.write(String.valueOf(card) + "\n");
            bWriter.close();
            System.out.println(card + "\n");
            card.clear();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Function to remove selected item from the shopping cart.
    @FXML
    void removeCart(MouseEvent event) {
        int selectedItem = cartListView.getSelectionModel().getSelectedIndex();
        // if selected == 0
        if (selectedItem < 1)
        {
            myLabel.setText("Nothing Selected, please select an item to remove.");
        }else{
            cartListView.getItems().remove(selectedItem);
            myLabel.setText("");
        }
    }

    // Function to clear the entire cart.
    @FXML
    public void clearCart(ActionEvent event) {

        System.out.println(menuList);
    }
}