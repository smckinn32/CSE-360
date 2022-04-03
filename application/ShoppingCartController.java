/************************************************************
 * Author: Dominic Rodriguez
 * Date: 4/1/2022
 * Class: CSE360 Mon 3pm
 ************************************************************/
package application;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.math.BigInteger;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javax.imageio.IIOParam;
import java.io.*;


public class ShoppingCartController extends PipeLine {
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
    private Button myButton;
    @FXML
    private Label myLabel;
    @FXML
    private Label cardError;
    // Declarations
    private IIOParam loader;
    private Parent root;
    private Stage stage;
    private Scene scene;
    // Instantiates the cartListView so it can be used in functions.
    @FXML
    public ListView<String> cartListView;
    // Declares an empty arrayList that will populate the shopping cart.
    ArrayList<String> cartArray = new ArrayList<>(Arrays.asList());
    // Function to add specific item to the shoppingCart, takes a String as an argument.
    public void addToShoppingCart(String MenuItem) {
        cartArray.add(MenuItem);
        cartListView.getItems().addAll(cartArray);
        System.out.print(cartArray);
    }
    //declarations
    String cardName;
    String cardNumber;
    String cardDate;
    String cardCvv;
    String newFile = "paymentInfo.csv";
    BigInteger numberCheck;
    ArrayList<String> card = new ArrayList<String>();

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
                cardError.setText("Your Card number is incorrect");
                cardError.setTextFill(Color.color(1,0,0));
            } else if (cardDate.length() != 5){
                cardError.setText("Your Card date is incorrect");
                cardError.setTextFill(Color.color(1,0,0));
            } else if(cardCvv.length() != 3)
            {
                cardError.setText("Your CVV is incorrect");
                cardError.setTextFill(Color.color(1,0,0));
            }else {
                card.add(cardName);
                card.add(cardNumber);
                card.add(cardDate);
                card.add(cardCvv);
                cardError.setTextFill(Color.color(0,1,0));
                cardError.setText("Payment information saved");
                /* Writes information from text fields to file (.csv) */
                FileWriter fWriter = new FileWriter(newFile, true);
                BufferedWriter bWriter = new BufferedWriter(fWriter);
                bWriter.write(String.valueOf(card) + "\n");
                bWriter.close();
                System.out.println(card + "\n");
                card.clear();
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
    @FXML
    void removeCart(MouseEvent event) {
        int selectedItem = cartList.getSelectionModel().getSelectedIndex();
        // if selected == 0
        if (selectedItem < 1)
        {
            myLabel.setText("Nothing Selected");
        }else{
            cartList.getItems().remove(selectedItem);
            myLabel.setText("");
        }
    }
    @FXML
    public void clearCart(ActionEvent event) {

        System.out.println(menuList);
    }
}