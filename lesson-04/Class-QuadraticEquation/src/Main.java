import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
//        new QuadraticEquation().name;
        QuadraticEquation Minh = new QuadraticEquation();
        Minh.GetName();
        System.out.println(Minh.GetName());
        Minh.SetName("ABC");
        System.out.println(Minh.GetName());
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số a:");
        double a = input.nextDouble();
        System.out.println("Nhập số b:");
        double b = input.nextDouble();
        System.out.println("Nhập số c:");
        double c = input.nextDouble();

        QuadraticEquation Calc = new QuadraticEquation(a,b,c);
        if (Calc.getDiscriminant() > 0) {
            System.out.printf("Phương trình có 2 nghiệm là: %f và %f ",Calc.getRoot1(),Calc.getRoot2());
        } else if (Calc.getDiscriminant() == 0) {
            System.out.println("Phương trình có nghiệm duy nhất là: " + Calc.getRoot1());
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}