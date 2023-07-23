public class Main {
    public static void main(String[] args) {
        int[] a = {5, 6, 7, 8};

        for(int i=0; i < a.length; i++){

            if(a[i] % 2 == 0){

                continue;

            }
            System.out.print(i);
        }
    }
}