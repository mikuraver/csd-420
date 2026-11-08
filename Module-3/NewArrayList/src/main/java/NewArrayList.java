/*
 * Rebecca Palmer
 * CSD420
 * 11/7/26
 */

/*
 * This code is an example program that creates an ArrayList with 50 random
 * values. It contains a method that will create a new ArrayList with 50 new
 * values that were not in the original list.
 */

import java.util.ArrayList;
import java.util.Random;

public class NewArrayList {

    //Method that creates new ArrayList without duplicate values.
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> cleanList = new ArrayList<>(); // Empty ArrayList.
        
        //Loop only adds elements that are not in the list already.
        for (E element : list) {
            if (!cleanList.contains(element)) {
                cleanList.add(element);
            }
        }
        return cleanList; //Return the new list.
        }
    
    /*MAIN METHOD*/
    public static void main(String[] args) {
        Random random = new Random(); //Create randomizer.
        ArrayList<Integer> originalList = new ArrayList<>(); //Initial List.
        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20)+1);
        }
        
        //Prints the original list.
        System.out.println("Original List: " + originalList);
        System.out.println();
        
        //Creates new ArrayList of non-duplicate values from the original list.
        ArrayList<Integer> newList = removeDuplicates(originalList);
        System.out.println("New List: " + newList);
    }
}
