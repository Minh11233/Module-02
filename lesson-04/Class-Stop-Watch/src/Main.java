import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        long randomNumber = Math.round(Math.random()*100000);
        long[] array = new long[100000];
        for (int i = 0; i < 100000; i++) {
            array[i] = randomNumber;
        }
        StopWatch SW = new StopWatch();

        long begin = SW.start().getTime();
        Arrays.sort(array);
        long stop = SW.end().getTime();
        SW.getElapsedTime();

        System.out.println(begin);
        System.out.println(stop);
        System.out.println(SW.getElapsedTime());
    }
}