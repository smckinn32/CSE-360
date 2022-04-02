package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import profiles.CommonU;

import javax.imageio.IIOParam;
import java.io.IOException;


public class LoginScreenController extends PipeLine {

    @FXML
    private TextField userName;
    @FXML
    private TextField password;

    CommonU user = new CommonU();


    public void isValidUser(ActionEvent event) throws IOException {
        if(user.getUserData(userName.getText(), password.getText()) != null)
            changeScene(event);
        else
            System.out.println("User does not exist!");
    }

}