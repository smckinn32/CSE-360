package application;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SearchPreferencesController extends PipeLine {

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
    public void changeSearchPreferences(ActionEvent event) {

    }

}