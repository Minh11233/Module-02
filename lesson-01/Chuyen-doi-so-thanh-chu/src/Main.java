import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inputNumber;
        System.out.println("Enter the 1 - 3 digits number:");
        do {
            inputNumber = input.nextInt();
            if (inputNumber < 0 || inputNumber > 999) {
                System.out.println("Please Re-enter the number:");
            }
        } while(inputNumber < 0 || inputNumber > 999);

        String[] ones = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

        //ví dụ số 2 chữ số: 35
        //ví dụ số 3 chữ số: 385 , 112

        int FirstDigit = inputNumber / 100; //0           // 3          //1
        int Tens = inputNumber % 100;  //35           // 85           // 12
        int SecondDigit = Tens / 10; // 3               // 8          // 1
        int ThirdDigit = Tens % 10;  // 5             // 5            // 2

        if (inputNumber < 20) {
            System.out.println(ones[inputNumber]);
        } else if (inputNumber >= 20 && inputNumber < 100) {
            System.out.println(tens[SecondDigit] + " " + ones[ThirdDigit]);
        } else if (inputNumber >= 100 && inputNumber < 1000  && Tens > 0 && Tens < 20) {
            System.out.println(ones[FirstDigit] + " Hundred And " + ones[Tens]);
        } else {
            System.out.println(ones[FirstDigit] + " Hundred " + tens[SecondDigit] + " " + ones[ThirdDigit]);
        }
    }
}