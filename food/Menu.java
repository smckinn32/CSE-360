package food;

import java.util.*;
import java.io.*;

public class Menu {

  public ArrayList<Dish> menu = new ArrayList<Dish>();
  public ArrayList<String> dishTitles = new ArrayList<String>();
  static final String menuFile = "food/Menu.txt";
  /* Builds the menu ArrayList by parsing through a text file.*/
  public void buildMenu(){
    String ingredients, tags, dName;
    String[] ingredientList, tagList;
    int numDishes, timeToMake;
    double price;

	 	Scanner scan = null;
    try {
      scan = new Scanner(new FileInputStream(menuFile));
			scan.nextLine();

      while(scan.hasNext()){
				String[] cLine = scan.nextLine().split(":", 5);
				dName = cLine[0];
        price = Double.parseDouble(cLine[1]);
        timeToMake = Integer.parseInt(cLine[2]);
        ingredients = cLine[3];
        tags = cLine[4];

        ingredientList = ingredients.split(",", 10);
        tagList = tags.split(",", 5);

        Dish newDish = new Dish(ingredientList, tagList, dName, price, timeToMake);
        menu.add(newDish);
      }
    } catch(IOException e) {}
  }

  /*  Searches the menu for all dishes that contain the specified tags.
    It does this by searching the menu with a while loop, and for each dish it compares
    each tag to the searched tags. If a match is found it is added to the list and returned.*/
  public LinkedList<Dish> searchByTag(String[] searchTags){
    LinkedList<Dish> foundDishes = new LinkedList<Dish>();
    String[] dishTags = null;
    //int counter = menu.size() - 1;

    for(int c=0; c<menu.size(); c++){
      Dish currentDish = menu.get(c); //System.out.printf(">Now checking %s...\n", currentDish.getDishName());
      dishTags = currentDish.getTags();

      for(int x = 0; x < dishTags.length; x++){
        for(int y = 0; y < searchTags.length; y++){ //System.out.printf(">>Now comparing %s & %s\n", dishTags[x], searchTags[y]);
          if(dishTags[x].equalsIgnoreCase(searchTags[y])){
            foundDishes.add(currentDish); //System.out.println(">>> Match Found!");
          }
        }
      }
      //counter--;
    }
    return foundDishes;
  }

  /*  Adds an item to the end of the menu text file & then updates the menu List*/
  public void addMenuItem(String dName, Double price, Integer timeTM, String[] ing, String[] tags){
    try {
    	BufferedWriter bw = new BufferedWriter(new FileWriter(menuFile, true));

	    dName += ":";
	    String priceStr = String.valueOf(price) + ":";
	    String timeTMStr = String.valueOf(timeTM) + ":";

	    bw.write(dName);
	    bw.write(priceStr);
	    bw.write(timeTMStr);

	    for(int i=0; i<ing.length; i++){
	      String ingSeperate = ing[i];

	      if(i == (ing.length-1))
	        {ingSeperate += ":";}
	      else
	        {ingSeperate += ",";}
	      bw.write(ingSeperate);
	    }

	    for(int j=0; j<tags.length; j++){
	      String tagsSeperate = tags[j];

	      if(j == (tags.length-1))
	        {tagsSeperate += ":";}
	      else
	        {tagsSeperate += ",";}
	      bw.write(tagsSeperate);
	    }
	    bw.close();
    } catch (IOException e){}
    //Finished writing to file, now update the menu array list object with the new dish.
    Dish newDish = new Dish(ing, tags, dName, price, timeTM);
    menu.add(newDish);
  }

  /*  Searches the menu for a specfic item.
  It compares the name of each dish to the searched term and adds any matching
  dishes to a linked list, which gets returned.
  */
  public LinkedList<Dish> searchByTerm(String searchTerm){
    LinkedList<Dish> foundDishes = new LinkedList<Dish>();

    for(int i = 0; i < menu.size(); i++){
      if(menu.get(i).getDishName().equalsIgnoreCase(searchTerm)){
        foundDishes.add(menu.get(i));
      }
    }
    return foundDishes;
  }

  /*  Searches the menu for any items containing specified ingredients*/
  public LinkedList<Dish> searchByIngredients(String[] wantedI){
    LinkedList<Dish> foundDishes = new LinkedList<Dish>();
    //int counter = menu.size() -1;
    String[] dishI = null;

    for(int c=0; c<menu.size(); c++){
      Dish currentDish = menu.get(c);
      dishI = currentDish.getIngredients();

      for(int x = 0; x < wantedI.length; x++){
        for(int y = 0; y < dishI.length; y++){
          if(dishI[y].equalsIgnoreCase(wantedI[x])){
            foundDishes.add(currentDish);
          }
        }
      }
      //counter--;
    }
    return foundDishes;
  }

  public String searchByTitle(String srch){
    String foundDish = null;

    for(int i = 0; i < menu.size(); i++){
      if(menu.get(i).getDishName().equalsIgnoreCase(srch)){
        foundDish = dishTitles.get(i);
      }
    }
    return foundDish;
  }

  public ArrayList<String> getDishTitle(){
    dishTitles.clear();
    String tempTitle = "";
    
    for(int i=0; i<menu.size(); i++){
      if(menu.get(i).getDishName().contains(" ")){
        tempTitle = menu.get(i).getDishName().replace(" ", "");}
      dishTitles.add(tempTitle);
    }
    return dishTitles;

  }

}
