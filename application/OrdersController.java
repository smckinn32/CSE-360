package application;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javax.imageio.IIOParam;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class OrdersController extends PipeLine {
    // Function to update search box
    public void updateSearchBox() {
        try {
            Scanner s = new Scanner(new File("TextFiles/SearchMenu.txt"));
            while (s.hasNext()) {
                searchMenuArrayList.add(s.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(searchMenuArrayList);

        // Adds the contents of the array to the list-view.
        searchBox.getItems().addAll(searchMenuArrayList);

        // Refreshes the list view.
        searchBox.refresh();
        System.out.println(searchMenuArrayList);
    }

}