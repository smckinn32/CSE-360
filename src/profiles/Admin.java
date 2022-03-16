package profiles;

public class Admin extends Profile {

    public Admin() {
        super();
        isAdmin = true;
    }
    public Admin(String userName, String passWrod,
                 String fName, String lName, String addr, String number) {
        super(userName, passWrod, fName, lName, addr, number);
        isAdmin = true;

    }

    //TODO: write block code for this method
    public void setCoupon() {

    }

    public void editMenu(){

    }

    public void swapView(){

    }

}