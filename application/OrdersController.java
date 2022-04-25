package application;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javax.imageio.IIOParam;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class OrdersController extends PipeLine {

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