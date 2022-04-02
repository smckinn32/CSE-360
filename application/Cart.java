package application;

// Constructor used to populate the table view in the shopping cart.
public class Cart {

    // Creates strings used by a contructor to populate table view.
    public String menuItemType;

    public int menuItemAmount;

    // Contructor to pass parameters to the table-view.
    public Cart(int menuItemAmount, String menuItemType) {
        this.menuItemType = menuItemType;
        this.menuItemAmount = menuItemAmount;
    }

    public String getmenuItemType() {
        return menuItemType;
    }

    public int getmenuItemAmount() {
        return menuItemAmount;
    }
}
