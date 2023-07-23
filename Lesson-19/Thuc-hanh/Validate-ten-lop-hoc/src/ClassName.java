import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    private static final String CLASSNAME_REGREX = "^[ACP][0-9]{4,}[GHIK]$";
    public ClassName() {
    }

    public boolean validate(String regrex) {
        Pattern pattern = Pattern.compile(CLASSNAME_REGREX);
        Matcher matcher = pattern.matcher(regrex);
        return matcher.matches();
    }
}
