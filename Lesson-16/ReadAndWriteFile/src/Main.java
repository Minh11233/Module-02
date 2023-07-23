import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("numbers.txt");
        int maxValue = FindMaxValue.findMax(numbers);
        readAndWriteFile.writeFile("result.txt", maxValue);
    }
}