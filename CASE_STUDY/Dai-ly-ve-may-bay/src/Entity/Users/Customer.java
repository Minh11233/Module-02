package Entity.Users;

public class Customer extends Users {
    public Customer(String account, String passWord) {
        super(account, passWord);
    }

    @Override
    public String writeToFile() {
        return getAccount() + ";" + getPassWord() + ";";
    }
}

