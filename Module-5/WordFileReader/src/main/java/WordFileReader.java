/*
Rebecca Palmer
CSD 420
Assignment 5.2
11/14/26
 */

/*
This code will read a list of words from a text file. It will then display
non-duplicate words in ascending order, and then in descending order.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class WordFileReader {
    
    public static void main(String[] args) {
        File file = new File("../collection_of_words.txt"); //File Location
        TreeSet<String> words = new TreeSet<>(); //New treeset.
        
        //Reads words from file using scanner.
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNext()) {
                //Removes all non-letter characters, makes word lowercase.
                String word = reader.next().toLowerCase().replaceAll(
                              "[^a-z]", "");
                //Adds word to treeset.
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        }
        //Ends program here if file can't be read.
        catch (FileNotFoundException e) {
            System.out.println("Error occurred. Unable to read file.");
            return;
        }
        
        //Print all words - already in ascending order and no duplicates.
        System.out.println("Words in Ascending Order: ");
        for (String word : words) {
            System.out.println(word);
        }
        
        System.out.println(); //Blank line.
        
        //Print all words in descending order.
        System.out.println("Words in Descending Order: ");
        for (String word : words.descendingSet()) {
            System.out.println(word);
        }
    }
}