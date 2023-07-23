import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nhập số lượng số nguyên tố bạn muốn:");
        Scanner input = new Scanner(System.in);
        int numbersOfPrime = input.nextInt();
        int count = 0;
        int number = 0;
        String result = "";
        while (count < numbersOfPrime) {
            if (isPrime(number)) {
                result += Integer.toString(number) + ",";
                count++;
            }
            number++;
        }
        System.out.print(result);
    }

    public static boolean isPrime (int num) {
        if (num < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0)
                    return false;
            }
            return true;
        }
    }
}