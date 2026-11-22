/*
 * Rebecca Palmer
 * CSD 420
 * Assignment 6.2
 * 11/21/26
 */

/*
 * This code will create two generic methods: one for bubble sorting using a
 * Comparable interface, and using a Comparator interface. The main method will
 * test each of these generic methods on an arraylist of integers, and an
 * arraylist of strings.
 */

import java.util.Arrays;
import java.util.Comparator;

public class BubbleSort {

    //Comparable bubble sort generic method.
    public static <E extends Comparable<? super E>> void bubbleSort(E[] list) {
        boolean passAgain = true; //Initial pass needed.
        
        //Outside loop passes through all elements in list.
        for (int i = 0; i < list.length && passAgain; i++) {
            passAgain = false; //Stops inside loop if elements are sorted.
            
            //Inside loop compares each element one at a time.
            for (int j = 0; j < list.length - 1 - i; j++) {
                
                //compareTo() returns > 0 if left element's value is higher.
                if (list[j].compareTo(list[j+1]) > 0) {
                    //Swaps elements if the left value is higher.
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    
                    passAgain = true; //Swap occurred- allows another pass.
                }
            }
        }
    }
    
    //Comparator bubble sort generic method.
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean passAgain = true; //Initial pass needed.
        
        for (int i = 0; i < list.length && passAgain; i++) {
            passAgain = false; //Stops inside loop if elements are sorted.
            
            for (int j = 0; j < list.length - 1 - i; j++) {
                //compare() returns > 0 if left element's value is higher.
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    //Swaps elements if the left value is higher.
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    
                    passAgain = true; //Swap occurred- allows another pass.
                }
            }
        }
    }
    
    //Main Method tests both bubbleSort methods on Integer and String lists.
    public static void main(String[] args) {
        //Create an Integer array and a String array for Comparable tests.
        Integer[] numbers = {87, 10, 42, 36, 4};
        String[] words = {"Pink", "Purple", "Blue", "Yellow", "Green"};
        
        //Print unsorted lists.
        System.out.println("Unsorted Integers: " + Arrays.toString(numbers));
        System.out.println("Unsorted Strings: " + Arrays.toString(words));
        System.out.println(); //Skip a line.
        
        //Test Comparable method with Integers.
        bubbleSort(numbers);
        System.out.println("Comparable-Sorted Integers: " + 
                            Arrays.toString(numbers));
        //Test Comparable method with Strings.
        bubbleSort(words);
        System.out.println("Comparable-Sorted Strings: " + 
                            Arrays.toString(words));
        System.out.println(); //Skip a line.
        System.out.println("-----");
        System.out.println(); //Skip a line.
        
        //Create and print a list of Pet objects.
        Pet[] pets = {
            new Pet("Zuko", 12),
            new Pet("Kotoru", 6),
            new Pet("Godzilla", 4),
            new Pet("Oreos", 8),
            new Pet("Rhysand", 10)
        };
        System.out.println("Unsorted Pets: " + Arrays.toString(pets));
        System.out.println(); //Skip a line.
        
        //Test Comparator method with Integers (sorts Age in descending order).
        bubbleSort(pets, (p1, p2) -> Integer.compare(p2.age, p1.age));
        System.out.println("Comparator-Sorted Pets (Age Descending): " +
                            Arrays.toString(pets));
        //Test Comparator method with Strings (sorts by length of Name).
        bubbleSort(pets, (p1, p2) -> Integer.compare(p1.name.length(), p2.name.length()));
        System.out.println("Comparator-Sorted Pets (Name Length): " +
                            Arrays.toString(pets));
    }
}

//Helper class for Pet objects.
class Pet {
    public String name;
    public int age;
    
    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return name + " (" + age + ")"; 
    }
}