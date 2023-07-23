import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String sourceFile = promt("Nhập tập tin nguồn: ");
        String targetFile = promt("Nhập tập tin đích: ");
        copyContent(sourceFile,targetFile);
    }

    public static void copyContent(String sourceFile, String targetFile) throws IOException {
        try (BufferedReader a = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter b = new BufferedWriter(new FileWriter(targetFile,true))) {
            // cách thi HSG
            int character;
            ArrayList<Integer> sentence = new ArrayList<>();
            while ((character = a.read()) != -1) {
                sentence.add(character);
                b.write(character);
            }
            System.out.println("Số ký tự trong tệp là: " + sentence.size());
        } catch (Exception e) {
            System.out.println("Không tìm thấy file");
        }
//        finally {
//            assert b != null;
//            b.close();
//            //try - with - resource
//        } cách tiểu học
    }

    public static String promt(String request) {
        Scanner input = new Scanner(System.in);
        System.out.println(request);
        return input.nextLine();
    }

}