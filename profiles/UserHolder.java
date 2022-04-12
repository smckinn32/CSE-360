package profiles;

public final class UserHolder {

    private Profile user;
    private final static UserHolder USERINSTANCE = new UserHolder();

    private UserHolder(){}

    public static UserHolder getUserInstance() {
        return USERINSTANCE;
    }

    public void setUser(Profile u){
        this.user = u;
    }

    public Profile getUser(){
        return this.user;
    }
}
