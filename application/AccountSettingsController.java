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
import java.io.File;
import java.io.FileNotFoundException;
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