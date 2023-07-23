package Service;

import Builder.FlightTicketBuilder;
import Builder.FlightTicketConcreteBuilder;
import Builder.UsersInfoBuilder;
import Builder.UsersInfoConcreteBuilder;
import Interface.*;
import Factory.FlightFactory;
import Utils.ReadFiles;
import Utils.WriteFiles;
import Utils.NlpUtils;
import View.LoginView;

import java.text.SimpleDateFormat;
import java.util.*;

public class FlightService {
    private final static Scanner input = new Scanner(System.in);
    private static FlightFactory flightFactory = new FlightFactory();
    private static IPlane planeType = null;
    private static IClass position = null;
    private static String time = null;
    private static ISeat seat = null;
    private static String departString = null;
    private static IDepart depart = null;
    private static IDest dest = null;
    private static String flightHour = null;
    private static int price = 0;
    private static String dateString = null;
    private static String customerInfo = null;
    private static String storedLoginCustomerAccount;
    private static FlightTicketBuilder flightTicketBuilder;
    private final static int CUSTOMER_ACCOUNT_LIST_LENGTH = CustomerService.customerAccount.customerAccountsList.size();
    private final static int USERS_INFO_LIST_LENGTH = UsersInfoService.usersInfo.size();
    private static String currentLoginUser;
    private static String flightInfo;
    private static int indexOfCustomerAccount;
    static List<String> flightHourList = ReadFiles.readDataFromFile("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\FlightTime.csv");
    static List<String> bookedTicket = ReadFiles.readDataFromFile("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\SoldTicket.csv");

