package application;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import food.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuController extends PipeLine {

    // Instantiates the menuListView so it can be used in functions.
    @FXML
    public ListView <String> menuListView;

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
