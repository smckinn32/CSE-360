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

    // check if user has ordered, if they did. they
    // give the user a coupon
    public void setCoupon(CommonU user) {
        if (user.getOrdHstry() > 0) {
            user.createCoupon();
        }
    }



}