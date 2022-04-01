package application;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javax.imageio.IIOParam;


public class ShoppingCartController extends PipeLine {

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

}