package Service;

import Entity.Users;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class UserService {
    private static final Scanner input = new Scanner(System.in);
    private static final Set<Users> UsersInfo;

    static {
        UsersInfo = new HashSet<>();
        UsersInfo.add(new Users("Minh","Minh123"));
        UsersInfo.add(new Users("Lam","Lam123"));
        UsersInfo.add(new Users("Thai","Thai123"));
    }

        public static boolean checkDuplicateUsers(String userName) {
        for (Users member: UsersInfo) {
            if (Objects.equals(member.getUserName(), userName)) {
                return true;
            }
        } return false;
     }

    public static boolean checkDuplicatePassword(String password) {
        for (Users member: UsersInfo) {
            if (Objects.equals(member.getPassWord(), password)) {
                return true;
            }
        } return false;
    }

    public static void Register(){
        String newUserName;
        String newPassword;
        do {
            System.out.println("Đăng ký tên đăng nhập:");
            newUserName = input.nextLine();
            System.out.println("Tên đăng nhập của bạn là: " + newUserName);

            System.out.println("Đăng ký password: ");
            newPassword = input.nextLine();
            System.out.println("Password: " + newPassword);

            if (checkDuplicateUsers(newUserName)) {
                System.out.println("Tên đăng nhập đã tồn tại. Vui lòng đăng ký ID khác");
            } else {
                UsersInfo.add(new Users(newUserName,newPassword));
                System.out.println("Bạn đã đăng ký thành công. Chuyển tới phần đăng nhập");
                Login();
            }
        } while (checkDuplicateUsers(newUserName));
        }


    public static void Login() {
            String RegisteredID;
            String RegisteredPassword;
        do {
            System.out.println("Hãy nhập tên đăng nhập:");
            RegisteredID = input.nextLine();
            System.out.println("Hãy nhập mật khẩu:");
            RegisteredPassword = input.nextLine();
            if (checkDuplicatePassword(RegisteredPassword) && checkDuplicateUsers(RegisteredID)) {
                System.out.println("Chào mừng bạn quay lại");
                ProductService.CategoryProduct();

            } else if (!checkDuplicatePassword(RegisteredPassword)) {
                System.out.println("Mật khẩu sai, vui lòng nhập lại");
            } else {
                System.out.println("Ban chưa đăng ký tài khoản");
            }
        } while (!checkDuplicatePassword(RegisteredPassword) || !checkDuplicateUsers(RegisteredID));

    }
    public static void accountFunction() {
        System.out.println("Vui lòng Đăng nhập. Bạn chưa có tài khoản? Hãy đăng ký ngay");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                Login();
                break;
            case 2:
                Register();
                break;
        }
    }
}
