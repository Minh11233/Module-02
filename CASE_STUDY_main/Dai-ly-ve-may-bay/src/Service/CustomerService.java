package Service;

import Entity.Users.Customer;
import Utils.ReadFiles;
import Utils.WriteFiles;
import Utils.Validate;
import View.LoginView;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CustomerService extends UserService {
    private final Scanner input = new Scanner(System.in);
    public String RegisteredUserName;
    private String RegisteredPassword;
    private String newUserName;
    private String newPassword;
    public static final CustomerService customerAccount = new CustomerService();
    private CustomerService() {}
    public static CustomerService getInstance() {
        return customerAccount;
    }
    public List<Customer> customerAccountsList;

    static {
        customerAccount.customerAccountsList = ReadFiles.readCustomerAccountsData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\CustomerAccount.csv");
    }

    public void customerAbility() {
        System.out.println("Chào mừng bạn " + RegisteredUserName + " quay lại \uD83D\uDE0D. Bạn muốn làm gì?");
        System.out.println("1. Đặt chuyến bay");
        System.out.println("2. Xem thông tin cá nhân");
        System.out.println("3. Đổi mật khẩu");
        System.out.println("4. Đăng xuất");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                FlightService.selectDepart();
                break;
            case 2:
                changeUserInfoService();
                break;
            case 3:
                changePassword();
                break;
            default:
                LoginView.LoginView();
        }
    }

    public boolean checkDuplicateUsers(String userName) {
        for (Customer member: customerAccountsList) {
            if (Objects.equals(member.getAccount(), userName)) {
                return true;
            }
        } return false;
    }
    public boolean checkDuplicatePassword(String password) {
        for (Customer member: customerAccountsList) {
            if (Objects.equals(member.getPassWord(), password)) {
                return true;
            }
        } return false;
    }

    public void changePassword() {
        int CUSTOMER_ACCOUNT_LIST_LENGTH = customerAccountsList.size();
        WriteFiles.writeDataToFile("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\CustomerAccount.csv","TÀI KHOẢN;MẬT KHẨU\n");
        for (int i = 0; i < CUSTOMER_ACCOUNT_LIST_LENGTH; i++) {
            String CURRENT_LOGIN_USER = customerAccountsList.get(i).getAccount();
            if (Objects.equals(RegisteredUserName, CURRENT_LOGIN_USER)) {
                String newPassword = prompt("Nhập mật khẩu mới");
                String checkPassword = prompt("Nhập lại mật khẩu");
                if (Objects.equals(newPassword, checkPassword)) {
                    // gắn mật khẩu mới vào đối tượng
                    customerAccountsList.get(i).setPassWord(newPassword);
                    System.out.println("Đổi mật khẩu thành công.\nQuay về màn hình chọn...");

                } else {
                    System.out.println("Mật khẩu bạn nhập chưa trùng nhau. Hãy nhập lại");
                    changePassword();
                }
            }
            WriteFiles.writeDataToFileWithAppend("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\CustomerAccount.csv",customerAccount.customerAccountsList.get(i).writeToFile() + "\n");
            customerAccountsList = ReadFiles.readCustomerAccountsData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\CustomerAccount.csv");
        }
        customerAbility();
    }
    public void updateUserInfoService() {
        System.out.println("----------------\nHoàn tất sửa thông tin\nQuay trở lại màn hình chọn");
        WriteFiles.writeDataToFile("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\UsersInfo.csv", "HỌ VÀ TÊN;NGÀY SINH;GIỚI TÍNH;SỐ ĐIỆN THOẠI;EMAIL;ĐỊA CHỈ\n");
        for (int j = 0; j < UsersInfoService.usersInfo.size(); j++) {
            WriteFiles.writeDataToFileWithAppend("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\UsersInfo.csv", UsersInfoService.usersInfo.get(j).writeToFile() + "\n");
        }
        UsersInfoService.usersInfo = ReadFiles.readUsersInfoData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\UsersInfo.csv");
        customerAbility();
    }
    public void changeUserInfoService() {
        for (int i = 0; i < customerAccountsList.size(); i++) {
            String accountName = customerAccountsList.get(i).getAccount();
            if (Objects.equals(RegisteredUserName, accountName)) {
                System.out.println(UsersInfoService.usersInfo.get(i));
                System.out.println("Bạn muốn sửa:");
                System.out.println("1. Họ và tên");
                System.out.println("2. Giới tính");
                System.out.println("3. Năm sinh");
                System.out.println("4. Email");
                System.out.println("5. Số điện thoại");
                System.out.println("6. Điạ chỉ");
                System.out.println("7. Quay lại");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        String newName = prompt("Nhập tên:");
                        UsersInfoService.usersInfo.get(i).setName(newName);
                        System.out.println(UsersInfoService.usersInfo.get(i));
                        updateUserInfoService();
                        break;
                    case 2:
                        String newGeder = prompt("Nhập giới tính:");
                        UsersInfoService.usersInfo.get(i).setGender(newGeder);
                        System.out.println(UsersInfoService.usersInfo.get(i));
                        updateUserInfoService();
                    case 3:
                        String newDayOfBirth = prompt("Nhập ngày sinh:");
                        UsersInfoService.usersInfo.get(i).setDayOfBirth(newDayOfBirth);
                        System.out.println(UsersInfoService.usersInfo.get(i));
                        updateUserInfoService();
                        break;
                    case 4:
                        String newEmail = prompt("Nhập email:");
                        if (Validate.validate(newEmail,"EMAIL")) {
                            UsersInfoService.usersInfo.get(i).setEmail(newEmail);
                            System.out.println(UsersInfoService.usersInfo.get(i));
                            updateUserInfoService();
                            break;
                        } else {
                            System.err.println("Invalid Input!!! Please Retry");
                            changeUserInfoService();
                        }
                    case 5:
                        String newPhoneNumber = prompt("Nhập số điện thoại:");
                        if (Validate.validate(newPhoneNumber,"PHONE_NUMBER")) {
                            UsersInfoService.usersInfo.get(i).setPhoneNumber(newPhoneNumber);
                            System.out.println(UsersInfoService.usersInfo.get(i));
                            updateUserInfoService();
                            break;
                        } else {
                            System.err.println("Invalid Input!!! Please Retry");
                            changeUserInfoService();
                        }

                    case 6:
                        String newAddress = prompt("Nhập địa chỉ:");
                        UsersInfoService.usersInfo.get(i).setAddress(newAddress);
                        System.out.println(UsersInfoService.usersInfo.get(i));
                        updateUserInfoService();
                        break;
                    case 7:
                        changeUserInfoService();
                        break;
                }
            }
        }
    }

    @Override
    public void register() {
        do {
            newUserName = prompt("Đăng ký tên đăng nhập:");
            newPassword = prompt("Đăng ký password: ");
            String newAccount = "\n" + newUserName + ";" + newPassword;
            if (checkDuplicateUsers(newUserName)) {
                System.out.println("Tên đăng nhập đã tồn tại. Vui lòng đăng ký ID khác");
            } else {
                customerAccountsList.add(new Customer(newUserName,newPassword));
                WriteFiles.writeDataToFileWithAppend("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\CustomerAccount.csv",newAccount);
                customerAccountsList = ReadFiles.readCustomerAccountsData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\CustomerAccount.csv");
                System.out.println("Bạn đã đăng ký thành công. Chuyển tới màn hình đăng nhập...");
                login();
            }
        } while (checkDuplicateUsers(newUserName));
    }
    @Override
    public void login() {
        do {
            RegisteredUserName = prompt("Hãy nhập tên đăng nhập:");
            RegisteredPassword = prompt("Hãy nhập mật khẩu:");
            if (checkDuplicatePassword(RegisteredPassword) && checkDuplicateUsers(RegisteredUserName)) {
                customerAbility();
            } else if (!checkDuplicatePassword(RegisteredPassword)) {
                System.out.println("Mật khẩu sai, vui lòng nhập lại");
            } else {
                accountFunction();
            }
        } while (!checkDuplicatePassword(RegisteredPassword) || !checkDuplicateUsers(RegisteredUserName));
    }
    @Override
    public void accountFunction() {
        System.out.println("Bạn chưa có tài khoản? Hãy đăng ký ngay");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("3. Xem chuyến bay");
        System.out.println("4. Quay lại");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                System.err.println("Vui lòng đăng nhập để sử dụng chức năng này!!!");
                accountFunction();
            case 4:
                LoginView.LoginView();
            default:
                System.err.println("Invalid Input!!! Please try again");
                accountFunction();
        }
    }
}
