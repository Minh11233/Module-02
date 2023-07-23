package Service;

import Entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {

    private static final List<Product> categoryID01;
    static {
        categoryID01 = new ArrayList<>();
        categoryID01.add(new Product("Áo Sơ mi Nam",55000));
        categoryID01.add(new Product("Áo Khoác Nam",65000));
        categoryID01.add(new Product("Quần Dài Nam",100000));
        categoryID01.add(new Product("Quần xịp Nam",15000));
    }
    private static final List<Product> categoryID02;
    static {
        categoryID02 = new ArrayList<>();
        categoryID02.add(new Product("Ốp Điện thoại",12000));
        categoryID02.add(new Product("Que chọc sim",1000));
        categoryID02.add(new Product("Dây sạc nhanh",25000));
        categoryID02.add(new Product("Miếng dán cường lực",45000));
    }

    private static final List<Product> categoryID03;
    static {
        categoryID03 = new ArrayList<>();
        categoryID03.add(new Product("Tai nghe Xiaomi",99000));
        categoryID03.add(new Product("Giá đỡ điện thoại",48000));
        categoryID03.add(new Product("Tai nghe Bluetooth",199000));
        categoryID03.add(new Product("Tây cầm chơi game",45000));
    }

    private static final List<Product> categoryID04;
    static {
        categoryID04 = new ArrayList<>();
        categoryID04.add(new Product("Rolex",12000));
        categoryID04.add(new Product("Đồng hồ đôi",1000));
        categoryID04.add(new Product("Đồng hồ Sanda",25000));
        categoryID04.add(new Product("Đồng hồ Casio",45000));
    }

    public static void displayProductInCategoryID1() {
        categoryID01.forEach(System.out::println);
    }

    public static void displayProductInCategoryID2() {
        categoryID02.forEach(System.out::println);
    }

    public static void displayProductInCategoryID3() {
        categoryID03.forEach(System.out::println);
    }

    public static void displayProductInCategoryID4() {
        categoryID04.forEach(System.out::println);
    }

    public static void CategoryProduct() {
        CategoryService.displayAllCategory();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập category ID: ");
        int CategoryID = input.nextInt();
        switch (CategoryID) {
            case 1:
                displayProductInCategoryID1();
                break;
            case 2:
                displayProductInCategoryID2();
                break;
            case 3:
                displayProductInCategoryID3();
                break;
            case 4:
                displayProductInCategoryID4();
        }
    }


}
