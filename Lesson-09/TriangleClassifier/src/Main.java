import java.util.Scanner;

public class Triagle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập cạnh a của tam giác");
        int a = input.nextInt();
        System.out.println("Nhập cạnh b của tam giác");
        int b = input.nextInt();
        System.out.println("Nhập cạnh c của tam giác");
        int c = input.nextInt();

        if (a == b && b == c) {
            System.out.println("Tam giác đều");
        } else if (a == b || b == c || a == c) {
            System.out.println("Tam giác cân");
        } else if (a + b > c && b + c > a && a + c > b) {
            System.out.println("Tam giác thường");
        } else {
            System.out.println("Không phải tam giác");
        }
    }
}