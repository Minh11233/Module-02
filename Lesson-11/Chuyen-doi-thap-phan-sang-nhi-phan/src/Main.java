import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> binaryNumber = new Stack<>();
        Scanner input = new Scanner(System.in);
        String binaryNumberString = "";
        System.out.println("Nhập một số thập phân bất kì: ");
        int Decimal = input.nextInt();
        while (Decimal != 0) {
            int binaryNumberUnit = Decimal % 2;
            Decimal = Decimal / 2;
            binaryNumber.add(binaryNumberUnit);
        }

        while(!binaryNumber.isEmpty()) {
            binaryNumberString += binaryNumber.pop();
        }

        System.out.println(binaryNumberString);

    }
}