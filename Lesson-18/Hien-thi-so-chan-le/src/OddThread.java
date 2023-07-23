public class OddThread extends Thread{
    private Thread oddThread;
    @Override
    public void run() {
        try {
            for(int i = 1; i <= 10; i+=2) {
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }
}
