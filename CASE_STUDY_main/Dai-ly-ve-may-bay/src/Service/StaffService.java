package Service;

import Entity.Others.Revenue;
import Entity.Users.Staff;
import Utils.NlpUtils;
import Utils.ReadFiles;
import Utils.WriteFiles;
import Utils.Validate;
import View.LoginView;

import java.text.SimpleDateFormat;
import java.util.*;

public class StaffService extends UserService {
    private String RegisteredUserName;
   private String RegisteredPassword;
    private String newUserName;
    private String newPassword;
    private final static double PROFIT_RATE = 0.13;

    private final Scanner input = new Scanner(System.in);
    private static final StaffService staffAccount = new StaffService();

    private StaffService() {
    }
    final int CUSTOMER_INFO_LIST_LENGTH = UsersInfoService.usersInfo.size();
    public static StaffService getInstance() {
        return staffAccount;
    }
    private static List<Staff> staffAccountsList;
    private static int inputYear;
    private static List<Revenue> revenues;

    static {
        StaffService.staffAccountsList = ReadFiles.readStaffAccountsData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\StaffAccount.csv");
    }

    public void staffAbility() throws Exception {
        System.out.println("Chào mừng bạn quay lại. Bạn muốn làm gì?");
        System.out.println("1. Tìm kiếm thông tin khách hàng ");
        System.out.println("2. Thêm xoá giờ bay");
        System.out.println("3. Book vé cho khách hàng");
        System.out.println("4. Xem doanh thu, lợi nhuận");
        System.out.println("5. Đổi mật khẩu");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                findCustomerInfo();
                break;
            case 2:
                editFlightTime();
                break;
            case 3:
                FlightService.selectDepart();
                break;
            case 4:
                reviewRevenueAndProfitByYear();
                break;
            case 5:
                changePassword();
                break;
        }
    }

    private void findCustomerInfo() throws Exception {
        System.out.println("Tìm kiếm theo:");
        System.out.println("1. Tên khách hàng:");
        System.out.println("2. ID khách hàng");
        System.out.println("3. Quay lại");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                findCustomerInfoByName();
                break;
            case 2:
                findCustomerInfoByID();
                break;
            case 3:
                staffAbility();
                break;
        }
    }

    private void findCustomerInfoByID() throws Exception {
        int CustomerID = Integer.parseInt(prompt("Nhập ID khách hàng"));
        for (int i = 0; i < CUSTOMER_INFO_LIST_LENGTH; i++) {
            int availableCustomerID = UsersInfoService.usersInfo.get(i).getUserID();
            if (CustomerID == availableCustomerID) {
                String CustomerInfo = UsersInfoService.usersInfo.get(i).toString();
                System.out.println("TÌM KIẾM HOÀN TẤT!!!");
                System.out.println(CustomerInfo);
                findCustomerInfo();
            }
        }
        System.err.println("ID bạn vừa nhập không có trong kho khách hàng.\nVui lòng nhập lại hoặc thử tìm kiếm theo tên!!!");
        findCustomerInfo();
    }
    private void findCustomerInfoByName() throws Exception {
        String customerName = prompt("Nhập họ và tên khách hàng");
        for (int i = 0; i < CUSTOMER_INFO_LIST_LENGTH; i++) {
            String customerNameWithoutAccent = NlpUtils.removeAccent(customerName);
            String customerNameInListWithoutAccent = NlpUtils.removeAccent(UsersInfoService.usersInfo.get(i).getName());
            if (customerNameWithoutAccent.equalsIgnoreCase(customerNameInListWithoutAccent)) {
                String CustomerInfo = UsersInfoService.usersInfo.get(i).toString();
                System.out.println("TÌM KIẾM HOÀN TẤT!!!");
                System.out.println(CustomerInfo);
                findCustomerInfo();
            }
        }
        System.out.println("THÔNG TIN KHÁCH HÀNG KHÔNG CÓ TRONG DỮ LIỆU");
        findCustomerInfo();
    }

    private void reviewRevenueAndProfitByYear() throws Exception {
        inputYear = Integer.parseInt(prompt("Nhập năm muốn xem doanh thu:"));
        if (inputYear < 2021) {
            System.out.println("Năm " + inputYear + " công ty chưa thành lập!!!" );
            reviewRevenueAndProfitByYear();
        } else if (inputYear > 2025) {
            System.out.println("Hợp đồng phần mềm hết hạn năm 2025!!!");
            reviewRevenueAndProfitByYear();
        } else if (inputYear == 2021) {
            revenues = ReadFiles.readRevenuesData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\Revenue\\Revenue2021.csv");
            reviewRevenueAndProfit();
        } else if (inputYear == 2022) {
            revenues = ReadFiles.readRevenuesData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\Revenue\\Revenue2022.csv");
            reviewRevenueAndProfit();
        } else if (inputYear == 2023) {
            revenues = ReadFiles.readRevenuesData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\Revenue\\Revenue.csv");
            reviewRevenueAndProfit();
        } else if (inputYear == 2024) {
            revenues = ReadFiles.readRevenuesData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\Revenue\\Revenue2024.csv");
            if (revenues.isEmpty()) {
                System.out.println("Năm " + inputYear + " chưa phát sinh doanh thu");
                reviewRevenueAndProfitByYear();
            } else {
                reviewRevenueAndProfit();
            }
        } else if (inputYear == 2025) {
            revenues = ReadFiles.readRevenuesData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\Revenue\\Revenue2025.csv");
            if (revenues.isEmpty()) {
                System.out.println("Năm " + inputYear + " chưa phát sinh doanh thu");
                reviewRevenueAndProfitByYear();
            } else {
                reviewRevenueAndProfit();
            }
        }
    }

    private void reviewRevenueAndProfit() throws Exception {
        System.out.println("Hãy nhập lựa chọn của bạn");
        System.out.println("1. Xem doanh thu, lợi nhuận theo tháng");
        System.out.println("2. Xem tổng doanh thu, lợi nhuận");
        System.out.println("3. Quay lại");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                checkRevenueAndProfitByMonth();
                break;
            case 2:
                checkTotalRevenueAndProfit();
                break;
            case 3:
                reviewRevenueAndProfitByYear();
                break;
        }
    }

    private void checkTotalRevenueAndProfit() throws Exception {
        int TotalRevenue = 0;
        for (int i = 0; i < revenues.size(); i++) {
            int subTotalRevenue = Integer.parseInt(revenues.get(i).getIncome());
            TotalRevenue += subTotalRevenue;
        }
        System.out.println("Doanh thu năm " + inputYear + "là: " +  + TotalRevenue + " VNĐ");
        System.out.println("Lợi nhuận năm " + inputYear + "là: " + TotalRevenue * PROFIT_RATE + " VNĐ");
        reviewRevenueAndProfit();
    }

    private void checkRevenueAndProfitByMonth() throws Exception {
        int TotalRevenue = 0;
        int Last_Month_With_Revenue = new SimpleDateFormat("dd/MM/yyyy").parse(revenues.get(revenues.size()-1).getBuyDate()).getMonth() + 1;
        int month = 0;
        int inputMonth = Integer.parseInt(prompt("Lựa chọn tháng muốn in doanh thu"));
        boolean isMonth = inputMonth > 0 && inputMonth < 13;
        if (isMonth) {
            boolean isRevenueAvalabie = Last_Month_With_Revenue >= inputMonth;
            if (isRevenueAvalabie) {
                for (int i = 0; i < revenues.size(); i++) {
                    Date buyDate = new SimpleDateFormat("dd/MM/yyyy").parse(revenues.get(i).getBuyDate());
                    month = buyDate.getMonth() + 1;
                    if (inputMonth > month) {
                        continue;
                    } else if (inputMonth == month) {
                        int subTotalRevenue = Integer.parseInt(revenues.get(i).getIncome());
                        TotalRevenue += subTotalRevenue;
                    }
                }
                System.out.println("Doanh thu tháng " + inputMonth + "/" + inputYear + " là: " + TotalRevenue + " VNĐ");
                System.out.println("Lợi nhuận tháng " + inputMonth + "/" + inputYear + " là: " + TotalRevenue * PROFIT_RATE + " VNĐ");
                reviewRevenueAndProfit();
            } else {
                System.out.println("Tháng " + inputMonth + " chưa cập nhật doanh thu. Vui lòng thử lại");
                checkRevenueAndProfitByMonth();
            }

        } else {
            System.err.println("Invalid input!!! Please try again");
            checkRevenueAndProfitByMonth();
        }


    }

    public void editFlightTime() throws Exception {
        System.out.println("1. Thêm thời gian bay");
        System.out.println("2. Xoá thời gian bay");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                addFlightTime();
                break;
            case 2:
                removeFlightHour();
                break;
        }
    }

    public void addFlightTime() throws Exception {
        System.out.println("Giờ bay hiện hữu: ");
        System.out.println(FlightService.flightHourList);
        String newFlightHour = prompt("Nhập mốc thời gian bạn muốn thêm");
        if (Validate.validate(newFlightHour, "FLIGHT_TIME")) {
            FlightService.flightHourList.add(newFlightHour);
            // Sort flight time
            FlightService.flightHourList.sort(Comparator.comparing(String::toString));
            System.out.println("Giờ bay đã được thêm thành công");
            int FLIGHT_HOUR_LIST = FlightService.flightHourList.size();
            WriteFiles.writeDataToFile("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\FlightTime.csv", "");
            for (int i = 0; i < FLIGHT_HOUR_LIST; i++) {
                WriteFiles.writeDataToFileWithAppend("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\FlightTime.csv", FlightService.flightHourList.get(i) + "\n");
            }
            FlightService.flightHourList = ReadFiles.readDataFromFile("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\FlightTime.csv");
            System.out.println(FlightService.flightHourList);
            System.out.println("Đang quay trở về màn hình chính...");
            staffAbility();
        } else {
            System.err.println("Invalid Input. Please re-enter");
            addFlightTime();
        }

    }

    public void removeFlightHour() throws Exception {
        System.out.println("Giờ bay hiện hữu: ");
        System.out.println(FlightService.flightHourList);
        String flightHourRemoval = prompt("Nhập mốc thời gian bạn muốn xoá");
        if (Validate.validate(flightHourRemoval, "FLIGHT_TIME")) {
            if (FlightService.flightHourList.contains(flightHourRemoval)) {
                System.out.println(FlightService.flightHourList);
                FlightService.flightHourList.remove(flightHourRemoval);
                System.out.println("Giờ bay đã được xoá thành công");
                int FLIGHT_HOUR_LIST_LENGTH = FlightService.flightHourList.size();
                WriteFiles.writeDataToFile("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\FlightTime.csv", "");
                for (int i = 0; i < FLIGHT_HOUR_LIST_LENGTH; i++) {
                    WriteFiles.writeDataToFileWithAppend("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\FlightTime.csv", FlightService.flightHourList.get(i) + "\n");
                }
                FlightService.flightHourList = ReadFiles.readDataFromFile("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\FlightTime.csv");
                System.out.println(FlightService.flightHourList);
                System.out.println("Đang quay trở về màn hình chính...");
                staffAbility();
            } else {
                System.out.println("Giờ bay không có trong hệ thống. Vui lòng nhập lại");
                removeFlightHour();
            }
        } else {
            System.err.println("Invalid Input. Please re-enter");
            removeFlightHour();
        }
    }

    public boolean checkDuplicateUsers(String userName) {
        for (Staff member : staffAccountsList) {
            if (Objects.equals(member.getAccount(), userName)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplicatePassword(String password) {
        for (Staff member : staffAccountsList) {
            if (Objects.equals(member.getPassWord(), password)) {
                return true;
            }
        }
        return false;
    }

    public void changePassword() throws Exception {
        int STAFF_ACCOUNT_LIST_LENGTH = staffAccountsList.size();
        WriteFiles.writeDataToFile("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\StaffAccount.csv", "TÀI KHOẢN;MẬT KHẨU\n");
        for (int i = 0; i < STAFF_ACCOUNT_LIST_LENGTH; i++) {
            String CURRENT_LOGIN_USER = staffAccountsList.get(i).getAccount();
            if (Objects.equals(RegisteredUserName, CURRENT_LOGIN_USER)) {
                String newPassword = prompt("Nhập mật khẩu mới");
                String checkPassword = prompt("Nhập lại mật khẩu");
                if (Objects.equals(newPassword, checkPassword)) {
                    // gắn mật khẩu mới vào đối tượng
                    staffAccountsList.get(i).setPassWord(newPassword);
                    System.out.println("Đổi mật khẩu thành công.\nQuay về màn hình chọn...");

                } else {
                    System.out.println("Mật khẩu bạn nhập chưa trùng nhau. Hãy nhập lại");
                    changePassword();
                }
            }
            WriteFiles.writeDataToFileWithAppend("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\StaffAccount.csv", StaffService.staffAccountsList.get(i).writeToFile() + "\n");
            staffAccountsList = ReadFiles.readStaffAccountsData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\StaffAccount.csv");
        }
        staffAbility();
    }

    @Override
    public void register() throws Exception {
        do {
            newUserName = prompt("Đăng ký tên đăng nhập");
            System.out.println("Tên đăng nhập của bạn là: " + newUserName);
            newPassword = prompt("Đăng ký password: ");
            System.out.println("Password: " + newPassword);

            if (checkDuplicateUsers(newUserName)) {
                System.out.println("Tên đăng nhập đã tồn tại. Vui lòng đăng ký ID khác");
            } else {
                staffAccountsList.add(new Staff(newUserName, newPassword));
                int STAFF_ACCOUNT_LIST_LENGTH = staffAccountsList.size();
                System.out.println("Bạn đã đăng ký thành công. Chuyển tới màn hình đăng nhập...");
                WriteFiles.writeDataToFile("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\StaffAccount.csv", "TÀI KHOẢN;MẬT KHẨU\n");
                for (int i = 0; i < STAFF_ACCOUNT_LIST_LENGTH; i++) {
                    WriteFiles.writeDataToFileWithAppend("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\StaffAccount.csv", StaffService.staffAccountsList.get(i).writeToFile() + "\n");
                    staffAccountsList = ReadFiles.readStaffAccountsData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\StaffAccount.csv");
                }
                login();
            }
        } while (checkDuplicateUsers(newUserName));
    }

    @Override
    public void login() throws Exception {

        do {
            RegisteredUserName = prompt("Hãy nhập tên đăng nhập:");
            RegisteredPassword = prompt("Hãy nhập mật khẩu:");
            if (checkDuplicatePassword(RegisteredPassword) && checkDuplicateUsers(RegisteredUserName)) {
                staffAbility();
            } else if (!checkDuplicatePassword(RegisteredPassword)) {
                System.out.println("Mật khẩu sai, vui lòng nhập lại");
            } else {
                accountFunction();
            }
        } while (!checkDuplicatePassword(RegisteredPassword) || !checkDuplicateUsers(RegisteredUserName));
    }

    @Override
    public void accountFunction() throws Exception {
        System.out.println("Vui lòng Đăng nhập. Bạn chưa có tài khoản? Hãy đăng ký ngay");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("3. Quay lại");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                LoginView.LoginView();
            default:
                accountFunction();
        }
    }
}
