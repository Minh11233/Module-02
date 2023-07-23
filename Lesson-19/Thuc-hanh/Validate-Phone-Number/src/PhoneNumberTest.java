public class PhoneNumberTest {
    private static PhoneNumber phoneNumber;
    public static final String[] validPhoneNumber = new String[] {"(84)-Ü(0978489648)"};
    public static final String[] inValidPhoneNumber = new String[] {"(a8)-(22222222)","(84)-(22b22222)","(84)-(9978489648)"};

    public static void main(String args[]) {
        phoneNumber = new PhoneNumber();
        for (String phoneNum : validPhoneNumber) {
            boolean isValid = phoneNumber.validate(phoneNum);
            System.out.println("Phone Number: " + phoneNum + " is valid: " + isValid);
        }
        for (String phoneNum : inValidPhoneNumber) {
            boolean isValid = phoneNumber.validate(phoneNum);
            System.out.println("Phone Number: " + phoneNum + " is valid: " + isValid);
        }
    }
}
