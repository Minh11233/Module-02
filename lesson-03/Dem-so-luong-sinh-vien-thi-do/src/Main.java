import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int studentQuantity;
        int[] array;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Nhập số lượng sinh viên: ");
            studentQuantity = input.nextInt();
            if (studentQuantity > 30) {
                System.out.println("Vui lòng không nhập quá số lượng 30 số điểm học sinh");
            }
        } while (studentQuantity > 30);
        array = new int[studentQuantity];
        for(int i = 0; i < array.length; i++) {
            System.out.println("Nhập điểm của học sinh" + (i+1) + ":");
        }
        int count = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] >= 5 || array[j] <= 10) {
                count++;
            }
        }
        System.out.println("Số lượng hs đỗ là: " + count);
    }

}