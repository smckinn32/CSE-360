package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SearchPreferencesController extends PipeLine {

    // Instantiate switches to be used in search preferences functions.
    @FXML
    public CheckBox AllSwitch;

    @FXML
    public CheckBox veganSwitch;

    @FXML
    public CheckBox vegetarianSwitch;

    @FXML
    public CheckBox paleoSwitch;

    @FXML
    public CheckBox ketoSwitch;

    @FXML
    public CheckBox lowcarbSwitch;


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



    // Function to update the state of the search preferences buttons. Preserves the states of the buttons when switching back and forth between scenes.
    public void updateSearchPreferences() {

    }

    // Function to change the search preferences, i.e. what shows up in the search
    public void changeSearchPreferences (ActionEvent event) {
        if(AllSwitch.isSelected()) {
            veganSwitch.setSelected(false);
            vegetarianSwitch.setSelected(false);
            paleoSwitch.setSelected(false);
            ketoSwitch.setSelected(false);
            lowcarbSwitch.setSelected(false);
        }
        // If all 5 search preferences are checked, then it defaults to the all selection.
        else if(veganSwitch.isSelected() && vegetarianSwitch.isSelected() && paleoSwitch.isSelected() && ketoSwitch.isSelected() && lowcarbSwitch.isSelected()) {
            AllSwitch.setSelected(true);

            // Turns off all switches besides all switch.
            veganSwitch.setSelected(false);
            vegetarianSwitch.setSelected(false);
            paleoSwitch.setSelected(false);
            ketoSwitch.setSelected(false);
            lowcarbSwitch.setSelected(false);

        }
        else if(veganSwitch.isSelected()) {
            AllSwitch.setSelected(false);


            // Updates the search box after changing file.
            updateSearchBox();
        }
        else if(vegetarianSwitch.isSelected()) {
            AllSwitch.setSelected(false);

            // Updates the search box after changing file.
            updateSearchBox();
        }
        else if(paleoSwitch.isSelected()) {
            AllSwitch.setSelected(false);

            // Updates the search box after changing file.
            updateSearchBox();
        }
        else if(ketoSwitch.isSelected()) {
            AllSwitch.setSelected(false);

            // Updates the search box after changing file.
            updateSearchBox();
        }
        else if(lowcarbSwitch.isSelected()) {
            AllSwitch.setSelected(false);

            // Updates the search box after changing file.
            updateSearchBox();
        }
    }

    public void deleteLine(int Value) {

    }
}