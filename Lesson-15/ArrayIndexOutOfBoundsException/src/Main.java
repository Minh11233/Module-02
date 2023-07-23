import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr = arrayExample.createRandom();
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nVui lòng nhập chỉ số của một phần tử bất kỳ: ");
                int x = Integer.parseInt(scanner.nextLine());
                System.out.println("Giá trị của phần tử có chỉ số " + x + " là " + arr[x]);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Chỉ số vượt quá giới hạn của mảng");
            } catch (InputMismatchException e) {
                System.err.println("Bạn đang nhập chữ. Vui lòng nhập số");
            } catch (NumberFormatException e) {
                System.err.println("Bạn đã nhập sai kiểu dữ liệu");
            }
        }
    }
}