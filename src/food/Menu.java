package food;

import java.util.*;

public class Menu {

  ArrayList<Dish> menu = new ArrayList<Dish>();

  //Will create the menu from a .txt file within the package
  public static void buildMenu(){}

  /*  Searches the menu for all dishes that contain the specified tags.
    It does this by searching the menu with a while loop, and for each dish it compares
    each tag to the searched tags. If a match is found it is added to the list and returned.*/
  public static LinkedList<Dish> showMe(String[] searchTags){
    LinkedList<Dish> foundDishes = new LinkedList<Dish>();
    String[] dishTags = new String[];
    int menuSize = menu.size() - 1;

    while(menuSize >= 0){
      Dish currentDish = menu.get(menuSize);
      dishTags = currentDish.getTags();

      for(int x = 0; x < searchTags.length; x++){
        for(int y = 0; y < dishTags.length; y++){
          if(dishTags[y].compareToIgnoreCase(searchTags[x])){
            foundDishes.add(currentDish);
          }
        }
      }
      menuSize--;
    }
    return foundDishes;
  }

  /*  Searches the menu for a specfic item.
  It compares the name of each dish to the searched term and adds any matching
  dishes to a linked list, which gets returned.
  */
  public static LinkedList<Dish> searchMenu(String searchTerm){
    LinkedList<Dish> foundDishes = new LinkedList<Dish>();

    for(int i = 0; i < menu.size(); i++){
      if(menu.get(i).getDishName().compareToIgnoreCase(searchTerm)){
        foundDishes.add(menu.get(i));
      }
    }
    return foundDishes;
  }

  public static LinkedList<Dish> searchIngredients(String[] wantIng){}
}
