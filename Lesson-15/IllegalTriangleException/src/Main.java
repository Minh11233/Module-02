import com.sun.deploy.net.DownloadException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                int sideA = Integer.parseInt(prompt("Nhập cạnh a"));
                int sideB = Integer.parseInt(prompt("Nhập cạnh b"));
                int sideC = Integer.parseInt(prompt("Nhập cạnh c"));
                Triangle triangle = new Triangle(sideA,sideB,sideC);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập lại");
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập đúng cạnh");
            }
        }
    }

    public static String prompt(String request) {
        Scanner input = new Scanner(System.in);
        System.out.println(request);
        return input.nextLine();
    }
}