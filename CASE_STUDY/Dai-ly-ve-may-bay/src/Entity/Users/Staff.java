package Entity.Users;

public class Staff extends Users {
    public Staff(String account, String passWord) {
        super(account, passWord);
    }

    @Override
    public String writeToFile() {
        return getAccount() + ";" + getPassWord() + ";";
    }
}
