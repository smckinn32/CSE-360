package food;

import java.util.*;
import.java.io.*;

public class Menu {

  ArrayList<Dish> menu = new ArrayList<Dish>();
  String menuFile = "Menu.txt"
  /* Builds the menu ArrayList by parsing through a text file.*/
  public static void buildMenu(){
    String ingredients, tags;
    String[] ingredientList, tagList;
    private int numDishes, timeToMake;
    private double price;
    private String dName;

    try {
      Scanner scan = new Scanner(new FileInputStream(menuFile))
      numDishes = Integer.parseInt(scan.nextLine());
      scan.useDelimiter("|")

      while(numDishes != 0){
        dName = scan.next();
        price = Double.parseDouble(scan.next());
        timeToMake = Integer.parseInt(scan.next());
        ingredients = scan.next();
        tags = scan.next();

        ingredientList = ingredients.split(",", 10);
        tagList = tags.split(",", 5);

        Dish newDish = new Dish(ingredientList, tagList, dName, price, timeToMake);
        menu.add(newDish);

        numDishes--;
      }
    } catch(IOException e);
    scan.close();
  }

  /*  Searches the menu for all dishes that contain the specified tags.
    It does this by searching the menu with a while loop, and for each dish it compares
    each tag to the searched tags. If a match is found it is added to the list and returned.*/
  public static LinkedList<Dish> searchByTag(String[] searchTags){
    LinkedList<Dish> foundDishes = new LinkedList<Dish>();
    String[] dishTags = new String[];
    int counter = menu.size() - 1;

    while(counter >= 0){
      Dish currentDish = menu.get(counter);
      dishTags = currentDish.getTags();

      for(int x = 0; x < searchTags.length; x++){
        for(int y = 0; y < dishTags.length; y++){
          if(dishTags[y].compareToIgnoreCase(searchTags[x])){
            foundDishes.add(currentDish);
          }
        }
      }
      counter--;
    }
    return foundDishes;
  }

  public static void addMenuItem(String dName, Double price, Int timeTM, String[] ing, String[] tags){
    BufferedWriter bw = new BufferedWriter(new FileWriter(menuFile, true));
    dName += "|";
    String priceStr = String.valueOf(price) + "|";
    String timeTMStr = String.valueOf(timeTM) + "|";

    bw.newLine();
    bw.write(dName);
    bw.write(priceStr);
    bw.write(timeTMStr);

    for(int i=0; i<ing.length(); i++){
      String ingSeperate = ing[i];

      if(i == (ing.length()-1))
        {ingSeperate += "|";}
      else
        {ingSeperated += ",";}
      bw.write(ingSeperate);
    }

    for(int j=0; j<tags.length(); i++){
      String tagsSeperate = tags[j];

      if(j == (tags.length()-1))
        {tagsSeperate += "|";}
      else
        {tagsSeperate += ",";}
      bw.write(tagsSeperate);
    }

    bw.close();
  }

  /*  Searches the menu for a specfic item.
  It compares the name of each dish to the searched term and adds any matching
  dishes to a linked list, which gets returned.
  */
  public static LinkedList<Dish> searchByTerm(String searchTerm){
    LinkedList<Dish> foundDishes = new LinkedList<Dish>();

    for(int i = 0; i < menu.size(); i++){
      if(menu.get(i).getDishName().compareToIgnoreCase(searchTerm)){
        foundDishes.add(menu.get(i));
      }
    }
    return foundDishes;
  }

  /*  Searches the menu for any items containing specified ingredients*/
  public static LinkedList<Dish> searchByIngredients(String[] wantedI){
    LinkedList<Dish> foundDishes = new LinkedList<Dish>();
    int counter = menu.size() -1;
    String[] dishI = new String[];

    while(counter >=0){
      Dish currentDish = menu.get(counter);
      dishI = currentDish.getIngredients();

      for(int x = 0; x < wantedI.length; x++){
        for(int y = 0; y < dishI.length; y++){
          if(dishI[y].compareToIgnoreCase(wantedI[x])){
            foundDishes.add(currentDish);
          }
        }
      }
      counter--;
    }
    return foundDishes;
  }
}
