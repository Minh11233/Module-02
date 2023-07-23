public class Main {
    public static void main(String[] args) {
        for (int i = 0; i <= 12; i++) {//có thể thay đổi chiều ngang của sao cho i<=10
            for (int j = 0; j < 12 - i; j++) {//có thể thay đổi chiều cao của sao cho j<10-i
                System.out.print("  ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print(" *");
            }
            if (i > 0) {
                for (int k = 0; k < i - 1; k++) {
                    System.out.print(" *");
                }
            }
            System.out.println();
        }
    }
}