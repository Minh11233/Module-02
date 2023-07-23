import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nhập chiều dài cạnh hình vuông (đơn vị: phần tử)");
        Scanner input = new Scanner(System.in);
        int squareEdge = input.nextInt();
        int[][] array = new int[squareEdge][squareEdge];
        int i;
        int j;
        int sum = 0;
        String result = "";
        System.out.println("Nhập phần tử");
        for(i = 0; i < squareEdge; i++) {
            for(j = 0; j < squareEdge; j++) {
                array[i][j] = input.nextInt();
                result += array[i][j] + "\t";
            }
            result += "\n";
        }
        System.out.print("Mảng bạn vừa khởi tạo là" + "\n" + result);

        for (i = 0; i < squareEdge; i++) {
            sum += array[i][i];
        }
        System.out.println("Tổng giá trị đường chéo của hình vuông là " + sum);
    }
}