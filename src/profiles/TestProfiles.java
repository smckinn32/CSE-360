/*
    This is a test program that will test commonU, profile, admin classes.
*/


package profiles;

import profiles.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestProfiles {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner stdin = new Scanner(System.in);


        Admin admin = new Admin();
        String uName = stdin.nextLine();
        String pwd = stdin.nextLine();
        int checkUser = admin.setUserInfo(uName, pwd);
        if (checkUser == 0)
            System.out.println("User was found!");
        else
            System.out.println("User was not found!!");

//        System.out.println("Enter your userName, password, First name, last name, address, and phone number:  ");
//        String uName = stdin.nextLine();
//        String pwd = stdin.nextLine();
//
//        String fisrtName = stdin.nextLine();
//        String lastName = stdin.nextLine();
//        String addr = stdin.nextLine();
//        String phone = stdin.nextLine();
//
//        //creating a common user using constructor param
//        CommonU user1 = new CommonU(uName, pwd, fisrtName, lastName, addr, phone);
//
//        //getting user1 info from instance
//        String[] str1 = user1.getUserInfo();
//        for(String s: str1) System.out.println(s);
//
//        // Creating a common user using default constructor
//        Admin user2 = new Admin();
//        // getting the data for user 2 from the txt file
//        String[] str2 = user2.getUserData("AdminUser", "Password123");
//        for(String s: str2) System.out.println(s);
    }

}