    public static void selectDepart() {
        do {
            try {
                System.out.println("Chọn điểm khởi hành: ");
                System.out.println("1. Sài Gòn");
                System.out.println("2. Hà Nội");
                System.out.println("3. Nha Trang");
                System.out.println("4. Đà Nẵng");
                System.out.println("5. Quay lại");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        depart = flightFactory.getDepart("Sài Gòn");
                        departString = "Sài Gòn";
                        selectDest();
                        break;
                    case 2:
                        depart = flightFactory.getDepart("Hà Nội");
                        departString = "Hà Nội";
                        selectDest();
                        break;
                    case 3:
                        depart = flightFactory.getDepart("Nha Trang");
                        departString = "Nha Trang";
                        selectDest();
                        break;
                    case 4:
                        depart = flightFactory.getDepart("Đà Nẵng");
                        departString = "Đà Nẵng";
                        selectDest();
                        break;
                    case 5:
                        CustomerService.getInstance().accountFunction();
                        break;
                    default:
                        System.err.println("Invalid Input. Please re-enter your choice");
                }
            } catch (Exception e) {
                System.err.println("Invalid Input. Please re-enter your choice");
            }
        } while (true);

    }

    public static void selectDest() {
        do {
            try {
                System.out.println("Chọn đích đến: ");
                System.out.println("1. Sài Gòn");
                System.out.println("2. Hà Nội");
                System.out.println("3. Nha Trang");
                System.out.println("4. Đà Nẵng");
                System.out.println("5. Quay lại");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        dest = flightFactory.getDest("Sài Gòn");
                        if (departString.equals("Hà Nội")) {
                            flightHour = "02 tiếng 15 phút";
                        } else if (departString.equals("Nha Trang")) {
                            flightHour = "45 phút";
                        } else if (departString.equals("Đà Nẵng")) {
                            flightHour = "01 tiếng 20 phút";
                        } else {
                            System.err.println("Điểm khởi hành và đích đến không thể trùng nhau. Vui lòng chọn lại");
                            selectDepart();
                        }
                        selectDate();
                        break;
                    case 2:
                        dest = flightFactory.getDest("Hà Nội");
                        if (departString.equals("Sài Gòn")) {
                            flightHour = "02 tiếng 15 phút";
                        } else if (departString.equals("Nha Trang")) {
                            flightHour = "01 tiếng 50 phút";
                        } else if (departString.equals("Đà Nẵng")) {
                            flightHour = "01 tiếng 30 phút";
                        } else {
                            System.err.println("Điểm khởi hành và đích đến không thể trùng nhau. Vui lòng chọn lại");
                            selectDepart();
                        }
                        selectDate();
                        break;
                    case 3:
                        dest = flightFactory.getDest("Nha Trang");
                        if (departString.equals("Sài Gòn")) {
                            flightHour = "45 phút";
                        } else if (departString.equals("Hà Nội")) {
                            flightHour = "01 tiếng 50 phút";
                        } else if (departString.equals("Đà Nẵng")) {
                            flightHour = "01 tiếng 50 phút";
                        } else {
                            System.err.println("Điểm khởi hành và đích đến không thể trùng nhau. Vui lòng chọn lại");
                            selectDepart();
                        }
                        selectDate();
                        break;
                    case 4:
                        dest = flightFactory.getDest("Đà Nẵng");
                        if (departString.equals(("Sài Gòn"))) {
                            flightHour = "01 tiếng 20 phút";
                        } else if (departString.equals("Hà Nội")) {
                            flightHour = "01 tiếng 30 phút";
                        } else if (departString.equals("Nha Trang")) {
                            flightHour = "01 tiếng 50 phút";
                        } else {
                            System.err.println("Điểm khởi hành và đích đến không thể trùng nhau. Vui lòng chọn lại");
                            selectDepart();
                        }
                        selectDate();
                        break;
                    case 5:
                        selectDepart();
                        break;
                    default:
                        System.err.println("Invalid Input. Please re-enter your choice");
                }
            } catch (Exception e) {
                System.err.println("Invalid Input. Please re-enter your choice");
            }
        } while (true);
    }

    public static void selectDate() {
        List<String> dateList = new ArrayList<>();
        Date nextDay;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        final long MILLISECONDS_IN_1_DAY = 24 * 60 * 60 * 1000;
        final long MILLISECONDS_TODAY = date.getTime();
        System.out.println("Chọn ngày bay:");
        for (int i = 0; i < 7; i++) {
            long NEXT_DAY = MILLISECONDS_TODAY + MILLISECONDS_IN_1_DAY * i;
            nextDay = new Date(NEXT_DAY);
            StringBuilder line = new StringBuilder("");
            line.append(i + 1);
            line.append(". ");
            line.append(formatter.format(nextDay));
            dateList.add(formatter.format(nextDay));
            System.out.println(line);
        }
        System.out.println("8. Quay lại");
        int choice = Integer.parseInt(input.nextLine());
        for (int i = 0; i < 7; i++) {
            if (choice == i + 1) {
                dateString = dateList.get(i);
                selectFlightTime();
            }
        }
        selectDest();
    }

    public static void selectFlightTime() {
        System.out.println("Vui lòng chọn giờ bay");
        for (int i = 0; i < flightHourList.size(); i++) {
            StringBuilder line = new StringBuilder("");
            line.append(i + 1);
            line.append(". ");
            line.append(flightHourList.get(i));
            System.out.println(line);
        }
        System.out.println("7. Quay lại");
        int choice = Integer.parseInt(input.nextLine());
        for (int i = 0; i < flightHourList.size(); i++) {
            if (choice - 1 == i) {
                time = flightHourList.get(i);
                selectPlane();
            }
        }
        selectDate();

    }

    public static void selectPlane() {
        do {
            try {
                System.out.println("Chọn loại máy bay: ");
                System.out.println("1. AIRBUS A330");
                System.out.println("2. AIRBUS A350");
                System.out.println("3. BOEING 777");
                System.out.println("4. Quay lại");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        planeType = flightFactory.getType("AIRBUS A330");
                        selectClass();
                        break;
                    case 2:
                        planeType = flightFactory.getType("AIRBUS A350");
                        selectClass();
                        break;
                    case 3:
                        planeType = flightFactory.getType("BOEING 777");
                        selectClass();
                        break;
                    case 4:
                        selectFlightTime();
                        break;
                    default:
                        System.err.println("Invalid Input. Please re-enter your choice");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Invalid Input. Please re-enter your choice");
            }
        } while (true);

    }

    public static void selectClass() {
        do {
            try {
                System.out.println("Chọn hạng ghế");
                System.out.println("1. Hạng thương gia - Giá vé: 5,000,000 VNĐ");
                System.out.println("2. Hạng phổ thông - Giá vé: 1,000,000 VNĐ");
                System.out.println("3. Quay lại");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        position = flightFactory.getClass("Hạng thương gia");
                        price = 5000000;
                        selectLuxurySeat();
                        break;
                    case 2:
                        position = flightFactory.getClass("Hạng phổ thông");
                        price = 1000000;
                        selectEconomySeat();
                        break;
                    default:
                        System.err.println("Invalid Input. Please re-enter your choice");
                }
            } catch (Exception e) {
                System.err.println("Invalid Input. Please re-enter your choice");
            }
        } while (true);

    }

    public static void selectLuxurySeat() {
        String[] luxurySeat = {"[L-01]\t\t", "[L-02]\n\n"};
        do {
            try {
                System.out.println("Chọn chỗ ngồi:\n");
                for (int i = 0; i < 2; i++) {
                    System.out.print(luxurySeat[i]);
                }
                System.out.println("1. Ghế Luxury 01 ");
                System.out.println("2. Ghế Luxury 02 ");
                System.out.println("3. Quay lại");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        seat = flightFactory.getSeat("L-01");
                        printInfo();
                        break;
                    case 2:
                        seat = flightFactory.getSeat("L-02");
                        printInfo();
                        break;
                    case 3:
                        selectClass();
                        break;
                    default:
                        System.err.println("Invalid Input. Please re-enter your choice");
                }
            } catch (Exception e) {
                System.err.println("Invalid Input. Please re-enter your choice");
            }
        } while (true);

    }

    public static void selectEconomySeat() {
        String[][] economySeat = {{"[E-01]\t", "[E-02]"}, {"[E-03]\t", "[E-04]"}};
        do {
            try {
                System.out.println("Chọn chỗ ngồi:\n");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print(economySeat[i][j] + "\t");
                    }
                    System.out.println("\n");
                }
                System.out.println("1. Ghế Economy 01 ");
                System.out.println("2. Ghế Economy 02 ");
                System.out.println("3. Ghế Economy 03 ");
                System.out.println("4. Ghế Economy 04 ");
                System.out.println("5. Quay lại");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        seat = flightFactory.getSeat("E-01");
                        printInfo();
                        break;
                    case 2:
                        seat = flightFactory.getSeat("E-02");
                        printInfo();
                        break;
                    case 3:
                        seat = flightFactory.getSeat("E-03");
                        printInfo();
                        break;
                    case 4:
                        seat = flightFactory.getSeat("E-04");
                        printInfo();
                        break;
                    case 5:
                        selectClass();
                        break;
                }
            } catch (Exception e) {
                System.err.println("Invalid Input. Please re-enter your choice");
                e.printStackTrace();
            }
        } while (true);

    }

    private static void changePlaneTicketInfo() {
        System.out.println("Bạn muốn sửa:");
        System.out.println("1. Điạ điểm khởi hành");
        System.out.println("2. Đích đến");
        System.out.println("3. Ngày bay");
        System.out.println("4. Loại máy bay");
        System.out.println("5. Hạng ghế");
        System.out.println("6. Quay lại");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                selectDepart();
                break;
            case 2:
                selectDest();
                break;
            case 3:
                selectDate();
                break;
            case 4:
                selectPlane();
                break;
            case 5:
                selectClass();
                break;
            case 6:
                checkInfo();
                break;
        }

    }

    public static void printInvoice() {
        String FLIGHT_INFO = String.valueOf(flightTicketBuilder.build());
        WriteFiles.writeDataCustomersInfoToFile("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\Invoice.txt", customerInfo);
        WriteFiles.writeDataFlightInfoToFile("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\Invoice.txt", FLIGHT_INFO);
        WriteFiles.writeDataToFileWithAppend("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\Revenue2023.csv","\n" + flightTicketBuilder.build().writeToFile());
        System.out.println("CÁM ƠN ĐÃ SỬ DỤNG DỊCH VỤ CỦA CHÚNG TÔI!!!\nQuay trở về màn hình đăng nhập...");
        LoginView.LoginView();
    }

    public static void printInfo() {
        flightTicketBuilder = new FlightTicketConcreteBuilder()
                .setPosition(position.getPosition())
                .setPlane(planeType.getPlane())
                .setTime(time)
                .setSeat(seat.getSeat())
                .setDepart(depart.getDepart())
                .setDest(dest.getDest())
                .setFlightHour(flightHour)
                .setPrice(price)
                .setDate(dateString);
        String bookedTicketInList = flightTicketBuilder.build().toString();
        if (FlightService.bookedTicket.contains(bookedTicketInList)) {
            System.out.println("Chỗ ngồi này đã được đặt. Vui lòng chọn ghế khác \uD83D\uDC94");
            selectClass();
        } else {
            FlightService.bookedTicket.add(bookedTicketInList);
            WriteFiles.writeDataToFileWithAppend("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\SoldTicket.csv", bookedTicketInList);
        }
        currentLoginUser = CustomerService.getInstance().RegisteredUserName;
        flightInfo = String.valueOf(flightTicketBuilder.build());
        for (int i = 0; i < CUSTOMER_ACCOUNT_LIST_LENGTH; i++) {
            storedLoginCustomerAccount = CustomerService.customerAccount.customerAccountsList.get(i).getAccount();
            boolean isNewCustomerAccount = Objects.equals(currentLoginUser, storedLoginCustomerAccount) && USERS_INFO_LIST_LENGTH < CUSTOMER_ACCOUNT_LIST_LENGTH;
            boolean isOldCustomerAccount = Objects.equals(currentLoginUser, storedLoginCustomerAccount);
            if (isNewCustomerAccount) {
                loginByNewCustomerAccount();
            } else if (isOldCustomerAccount) {
                indexOfCustomerAccount = i;
                loginByOldCustomerAccount();
            } else if (isStaff()) {
                loginByStaffAccount();
            }
        }
    }
    public static void loginByOldCustomerAccount() {
        storedLoginCustomerAccount = CustomerService.customerAccount.customerAccountsList.get(indexOfCustomerAccount).getAccount();
        customerInfo = String.valueOf(UsersInfoService.usersInfo.get(indexOfCustomerAccount));
        System.out.println("VUI LÒNG KIỂM TRA KỸ THÔNG TIN!!!");
        System.out.println(customerInfo);
        System.out.println(flightInfo);
        checkInfo();
    }

    public static void loginByNewCustomerAccount() {
        System.out.println("Vui lòng nhập thông tin cá nhân để hoàn tất việc đặt vé");
        String name = prompt("Nhập Họ và Tên:");
        String dayOfBirth = prompt("Nhập ngày tháng năm sinh:");
        String gender = prompt("Nhập giới tính:");
        String phoneNumber = prompt("Nhập số điện thoại:");
        String email = prompt("Nhập email:");
        String address = prompt("Nhập địa chỉ:");
        UsersInfoBuilder usersInfoBuilder = new UsersInfoConcreteBuilder()
                .setName(name)
                .setDayOfBirth(dayOfBirth)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setAddress(address);
        customerInfo = usersInfoBuilder.build().toString();
        WriteFiles.writeDataToFile("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\UsersInfo.csv", "HỌ VÀ TÊN;NGÀY SINH;GIỚI TÍNH;SỐ ĐIỆN THOẠI;EMAIL;ĐỊA CHỈ\n");
        for (int j = 0; j < USERS_INFO_LIST_LENGTH; j++) {
            WriteFiles.writeDataToFileWithAppend("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\UsersInfo.csv", UsersInfoService.usersInfo.get(j).writeToFile() + "\n");
        }
        WriteFiles.writeDataToFileWithAppend("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\UsersInfo.csv", usersInfoBuilder.build().writeToFile());
        UsersInfoService.usersInfo = ReadFiles.readUsersInfoData("D:\\CODEGYM\\Module-2\\CASE_STUDY_Draft\\Dai-ly-ve-may-bay\\src\\Data\\UsersInfo.csv");
        System.out.println(usersInfoBuilder.build());
        System.out.println("VUI LÒNG KIỂM TRA KỸ THÔNG TIN!!!");
        System.out.println(customerInfo);
        System.out.println(flightInfo);
        checkInfo();
    }

    public static void loginByStaffAccount() {
        System.out.println("Vui lòng nhập thông tin khách hàng để hoàn tất việc đặt vé");
        String name = prompt("Nhập Họ và Tên:");
        String dayOfBirth = prompt("Nhập ngày tháng năm sinh:");
        String gender = prompt("Nhập giới tính:");
        String phoneNumber = prompt("Nhập số điện thoại:");
        String email = prompt("Nhập email:");
        String address = prompt("Nhập địa chỉ:");
        UsersInfoBuilder usersInfoBuilder = new UsersInfoConcreteBuilder()
                .setName(name)
                .setDayOfBirth(dayOfBirth)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setAddress(address);
        customerInfo = usersInfoBuilder.build().toString();
        System.out.println("VUI LÒNG KIỂM TRA KỸ THÔNG TIN!!!");
        System.out.println(customerInfo);
        System.out.println(flightInfo);
        checkInfo();
    }

    public static void checkInfo() {
        System.out.println("1. Sửa thông tin cá nhân");
        System.out.println("2. Sửa thông tin chuyến bay");
        System.out.println("3. Thông tin chính xác. Tiến hành in hoá đơn");

        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                CustomerService.getInstance().changeUserInfoService();
                break;
            case 2:
                changePlaneTicketInfo();
                break;
            case 3:
                printInvoice();
                break;
        }
    }

    public static String prompt(String request) {
        Scanner input = new Scanner(System.in);
        System.out.println(request);
        return input.nextLine();
    }

    public static boolean isStaff() {
        for (int i = 0; i < CUSTOMER_ACCOUNT_LIST_LENGTH; i++) {
            storedLoginCustomerAccount = CustomerService.customerAccount.customerAccountsList.get(i).getAccount();
            if (Objects.equals(currentLoginUser, storedLoginCustomerAccount)) {
                return false;
            }
        }
        return true;
    }

    public static void selectOption() {
        System.out.println("Bạn muốn :");
        System.out.println("1. Tìm kiếm điểm khởi hành");
        System.out.println("2. Tim kiếm đích đến");
        System.out.println("3. Tìm kiếm thời gian khởi hành phù hợp");
        System.out.println("4. Quay lại");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                findDepartLocation();
                break;
            case 2:
                findDestination();
                break;
            case 3:
                findSuitableTimeFlight();
                break;
            case 4:
                LoginView.LoginView();
                break;
        }
    }

    public static void findSuitableTimeFlight() {
        String flightTime = prompt("Nhập giờ bay");
        for (int i = 0; i < flightHourList.size(); i++) {
            if (flightHourList.contains(flightTime)) {
                System.out.println("Có chuyến bay xuất phát lúc: " + flightTime);
                selectNextAction();
            } else {
                System.out.println("Xin lỗi. Chúng tôi chưa hỗ trợ giờ bay này\nTuy nhiên bạn có thể tham khảo danh sách giờ bay bên dưới:");
                System.out.println(flightHourList.toString());
                selectNextAction();
            }
        }
    }

    public static void findDestination() {
        List<String> Destination = new ArrayList<>();
        Destination.add("Hà Nội");
        Destination.add("Sài Gòn");
        Destination.add("Đà Nẵng");
        Destination.add("Nha Trang");
        String Dest = prompt("Nhập đích đến:");
        for (int i = 0; i < Destination.size(); i++) {
            String destWithoutAccent = NlpUtils.removeAccent(Dest);
            String destInListWithoutAccent = NlpUtils.removeAccent(Destination.get(i));
            if (destWithoutAccent.equalsIgnoreCase(destInListWithoutAccent)) {
                System.out.println("Có sẵn nhiều chuyến bay đến " + Destination.get(i).toString());
                selectNextAction();
            }
        } System.out.println("Chúng tôi chưa hỗ trợ chuyến bay đến địa điểm này\nVui lòng chọn lại");
             selectOption();
    }

    public static void findDepartLocation() {
        List<String> DepartLocation = new ArrayList<>();
        DepartLocation.add("Hà Nội");
        DepartLocation.add("Sài Gòn");
        DepartLocation.add("Đà Nẵng");
        DepartLocation.add("Nha Trang");
        String Depart = prompt("Nhập điểm khởi hành:");
        for (int i = 0; i < DepartLocation.size(); i++) {
            String departWithoutAccent = NlpUtils.removeAccent(Depart);
            String departInListWithoutAccent = NlpUtils.removeAccent(DepartLocation.get(i));
            if (departWithoutAccent.equalsIgnoreCase(departInListWithoutAccent)) {
                System.out.println("Thời gian khởi hành từ " + DepartLocation.get(i).toString() + " là: ");
                System.out.println(flightHourList.toString());
                selectNextAction();
            }
        }
        System.out.println("Chúng tôi chưa hỗ trợ chuyến bay từ địa điểm này\nVui lòng chọn lại");
        selectOption();
    }

    public static void selectNextAction() {
        System.out.println("1. Tiến hành đặt vé");
        System.out.println("2. Quay lại");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                System.out.println("BẠN PHẢI ĐĂNG NHẬP ĐỂ THỰC HIỆN CHỨC NĂNG NÀY\nQuay lại màn hình đăng nhập...");
                LoginView.LoginView();
                break;
            case 2:
                selectOption();
                break;
        }
    }

}
