import java.util.Scanner;

public class UserService {
    private static final String WELCOME_LINE = "Xin chào bạn , \nXin xác nhận số điện thoại và địa chỉ dưới đây: \nSố điện thoại: \nĐịa chỉ:   ";

    public static void Register() {
        String user = prompt("Nhập tên người dùng");
        String phoneNumber = prompt("Nhập số điện thoại");
        String address = prompt("Nhập địa chỉ");

        User user1 = new User(user, phoneNumber, address);
        StringBuilder builder = new StringBuilder(WELCOME_LINE);
        final int INDEX_OF_NAME = 13;
        final int INDEX_OF_PHONENUMBER = 80 + user1.getName().length();
        final int INDEX_OF_ADDRESS = 94 + user1.getPhoneNumber().length();

        builder.insert(INDEX_OF_NAME, user1.getName());
        builder.insert(INDEX_OF_PHONENUMBER, user1.getPhoneNumber());
        builder.insert(INDEX_OF_ADDRESS, user1.getAddress());
        System.out.println(builder);

    }

    public static String prompt(String request) {
        Scanner input = new Scanner(System.in);
        System.out.println(request);
        return input.nextLine();
    }
}
