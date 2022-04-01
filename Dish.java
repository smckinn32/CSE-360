package food;

public class Dish {

  public String[] ingredients, tags;
  public String dishName;
  public double price;
  public int timeToMake;

  public Dish (String[] i, String[] t, String d, double p, int ttm) {
    this.ingredients = i;
    this.tags = t;
    this.dishName = d;
    this.price = p;
    this.timeToMake = ttm;
  }

  //getters
  public String[] getIngredients()
  {return ingredients;}
  public String[] getTags()
  {return tags;}
  public String getDishName()
  {return dishName;}
  public double getPrice()
  {return price;}
  public int getTimeToMake()
  {return timeToMake;}
}
