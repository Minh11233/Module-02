public class Main {
    public static void main(String[] args) {
        System.out.println("In hình chữ nhật");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 8; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("In hình tam giác vuông, có cạnh góc vuông ở botton-left");
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("In hình tam giác vuông, có cạnh góc vuông ở top-left");
        for (int i = 7; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}