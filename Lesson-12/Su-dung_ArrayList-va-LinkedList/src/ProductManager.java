import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class ProductManager {

    private static ArrayList<Product> productsList = new ArrayList<>();
    static {
        productsList.add(new Product("Áo", 250000));
        productsList.add(new Product("Quần", 200000));
        productsList.add(new Product("Mũ", 120000));
        productsList.add(new Product( "Giày", 2000000));
    }

    private static Scanner input = new Scanner(System.in);
    public static void displayAllProduct() {
        System.out.println("Danh sách sản phẩm bao gồm:");
        System.out.println(productsList);
        System.out.println("Bạn muốn thao tác gì?");
        System.out.println("1. Sửa sản phẩm");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Xoá sản phẩm");
        System.out.println("4. Sắp xếp sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm thông qua tên");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                editProduct();
                break;
            case 2:
                addProduct();
                break;
            case 3:
                deleteProduct();;
                break;
            case 4:
                sortProduct();
                break;
            case 5:
                findProduct();
                break;
        }
    }

    public static void editProduct() {
        int productID = Integer.parseInt(prompt("Nhập ID phần tử bạn muốn sửa"));
        for (int i = 0; i < productsList.size(); i++) {
            if (i == (productID-1)) {
                Scanner input = new Scanner(System.in);
                System.out.println("Bạn muốn sửa gì?");
                System.out.println("1. Tên sản phẩm");
                System.out.println("2. Giá tiền");
                int choice = Integer.parseInt(input.nextLine());
                Product product = productsList.get(i);
                switch (choice) {
                    case 1:
                        System.out.println("Nhập tên: ");
                        String name = input.nextLine();
                        product.setName(name);
                        System.out.println(productsList);
                        break;
                    case 2:
                        System.out.println("Nhập giá tiền: ");
                        int price = input.nextInt();
                        Product productID1 = productsList.get(i);
                        productID1.setPrice(price);
                        System.out.println(productsList);
                        break;
                }
            }
        }
    }

    public static void addProduct() {
        System.out.println("Thêm sản phẩm bạn muốn add");
        System.out.println("Tên sản phẩm");
        String productName = input.nextLine();
        System.out.println("Giá tiền");
        int productPrice = input.nextInt();
        productsList.add(new Product(productName,productPrice));
        System.out.println(productsList);
    }

    public static void deleteProduct() {
        int deleteID = Integer.parseInt(prompt("Nhập ID phần tử bạn muốn xoá"));
        for (int i = 0; i < productsList.size(); i++) {
            if ((deleteID - 1) == i) {
                productsList.remove(i);
                System.out.println(productsList);
            }
        }
    }

    public static void sortProduct() {
        System.out.println("Bạn muốn sắp xếp theo?");
        System.out.println("1. Giá từ thấp đến cao");
        System.out.println("2. Giá từ cao đến thấp");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                productsList.sort(Comparator.comparingInt(Product::getPrice));
                System.out.println(productsList);
                break;
            case 2:
                productsList.sort(Comparator.comparingInt(Product::getPrice).reversed());
                System.out.println(productsList);
                break;
        }
    }

    public static void findProduct() {

        System.out.println("Nhập tên sản phẩm bạn muốn tìm:");

        String findNameProduct = input.nextLine();

        for (Product product : productsList) {
            String productName = product.getName();
            if (productName.equals(findNameProduct)) {
                System.out.println(product);
                break;
            }
        }
    }

    public static String prompt(String request) {
        Scanner input = new Scanner(System.in);
        System.out.println(request);
        return input.nextLine();
    }
}
