import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        System.out.print("Mời bạn nhập số tiền USD: ");
        Scanner sc = new Scanner(System.in);
        usd = sc.nextDouble();
        double quydoi = usd * 23000;
        System.out.print("Giá trị VND:" + quydoi);
    }
}