package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import profiles.CommonU;
import profiles.UserHolder;

import javax.imageio.IIOParam;
import java.io.IOException;


public class LoginScreenController extends PipeLine {

    @FXML
    private TextField userName;
    @FXML
    private TextField password;

    CommonU user = new CommonU();

    // TODO: add an if statement to check if user is an Admin
    public void isValidUser(ActionEvent event) throws IOException {
<<<<<<< HEAD
        if(user.getUserData(userName.getText(), password.getText()) != null) {
            user.setUserName(userName.getText());
            user.setPassWord(password.getText());
            UserHolder holder = UserHolder.getUserInstance();
            holder.setUser(user);
            changeScene(event);
        }
        else
            System.out.println("User does not exist!");
=======
        //if(user.getUserData(userName.getText(), password.getText()) != null)
            changeScene(event);
        /*else
            System.out.println("User does not exist!");*/
>>>>>>> 7eea64c7eb8b1689ab660f68e0d19f7b30c3291a
    }


}