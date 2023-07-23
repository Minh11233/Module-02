package Utils;
import java.io.*;

public class WriteFiles {
    public static void writeDataCustomersInfoToFile(String path, String objects) {
        try(FileWriter fw = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fw)) {
            bufferedWriter.write("\t\tHOÁ ĐƠN");
            bufferedWriter.write(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeDataFlightInfoToFile(String path, String objects) {
        try(FileWriter fw = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw)) {
            bufferedWriter.write(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataToFile(String path, String objects) {
        try(FileWriter fw = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fw)) {
            bufferedWriter.write(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataToFileWithAppend(String path, String objects) {
        try(FileWriter fw = new FileWriter(path,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw)) {
            bufferedWriter.write(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
