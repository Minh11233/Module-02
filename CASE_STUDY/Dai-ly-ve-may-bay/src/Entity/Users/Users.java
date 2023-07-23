package Entity.Users;

import Interface.writeToFile;

public abstract class Users implements writeToFile {
    private int ID;
    private String account;
    private String passWord;

    public Users(String account, String passWord) {
        this.account = account;
        this.passWord = passWord;
        int count = 0;
        this.ID = ++count;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return account + ";" + passWord;
    }
}
