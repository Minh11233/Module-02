public class ClassNameTest {
    private static ClassName className;
    public final static String[] validClassName = new String[] {"C0223G", "A0323K"};
    public final static String[] inValidClassName = new String[] {"M0318G", "P0323A"};
    public static void main(String[] args) {
        className = new ClassName();
        for (String classname: validClassName) {
            boolean isValid = className.validate(classname);
            System.out.println("Class" + classname + "is valid: " + isValid);
        }

        for (String classname: inValidClassName) {
            boolean isValid = className.validate(classname);
            System.out.println("Class" + classname + "is valid: " + isValid);
        }
    }
}
