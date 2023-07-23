package Service;

import Entity.Order;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private static final List<Order> ORDERS;

    static {
        ORDERS = new ArrayList<>();
        ORDERS.add(new Order("Thái", "Sịp lọt khe",20000, 2, 1));
        ORDERS.add(new Order("Lâm", "Lăn nách",25000, 2, 2));
        ORDERS.add(new Order("Phước", "Thuốc lá",15000, 1, 3));
        ORDERS.add(new Order("Hưởng", "Kẹo ke",200000, 5, 4));
    }

    public static void addOrder() throws IOException {
        String customerName = prompt("Nhập tên Khách hàng: ");
        String productName = prompt("Nhập tên Sản phẩm: ");
        int price = Integer.parseInt(prompt("Nhập đơn giá: "));
        int quantity = Integer.parseInt(prompt("Nhập số lượng: "));
        int Date = Integer.parseInt(prompt("Nhập ngày: "));
        Order order = new Order(customerName,productName,price,quantity,Date);
        ORDERS.add(order);
        displayOrder();

    }

    public static void displayOrder() throws IOException {
        while (true) {
            ORDERS.forEach(System.out::println);
            System.out.println("Bạn muốn làm gì?");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. In hoá đơn");
            int choice = Integer.parseInt(prompt("Nhập lựa chọn của bạn"));
            switch(choice) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    printOrder();
                    break;
            }
        }
    }

    public static <ORDERS> void printOrder() throws IOException {
        StringBuilder line = new StringBuilder();
        ArrayList<String> sentence = new ArrayList<>();

        int buyDate = Integer.parseInt(prompt("Nhập ngày mua:"));
        for (Order order : ORDERS) {
            if (buyDate == order.getDate()) {
                line.append(order);
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("Invoice.txt",true));
        writer.write(line.toString());
        writer.close();
    }

    public static String prompt(String request) {
        Scanner input = new Scanner(System.in);
        System.out.println(request);
        return input.nextLine();
    }

}
