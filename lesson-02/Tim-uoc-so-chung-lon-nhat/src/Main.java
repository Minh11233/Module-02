import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số a");
        a = input.nextInt();
        System.out.println("Nhập số b");
        b = input.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0) {
            System.out.println("No greatest common factor");
        } else {
            int temp;
            while (b != 0) {
                temp = a % b; //3
                a = b; // 9
                b = temp; // 3
            }
            System.out.println("Ước số chung lớn nhất của 2 số là " + a);
        }
    }
}