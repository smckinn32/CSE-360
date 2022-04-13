package application;

// Constructor used to populate the table view in the shopping cart.
public class Cart {

    private String menuItemType;
    private int menuItemAmount;

    public Cart(String menuItemType, int menuItemAmount) {
        this.menuItemType = menuItemType;
        this.menuItemAmount = menuItemAmount;
    }

    public String getMenuItemType() {
        return menuItemType;
    }

    public int getMenuItemAmount() {
        return menuItemAmount;
    }
}
