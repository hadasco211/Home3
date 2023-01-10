package Home3;
public class User {
    private String userName;
    private String password;
    private String phoneNumber;
    private Integer userType;
    public static final int REGULAR_USER = 1;
    public static final int MEDIATOR = 2;

    //o(1)
    public User() {

    }

    //o(1)
    public User(String userName, String password, String phoneNumber, Integer userType) {
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        if (this.isValidUserType(userType))
            this.userType = userType;
        else {

        }
    }
    //o(1)
    private boolean isValidUserType(Integer userType) {
        boolean isValid = false;
        if (userType == REGULAR_USER || userType == MEDIATOR)
            isValid = true;
        return isValid;
    }


    public String getUserName() {
        return userName;
    }

//o(1)
    public String getPassword() {
        return password;
    }


//o(1)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //o(1)
    public Integer getUserType() {
        return userType;
    }
    //o(1)
    public String toString() {
        String outPut = "";
        outPut += "user name:" + " " + this.userName + "\n";
        // outPut += "password:" + this.password + "\n";
        outPut += "phone number:" + " " + this.phoneNumber + "\n";
        outPut += "user type:" + " " + this.getPrintableUserType() + "\n";
        return outPut;
    }
    //o(1)
    private String getPrintableUserType() {
        String printableUserType = "";
        if (this.userType == MEDIATOR) {
            printableUserType = "mediator";
        } else if (this.userType == REGULAR_USER) {
            printableUserType = "regular user";
        } else printableUserType = "-";
        return printableUserType;
    }

}
