/*
 * Rebecca Palmer
 * CSD420
 * 11/7/26
 */

/*
 * This program will test how long it takes to use the iterator vs the
 * get(index) method on a LinkedList. The differences will be explained in detail
 * in the comments below.
 */

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    
    //Method to test time it takes to use iterator and get(index).
    public static void performanceTest(int size) {
        //Creates a LinkedList with the specified number of integers.
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < size; i++){
            numbers.add(i);
        }
        
        //Tests time to use iterator.
        long startIt = System.nanoTime(); //Start time.
        ListIterator<Integer> it = numbers.listIterator(); //Iterator object.
        long sumIt = 0;
        while (it.hasNext()) {
            sumIt += it.next();
        }
        long endIt = System.nanoTime(); //End time.
        long durationIt = endIt - startIt; //Calculates duration.
        
        //Tests time to use get(index);
        long startGet = System.nanoTime(); //Start time.
        long sumGet = 0;
        for (int i = 0; i < size; i++) {
            sumGet += numbers.get(i);
        }
        long endGet = System.nanoTime(); //End time.
        long durationGet = endGet - startGet; //Calculates duration.
        
        //Print the results.
        System.out.println("Iterator Time: " + 
                          (durationIt / 1000000.0) + " ms");
        System.out.println("Get(index) Time: " + 
                          (durationGet / 1000000.0) + " ms");
    }
    
    /*MAIN METHOD*/
    public static void main(String[] args) {
        //Runs test with 50,000 integers.
        performanceTest(50000);
        System.out.println("--------------------");
        //Runs test with 500,000 integers.
        performanceTest(500000);
    }
}

/*
 * ======================
 * PERFORMANCE ANALYSIS
 * ======================

 * I ran the program three times as an initial test. These are the results:

 * Size     | Iterator     | get(index)
 * --------------------------------------------
 * 50,000   | 2.0-2.3ms    | 862-877ms
 * 500,000  | 6.7-8.6ms    | 111,114-116,347ms

 * In terms of performance, the iterator was the clear winner when it came to
 * efficiency by going through 500,000 integers in less than 10ms. The
 * get(index) method, on the other hand, took over 110,000ms to go through the
 * same amount of integers. It actually took so long that I had thought my
 * program crashed! This inefficiency is because a LinkedList stores its data
 * in nodes that are scattered across memory, despite being linked to each
 * other. It is faster to hop directly from item to item rather than resetting
 * after each element. The get(index) method starts from the beginning for each
 * item, adding hundreds to thousands of extra steps to the stack.
 */