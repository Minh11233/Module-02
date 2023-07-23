import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> Inter = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            Inter.push(i);
        }
        System.out.println("Print Integer array before reverse: " + Inter);

        Stack<Integer> newInter = new Stack<>();
        for (int j = 0; j < 5; j++) {
            newInter.push(Inter.pop());
        }
        System.out.println("Print Integer array after reverse: " + newInter);


        String name = "Minh";
        ArrayList<Character> mWord = new ArrayList<>();
        Stack<Character> wStack = new Stack<>();
        for (int i = 0; i < name.length(); i++) {
            mWord.add(name.charAt(i));
        }
        System.out.println("Name before reverse " + name);
        System.out.println(mWord);

        for (int i = name.length() - 1; i >= 0; i--) {
            wStack.push(mWord.get(i));
        }
        System.out.println(wStack);
        String reverseArray = "";

        for (int i = 0; i < name.length(); i++) {
            reverseArray += wStack.get(i);
        }
        System.out.println("Name after reverse: " + reverseArray);
    }
}