import java.util.*;
public class Main {
    public static void main(String[] args) {
        String paragraph = "Bug is Bug a solo album by Dave Davies best known as lead guitarist and co-founder of British rock band The Kinks released in May 2002 It was his fourth true solo studio album almost 20 years after the release of his third effort Chosen People";
        paragraph = paragraph.toUpperCase();
        String words[] = paragraph.split(" ");
        System.out.println(Arrays.toString(words));

        TreeMap<String,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            if (treeMap.containsKey(words[i])) {
                int count = treeMap.get(words[i]);
                treeMap.replace(words[i], count + 1);
            } else {
                treeMap.put(words[i], 1);
            }
        }
        System.out.println(treeMap);
    }
}