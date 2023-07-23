import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PhoneNumber {
    private final static String PHONENUMBER_REGREX = "^[(][0-9]{2}[)][-][(][0][0-9]{9}[)]$";

    public PhoneNumber() {

    }

    public boolean validate(String regrex) {
        Pattern pattern = Pattern.compile(PHONENUMBER_REGREX);
        Matcher matcher = pattern.matcher(regrex);
        return matcher.matches();
    }
}
