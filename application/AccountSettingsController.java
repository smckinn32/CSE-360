package application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import profiles.CommonU;
import profiles.Profile;
import profiles.UserHolder;

import javax.imageio.IIOParam;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


// TODO: move the user object from the LoginScreenController.java to this controller
// So it can be modified to insert names, address, etc.

public class AccountSettingsController extends PipeLine {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField address;
    @FXML
    private TextField phoneNumber;

    UserHolder holder = UserHolder.getUserInstance();
    Profile user = holder.getUser();

    public void acceptChanges(Event e){
        user.editUserData(firstName.getText(),lastName.getText(), address.getText(), phoneNumber.getText());
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

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        // Adds the contents of the arraylist into the list view
        searchBox.getItems().addAll(searchMenuArrayList);

        // Refreshes the list view.
        searchBox.refresh();

    }
}