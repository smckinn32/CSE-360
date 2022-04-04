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
    private TextField fullName;
    @FXML
    private TextField address;
    @FXML
    private TextField Email;
    @FXML
    private TextField passwordHidden;

    UserHolder holder = UserHolder.getUserInstance();
    CommonU user = holder.getUser();

    public void acceptChanges(Event e){
        user.editUserData(fullName.getText(),address.getText(), Email.getText(), passwordHidden.getText());
    }
}