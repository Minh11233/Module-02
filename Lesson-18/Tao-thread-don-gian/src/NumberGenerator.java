public class NumberGenerator implements Runnable{
    private Thread myThread;
    private final String threadName;

    public NumberGenerator(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
       try {
           for(int i = 0; i < 10; i++) {
               System.out.println("Running thread "+ threadName + ":");
               System.out.println(this.hashCode());
               System.out.println(i);
               Thread.sleep(500);
           }
       } catch (InterruptedException e) {
           System.out.println("Something went wrong");
       }
    }
}
