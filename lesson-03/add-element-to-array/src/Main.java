import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {6,1,4,7,8,6,0,0,0,0};
        Scanner input = new Scanner(System.in);
        int index;
        int add_index;
        do {
            System.out.println("Nhập vị trí phần tử muốn chèn: ");
            index = input.nextInt();
            for (int i = 0; i < array.length; i++) {
                if (index <= -1 || index >= array.length) {
                    System.out.println("Vui lòng nhập lại vị trí phần tử");
                } else if (index == i) {
                    System.out.println("Nhập số muốn chèn");
                    add_index = input.nextInt();
                    for (int j = array.length-1; j >= i; j--) {
                        array[j] = array[j-1];
                    }
                    array[i] = add_index;
                }
            }
            for (int k = 0; k < array.length; k++) {
                System.out.print(array[k] + ",");
            }
        } while (index <= -1 || index >= array.length);
        System.out.println();
} }