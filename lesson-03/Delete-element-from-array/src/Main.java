import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {2,3,4,6,1,4,7,8,6};
        boolean check = true;
        System.out.println("Nhập phần tử cần xoá:");
        Scanner input = new Scanner(System.in);
        double index_del = input.nextDouble();
        for (int i = 0; i < array.length-1; i++ ) {
            if (index_del == array[i]) {
                for (int j = i; j < array.length-1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
                System.out.println("Phần tử cần xoá là " + index_del + " ở vị trí " + (i + 1));
                System.out.println(Arrays.toString(array));
                check = true;
                break;
            } else {
                check = false;
            }
        } if (!check) {
            System.out.println("Không tìm thấy phần tử cần xoá trong mảng. Vui lòng nhập lại.");
        }
    }
}