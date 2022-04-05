package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import profiles.CommonU;

import java.io.IOException;


public class CreateAccountController extends PipeLine {
    @FXML
    private TextField userName;
    @FXML
    private TextField password;

    CommonU user = new CommonU();


    public void createNewAccount(ActionEvent event) throws IOException {
        if (user.isUserExist(userName.getText()))
            System.out.println("User Already exist!");

        else {
            CommonU newUser = new CommonU(userName.getText(), password.getText());
            newUser.sendUserData();
            changeScene(event);
        }
    }
}