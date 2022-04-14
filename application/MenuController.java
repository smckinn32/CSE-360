package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import food.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.*;

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

        System.out.println("update search box is being called!");
        System.out.println(searchMenuArrayList);

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
            case "BuffaloWings":
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/MENU/BuffaloWings.fxml"));

                root = loader.load();

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                String css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

                scene.getStylesheets().add(css);

                // Updates the searchbox.
                BuffaloWingsController BuffaloWingsController = loader.getController();
                BuffaloWingsController.updateSearchBox();

                break;
            case "ChickenMarsala":
                loader = new FXMLLoader(getClass().getResource("/MENU/ChickenMarsala.fxml"));

                root = loader.load();

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

                scene.getStylesheets().add(css);

                // Updates the searchbox.
                ChickenMarsalaController ChickenMarsalaController = loader.getController();
                ChickenMarsalaController.updateSearchBox();

                break;
            case "FrenchFries":
                loader = new FXMLLoader(getClass().getResource("/MENU/FrenchFries.fxml"));

                root = loader.load();

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

                scene.getStylesheets().add(css);

                // Updates the searchbox.
                FrenchFriesController FrenchFriesController = loader.getController();
                FrenchFriesController.updateSearchBox();

                break;
            case "Lasagna":
                loader = new FXMLLoader(getClass().getResource("/MENU/Lasagna.fxml"));

                root = loader.load();

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

                scene.getStylesheets().add(css);

                // Updates the searchbox.
                LasagnaController LasagnaController = loader.getController();
                LasagnaController.updateSearchBox();

                break;
            case "Spaghetti":
                loader = new FXMLLoader(getClass().getResource("/MENU/Spaghetti.fxml"));

                root = loader.load();

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                scene = new Scene(root);

                stage.setScene(scene);

                stage.show();

                css = this.getClass().getResource("/CSS/Main.css").toExternalForm();

                scene.getStylesheets().add(css);

                // Updates the searchbox.
                SpaghettiController SpaghettiController = loader.getController();
                SpaghettiController.updateSearchBox();

                break;
        }


    }
}
