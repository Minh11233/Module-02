public class Main {
    public static void main(String[] args) {
        int number;
        int count = 0;
        String result = "";
        for (number = 2; number <= 100; number++) {
            if (isPrime(number)) {
                result += Integer.toString(number) + ",";
                count++;
            }
        }
        System.out.print("Các số nguyên tố nhỏ hơn 100 là: " + result);
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