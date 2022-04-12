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
import profiles.Admin;
import profiles.CommonU;
import profiles.Profile;
import profiles.UserHolder;

import javax.imageio.IIOParam;
import java.io.IOException;


public class LoginScreenController extends PipeLine {

    @FXML
    private TextField userName;
    @FXML
    private TextField password;

    // Creates the primary stage, scene, and root.
    private Stage stage;
    private Scene scene;
    private Parent root;

    Profile user = new CommonU();

    // TODO: add an if statement to check if user is an Admin
    public void isValidUser(ActionEvent event) throws IOException {

        if (user.isAdmin())
            user = new Admin();
        else
            user = new CommonU();


        if(user.getUserData(userName.getText(), password.getText()) != null) {

            user.setUserName(userName.getText());
            user.setPassWord(password.getText());
            UserHolder holder = UserHolder.getUserInstance();
            holder.setUser(user);
            changeScene(event);
        }
        else
            System.out.println("User does not exist!");

    }


    // TODO: might need to change the fxid to "Login"
    public void guestUser(ActionEvent event) throws IOException {
        user.setUserName("GuestUser");
        user.setPassWord("NoPass");
        UserHolder holder = UserHolder.getUserInstance();
        holder.setUser(user);
        changeScene(event);

    }


}
