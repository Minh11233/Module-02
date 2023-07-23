import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the width:");
        double width = input.nextDouble();
        System.out.println("Enter the height:");
        double height = input.nextDouble();

        Rectangle newRect = new Rectangle(width,height);
        System.out.println("Your Rectangle \n" + newRect.display());
        System.out.println("Perimeter of the Rectangle: " + newRect.getPerimeter());
        System.out.println("Area of the Rectangle: " + newRect.getArea());
    }
}
