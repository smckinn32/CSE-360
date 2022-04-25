/************************************************************
 * Author: Dominic Rodriguez
 * Date: 4/1/2022
 * Class: CSE360 Mon 3pm
 ************************************************************/
package application;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.imageio.IIOParam;
import java.io.*;
import javafx.collections.FXCollections;


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
    /*                                OUTDATED:                                   */
    /* -------------------------------------------------------------------------- */


/*
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

        // Reads the text file and puts all of those items into the array.
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

    */
/*saves input into a text file in array format and comma format
     * also adds each part of the card information to an array list in the order
     * cardName cardnumber carddate cardcvv*//*




    public void submit(ActionEvent event) {
        cardName = cardNameField.getText();
        cardNumber = cardNumField.getText();
        cardDate = cardDateField.getText();
        cardCvv = cardCvvField.getText();
        */
/*bunch of conditionals to make sure user input meets card information requirements*//*

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
                    */
/* Writes information from text fields to file (.csv) *//*

                    FileWriter fWriter = new FileWriter(paymentInfo, true);
                    BufferedWriter bWriter = new BufferedWriter(fWriter);
                    bWriter.write(String.valueOf(card) + "\n");
                    bWriter.close();
                    System.out.println(card + "\n");
                    card.clear();
                    */
/*switches scene to order placed*//*

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
*/

    /* --------------------------------------------------------------------------------------------------------------- */
    /*                                Functions to add and update theshopping cart:                                    */
    /* --------------------------------------------------------------------------------------------------------------- */
    @FXML
    public TableView<Cart> cartTableView;

    @FXML
    public TableColumn<Cart, String> menuItemType;

    @FXML
    public TableColumn<Cart, Integer> menuItemAmount;

    public final ObservableList <Cart> menuTableList = FXCollections.observableArrayList();

    // Adds item on the page to the shopping cart.
    public void addToShoppingCart(String ItemType, int sumQuantity) {
        menuItemType.setCellValueFactory(new PropertyValueFactory<Cart, String>("menuItemType"));

        menuItemAmount.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("menuItemAmount"));

        menuTableList.add(new Cart(ItemType, sumQuantity));

        cartTableView.setItems(menuTableList);

        cartTableView.refresh();

        // Writes the contents of the table view into a text file
        try {
            copyCartContents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Updates the menuTableList array based on the contents of the textfile.
    public void updateShoppingCart() {
        menuItemType.setCellValueFactory(new PropertyValueFactory<Cart, String>("menuItemType"));
        menuItemAmount.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("menuItemAmount"));

        cartTableView.setItems(menuTableList);

        String FieldDelimiter = ",";

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(cartContents));

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);

                menuTableList.add(new Cart(fields[0], Integer.parseInt(fields[1])));
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();

    }

        System.out.println("updateShoppingCart is being called!");
        // Adds the contents of the array into the table view and refreshes it

        cartTableView.refresh();

        System.out.println(menuTableList);
    }

    // Function to copy contents of the table view into a csv file
    public void copyCartContents() throws Exception {
        FileWriter fw = null;

        try {
            fw  = new FileWriter(cartContents, true);

            for (Cart cart : menuTableList) {

                String text = cart.getMenuItemType() + "," + cart.getMenuItemAmount() + "\n";

                fw.write(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {

            fw.flush();
            fw.close();
        }
    }

    // Function to update the search box.
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