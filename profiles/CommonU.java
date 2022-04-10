package profiles;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CommonU extends Profile {

    public int orderHistory;
    public boolean hasCoupon;

    // Default constructor
    public CommonU(){
        super();
        isAdmin = false;
        hasCoupon = false;
    }

    // Constructor to initialize only userName and passWord for user instance
    public CommonU(String userName, String passWord){
        uName = userName;
        pwd = passWord;
        isAdmin = false;
        hasCoupon = false;
    }

    // Constructor to initialize all fields of user instance
    public CommonU(String userName, String passWrod,
                   String fName, String lName, String addr, String number) {
        super(userName, passWrod, fName, lName, addr, number);
        hasCoupon = false;
        isAdmin = false;
    }

    // getOrdHstry return an ArrayList of strings of orders
    public int getOrdHstry () {
        return orderHistory;
    }

    // setOrdHstry append a new order to the orederHistory List
    public void setOrdHstry() {
        orderHistory ++;
    }


    // called to create a coupon for the user
    public void createCoupon() {
        hasCoupon = true;
    }


    // called when user uses his coupon
    public void useCoupon() {
            hasCoupon = false;
    }


    // overload the sendUserData in the profile class to add the coupon option
    public void sendUserData() {
        String line = uName + ";" + pwd + ";" + firstName + ";" + lastName
                + ";" + address + ";" + phoneNum + ";" + isAdmin + ";" + hasCoupon + "\n";
        try {
            FileWriter fw = new FileWriter(DATA_FILE, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(line);
            bw.close();
            fw.close();
        } catch (IOException e) {
            return;
        }
    }


    public String toString() {
        return "UserName: " + uName + ", passWord: " + pwd
                + "\nFirst Name: " + firstName + ", Last Name: " + lastName
                + "\nAddress: " + address + ", Phone Number: " + phoneNum + ", coupon: " + hasCoupon;
    }

}