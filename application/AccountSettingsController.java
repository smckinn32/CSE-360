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
import profiles.UserHolder;

import javax.imageio.IIOParam;


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
    CommonU user = holder.getUser();

    public void acceptChanges(Event e){
        // UNCOMMENT THIS IF STATEMENT IF YOU WANT THE USER TO NOT BE ABLE TO CHANGE INFORMATION
        //        if (user.getFirstName().equals("") && user.getLastName().equals(""))
        user.editUserData(firstName.getText(),lastName.getText(), address.getText(), phoneNumber.getText());
    }
}