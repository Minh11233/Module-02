import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array1 = new int[2];
        int[] array2 = new int[3];
        int[] array3 = new int[array1.length + array2.length];
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập giá trị cho mảng 1");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = input.nextInt();
        }

        System.out.println("Nhập giá trị cho mảng 2");
        for (int j = 0; j < array2.length; j++) {
            array2[j] = input.nextInt();
        }

        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }

        for (int j = 0; j < array2.length; j++) {
            array3[array1.length+j] = array2[j];
        }

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
    }
}