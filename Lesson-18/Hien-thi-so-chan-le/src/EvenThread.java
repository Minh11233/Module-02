public class EvenThread extends Thread {
    @Override
    public void run() {
        try {
            for(int i = 2; i <= 10; i+=2) {
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }
}
