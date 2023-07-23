package Entity;

public class Users {
    private int userID;
    private String userName;
    private String passWord;

    public Users() {
    }

    public Users(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        int count = 0;
        this.userID = ++count;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    @Override
    public String toString() {
        return "Tên đăng nhập của bạn là: "+ userName + "\nMật khẩu của bạn là: " + passWord;
    }
}
