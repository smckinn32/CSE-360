

package profiles;

import java.io.*;

public abstract class Profile {
    private static final int USERATTRIBUTES = 7;
    private static final String DATA_FILE = "Users.csv";
    protected String uName;
    protected String pwd;
    protected String paymentInfo;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String phoneNum;
    protected boolean isAdmin;


    public Profile() {
        uName = "";
        pwd = "";
        paymentInfo = "";
        firstName = "";
        lastName = "";
        address = "";
        phoneNum = "";
    }

    public Profile(String userName, String passWrod,
                   String fName, String lName, String addr, String number) {
        uName = userName;
        pwd = passWrod;
        firstName = fName;
        lastName = lName;
        address = addr;
        phoneNum = number;
    }

    public String getUserName() {
        return uName;
    }

    public void setUserName(String name) {
        uName = name;
    }

    public String getPassWord() {
        return pwd;
    }

    public void setPassWord(String pass) {
        pwd = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        lastName = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addr) {
        address = addr;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String number) {
        phoneNum = number;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


    /*
        getUserInfo return the information of the instance of the user
        as an array of strings if the following format:
        [UserName, PassWord, FirstName, LastName, Address, phoneNumber, isAdmin]
    */
    public String[] getUserInfo() {
        String[] info = new String[USERATTRIBUTES];
        info[0] = uName;
        info[1] = pwd;
        info[2] = firstName;
        info[3] = lastName;
        info[4] = address;
        info[5] = phoneNum;
        info[6] = String.valueOf(isAdmin);
        return info;
    }

    /*
        setUserInfo method look for a user from the user login file
        and set their attributes to the instance that it was called from.
        the function returns 0 if user was found. Otherwise, it returns -1.
        @param, the userName and passWord of the user, respectively.
    */
    public int setUserInfo(String userName, String passWord) {
        if (getUserData(userName, passWord) != null) {
            String[] user = getUserData(userName, passWord);
            uName = user[0];
            pwd = user[1];
            firstName = user[2];
            lastName = user[3];
            address = user[4];
            phoneNum = user[5];
            isAdmin = Boolean.parseBoolean(user[6]);
            return 0;
        }
        else
            return -1;
    }

    /*
        getUserData method get The user data from txt file.
        The function takes the userName and passWord @Param
        and returns a list of the user data with format
        [UserName, PassWord, FirstName, LastName, Address, phoneNumber, isAdmin]
        the function will return null if the user is not found.
    */
    public String[] getUserData(String userName, String passWord) {
        String line = "";
        String[] user;
        boolean found = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(DATA_FILE));
            while ((line = br.readLine()) != null && !found) {
                user = line.split(";");
                if (user[0].equals(userName) && user[1].equals(passWord)) {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
        sendUserData method send (append) the data of the instance of user
        to the txt file that contains users information, the data is send in the
        following format:
        {UserName;PassWord;FirstName;LastName;Address;phoneNumber:isAdmin}
    */
    public void sendUserData() {
        String line = uName + ";" + pwd + ";" + firstName + ";" + lastName
                            + ";" + address + ";" + phoneNum + ";" + isAdmin + "\n";
        try {
            FileWriter fw = new FileWriter(DATA_FILE, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(line);
            bw.close();
        } catch (IOException e) {
            return;
        }
    }

    // search the Users.csv file and return true if the user
    // exist, otherwise returns false
    public boolean isUserExist(String userName){
        String line = "";
        String[] user;
        boolean found = false;
        try{
            BufferedReader br = new BufferedReader(new FileReader(DATA_FILE));
            while((line = br.readLine()) != null && !found){
                user = line.split(";");
                if(user[0].equals(userName))
                    return true;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}