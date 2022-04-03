package application;

// Constructor used to populate the table view in the shopping cart.
public class Cart {

    // Creates strings used by a contructor to populate table view.
    private String menuItemType;

    private int menuItemAmount;

    // Contructor to pass parameters to the table-view.
    public Cart(int menuItemAmount, String menuItemType) {
        this.menuItemType = menuItemType;
        this.menuItemAmount = menuItemAmount;
        //this.menuItemType = new String(menuItemType);
        //this.menuItemAmount = new int (menuItemAmount);
    }

    public final String getmenuItemType() {
        return menuItemType;
    }

    public final int getmenuItemAmount() {

        return menuItemAmount;
    }
}
