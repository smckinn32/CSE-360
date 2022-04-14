package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import food.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuController extends PipeLine {

    // Instantiates the menuListView so it can be used in functions.
    @FXML
    public ListView<String> menuListView;

    Menu myMenu = new Menu();

    // Creates the updateMenuFunction that sets the contents of the list-view equal to that of menu array contained in the PipeLine which acts as the main controller.
    public void updateMenuListView() {
        System.out.println(menuList);
        /*
				menuList.clear();
				for(int i=0; i<myMenu.menu.size(); i++){
					menuList.add(myMenu.menu.get(i).getDishName());

				}
        */
        menuListView.getItems().addAll(menuList);
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

    public void updateMenu() {

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader("MENU/Menu.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                String fields = line.split(" ")[0];

                menuList.add(fields);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        // Adds the contents of the arraylist into the list view
        menuListView.getItems().addAll(menuList);

        // Refreshes the list view.
        menuListView.refresh();

    }

    public void menuChangeScene (MouseEvent event) throws IOException {

        //Gets the item selected from the search box
        String temp = menuListView.getSelectionModel().getSelectedItem();

        switch (temp) {
            case "Buffalo-Wings":
                Parent root = FXMLLoader.load(getClass().getResource("/MENU/Buffalo-Wings.fxml"));

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

                scene.getStylesheets().add(css);

                updateSearchBox();

                break;
            case "Chicken-Marsala":
                root = FXMLLoader.load(getClass().getResource("/MENU/Chicken-Marsala.fxml"));

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

                scene.getStylesheets().add(css);

                updateSearchBox();

                break;
            case "French-Fries":
                root = FXMLLoader.load(getClass().getResource("/MENU/French-Fries.fxml"));

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

                scene.getStylesheets().add(css);

                updateSearchBox();

                break;
            case "Lasagna":
                root = FXMLLoader.load(getClass().getResource("/MENU/Lasagna.fxml"));

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

                scene.getStylesheets().add(css);

                updateSearchBox();

                break;
            case "Spaghetti":
                root = FXMLLoader.load(getClass().getResource("/MENU/Spaghetti.fxml"));

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

                scene.getStylesheets().add(css);

                updateSearchBox();

                break;
        }


    }
}
