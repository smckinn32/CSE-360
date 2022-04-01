package application;
import javafx.event.EventHandler;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javax.imageio.IIOParam;
import java.io.*;


public class MenuController extends Controller{

    // Declarations
    private IIOParam loader;
    private Parent root;
    private Stage stage;
    private Scene scene;

    // Instantiates the menuListView so it can be used in functions.
    @FXML
    public ListView <String> menuListView;

    // Creates the updateMenuFunction that sets the contents of the list-view equal to that of menu array contained in the PipeLine which acts as the main controller.
    public void updateMenuListView() {
        System.out.println(menuList);
        menuListView.getItems().addAll(menuList);
    }
}