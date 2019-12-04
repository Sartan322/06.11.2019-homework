package db.models;


public class User {
    private long id;
    private String login;
    private String password;
    private String avatar;
    private String name;
    private String selfName;
    private String selfInformation;
    private int city;
    private String bDay;

    public User(long id,String login, String password, String avatar, String name, String selfName, String selfInformation, int city, String bDay) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.avatar = avatar;
        this.name = name;
        this.selfName = selfName;
        this.selfInformation = selfInformation;
        this.city = city;
        this.bDay = bDay;
    }

    public User(String login, String password, String avatar, String name, String selfName, String selfInformation, int city, String bDay) {
        this.login = login;
        this.password = password;
        this.avatar = avatar;
        this.name = name;
        this.selfName = selfName;
        this.selfInformation = selfInformation;
        this.city = city;
        this.bDay = bDay;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelfName() {
        return selfName;
    }

    public void setSelfName(String selfName) {
        this.selfName = selfName;
    }

    public String getSelfInformation() {
        return selfInformation;
    }

    public void setSelfInformation(String selfInformation) {
        this.selfInformation = selfInformation;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getbDay() {
        return bDay;
    }

    public void setbDay(String bDay) {
        this.bDay = bDay;
    }

    @Override
    public String toString() {
        return "User{ "+
                "login = " + login + "\n" +
                "password =" + password + "\n" +
                "name = " + name + "\n" +
                "selfName = " + selfName + "\n" +
                "selfInformation = " + selfInformation + "\n" +
                "city = " + city + "\n" +
                "bDay = " + bDay;

    }
}
