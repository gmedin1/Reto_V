package models;


import java.util.Date;

public class User {

    private String userAlias;
    private String userName;
    private String userLastName;
    private String userEmail;
    private String userPhoneNumber;
    private String userPassword;
    private Date userBirdDate;

    // Constructors
    public User(String userAlias, String userPassword) {
        this.userAlias = userAlias;
        this.userPassword = userPassword;
    }

    public User(String userAlias, String userName, String userLastName, String userEmail, String userPhoneNumber, String userPassword, Date userBirdDate) {
        this.userAlias = userAlias;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.userPassword = userPassword;
        this.userBirdDate = userBirdDate;
    }

    public String[] getAsRow() {
        return new String[] { userAlias, userName, userLastName, userEmail, userPhoneNumber, userPassword, String.valueOf(userBirdDate) };
    }

    // Getters & Setters

    public String getUserAlias() {
        return userAlias;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Date getUserBirdDate() {
        return userBirdDate;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserBirdDate(Date userBirdDate) {
        this.userBirdDate = userBirdDate;
    }

    @Override
    public String toString() {
        return "User: " + this.getUserAlias() + "\nPassword: " + this.getUserPassword();
    }

}
