package profiles;

import java.util.ArrayList;


public class CommonU extends Profile {

    public ArrayList<String> orderHistory;     // ArrayList to add and delete orders
    public int couponCounter;

    // Default constructor
    public CommonU(){
        super();
        isAdmin = false;
    }

    // Constructor to initialize only userName and passWord for user instance
    public CommonU(String userName, String passWord){
        uName = userName;
        pwd = passWord;
        isAdmin = false;
    }

    // Constructor to initialize all fields of user instance
    public CommonU(String userName, String passWrod,
                   String fName, String lName, String addr, String number) {
        super(userName, passWrod, fName, lName, addr, number);
        couponCounter = 0;
        isAdmin = false;
    }

    // getOrdHstry return an ArrayList of strings of orders
    public ArrayList<String> getOrdHstry () {
        return orderHistory;
    }

    // setOrdHstry append a new order to the orederHistory List
    public void setOrdHstry(String ordHist) {
        orderHistory.add(ordHist);
    }

    public void incrementCouponCounter() {
        couponCounter ++;
    }


    public String toString() {
        return "UserName: " + uName + ", passWord: " + pwd
                + "\nFirst Name: " + firstName + ", Last Name: " + lastName
                + "\nAddress: " + address + ", Phone Number: " + phoneNum;
    }

}