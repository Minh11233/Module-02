package Service;

import java.text.ParseException;
import java.util.Scanner;

public abstract class UserService {
    public String prompt(String request) {
        Scanner input = new Scanner(System.in);
        System.out.println(request);
        return input.nextLine();
    }
    public abstract void register() throws Exception;

    public abstract void login() throws Exception;

    public abstract void accountFunction() throws Exception;
}
