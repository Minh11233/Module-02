import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số dòng");
        int row = input.nextInt();
        System.out.println("Nhập số cột");
        int column = input.nextInt();
        int[][] array = new int[row][column];
        System.out.println("Nhập phần tử");
        int i;
        int j;
        int max = 0;
        String result = "";
        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {
                array[i][j] = input.nextInt();
                if (array[i][j] > max) {
                    max = array[i][j];
                }
                result += array[i][j] + " ";
            }
            result += "\n";
        }
        System.out.print("Mảng bạn vừa khởi tạo là" + "\n" + result);
        System.out.print("Giá trị lớn nhất là " + max);

    }
}