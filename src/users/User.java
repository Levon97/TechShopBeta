package users;

public class User {
    private String name;
    private String lastName;
    private String userName;
    private String eMail;
    private String md5Pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getMd5Pass() {
        return md5Pass;
    }

    public void setMd5Pass(String md5Pass) {
        this.md5Pass = md5Pass;
    }

}
