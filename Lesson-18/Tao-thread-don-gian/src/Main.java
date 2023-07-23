public class Main {
    public static void main(String[] args) {
        Thread A = new Thread(new NumberGenerator("A"));
        Thread B = new Thread(new NumberGenerator("B"));
        A.setPriority(Thread.MAX_PRIORITY);
        A.start();
        B.setPriority(Thread.MIN_PRIORITY);
        B.start();
    }
}