import javafx.scene.SubScene;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.print("Enter a number:");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        boolean check = true;
        if (number < 2) {
            check = false;
        } else {
            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                check = true;
            }
        }
        if (check) {
            System.out.print(number + " là số nguyên tố");
        } else {
            System.out.print(number + " không là số nguyên tố");
        }
    }
}