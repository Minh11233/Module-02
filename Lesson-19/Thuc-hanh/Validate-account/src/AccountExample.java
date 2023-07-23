import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class AccountExample {
    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";
    public AccountExample() {

    }

    public boolean validate(String regrex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regrex);
        return matcher.matches();
    }
}
