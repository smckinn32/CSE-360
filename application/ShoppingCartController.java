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
import javafx.scene.control.Label;
import javax.imageio.IIOParam;
import java.io.*;


public class ShoppingCartController extends PipeLine {
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
    String cardName;
    String cardNumber;
    String cardDate;
    String cardCvv;
    String newFile = "paymentInfo.csv";
    ArrayList<String> card = new ArrayList<String>();

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
            FileWriter fWriter = new FileWriter(newFile, true);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            bWriter.write(String.valueOf(card) + "\n");
            bWriter.close();
            System.out.println(card + "\n");
            card.clear();
        } catch (Exception e) {
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