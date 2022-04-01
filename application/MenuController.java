package application;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javax.imageio.IIOParam;


public class MenuController extends PipeLine {

    // Instantiates the menuListView so it can be used in functions.
    @FXML
    public ListView <String> menuListView;

    // Creates the updateMenuFunction that sets the contents of the list-view equal to that of menu array contained in the PipeLine which acts as the main controller.
    public void updateMenuListView() {
        System.out.println(menuList);
        menuListView.getItems().addAll(menuList);
    }
}