/*
*Your mission is to write a small Java program that proves whether Green Eggs and Ham 
*really uses only 50 different words. You’ll start with two things: an empty Main class 
and a text file that contains the entire story. Your job is to read the file line by 
line and use appropriate skills to see count the number of words. How you do this is up to you!
*/

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        ArrayList<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get("greenEggsAndHam.txt"))) {

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                row = row.toLowerCase();
                row = row.replaceAll("-", " ");
                row = row.replaceAll("\\p{Punct}", "");
                String separateWords[] = row.split(" ");
                if (!row.isEmpty()){
                for (int index = 0; index < separateWords.length; index++) {
                    if (words.contains(separateWords[index])) {
                    } else {
                        words.add(separateWords[index]);
                    }
                }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (int index = 0; index < words.size(); index++) {
            System.out.println(words.get(index));
        }
        System.out.println(words.size() + " words");
    }
}
