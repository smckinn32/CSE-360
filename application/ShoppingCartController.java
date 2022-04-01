package application;
import javafx.event.EventHandler;
import javafx.scene.control.*;
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
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javax.imageio.IIOParam;
import java.io.*;
import java.util.ArrayList;


public class ShoppingCartController extends Controller{

    // Declarations
    private IIOParam loader;
    private Parent root;
    private Stage stage;
    private Scene scene;

    // Instantiates the cartList function.
    @FXML
    public ListView<String> cartList;
    //ObservableList<String> shoppingList = FXCollections.observableArrayList();

    // Declares an empty arrayList that will populate the shopping cart.
    ArrayList<String> menuList = new ArrayList<>(
            Arrays.asList(""));

    // Function to add specific item to the shoppingCart
    public void updateShoppingCart() {
        menuList.add("Success");
        menuList.add("My cock is hard asf rn");
        menuList.add("Daddy pls");
        menuList.add("i eat ass");
        cartList.getItems().addAll(menuList);
    }

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
    String cardName;
    String cardNumber;
    String cardDate;
    String cardCvv;
    String newFile = "GwynethPaltrowsCandle.csv";
    ArrayList<String> card = new ArrayList<String>();

     /*saves input into a text file in array format and comma format
     * also adds each part of the card information to an array list in the order
     * cardName cardnumber carddate cardcvv*/
    public void submit(ActionEvent event)
    {
        cardName = myTextField4.getText();
        cardNumber = myTextField.getText();
        cardDate = myTextField2.getText();
        cardCvv = myTextField3.getText();

        card.add(cardName);
        card.add(cardNumber);
        card.add(cardDate);
        card.add(cardCvv);
        try{
            //String text = cardNumber + ";" + cardDate + ";" + cardCvv + "\n";
            //System.out.println(cardNumber+ ";" + cardDate + ";" + cardCvv + "\n");
            FileWriter fWriter = new FileWriter(newFile, true);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            bWriter.write(String.valueOf(card) + "\n");
            bWriter.close();
                System.out.println(card + "\n");
                card.clear();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private Label myLabel;
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

