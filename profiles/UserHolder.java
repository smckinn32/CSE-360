package profiles;

public final class UserHolder {

    private CommonU user;
    private final static UserHolder USERINSTANCE = new UserHolder();

    private UserHolder(){}

    public static UserHolder getUserInstance() {
        return USERINSTANCE;
    }

    public void setUser(CommonU u){
        this.user = u;
    }

    public CommonU getUser(){
        return this.user;
    }
}
