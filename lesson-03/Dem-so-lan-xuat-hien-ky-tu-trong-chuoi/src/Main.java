import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = "Nguyen Quang Minh";
        Scanner input = new Scanner(System.in);
        int count = 0;
        String character = input.next();
        for (int i = 0; i < str.length(); i++) {
            String text = String.valueOf(str.charAt(i));
            if (character.equals(text)) {
                count++;
            }
        }
        System.out.printf("Số lần xuất hiện của %s trong chuỗi là %s",character,count);
    }
}