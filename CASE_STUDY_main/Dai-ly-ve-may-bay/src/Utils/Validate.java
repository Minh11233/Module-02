package Utils;

import java.util.regex.*;

public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String FLIGHT_TIME = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";
    private static final String PHONE_NUMBER = "^\\+?(?:\\d{2})?[0]\\d{9}$";

    public static boolean validate(String regex, String regexPattern) {
        switch (regexPattern) {
            case "EMAIL":
                pattern = Pattern.compile(EMAIL);
                break;
            case "FLIGHT_TIME":
                pattern = Pattern.compile(FLIGHT_TIME);
                break;
            case "PHONE_NUMBER":
                pattern = Pattern.compile(PHONE_NUMBER);
                break;
        }
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
