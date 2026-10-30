/*
Rebecca Palmer
CSD 420
Assignment 2.2
10/29/26
 */

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class FileCreate {

    public static void main(String[] args) throws IOException {
        String fileName = "../palmer_datafile.dat"; //File location.
        Random random = new Random(); //Create randomizer object.
        
        // Create array of 5 random int.
        int[]intArray = new int[5];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(100);
        }
        // Creates an array of 5 double.
        double[]doubleArray = new double[5];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = 1.0 +(100.0 - 1.0) * random.nextDouble();
        }

        try (DataOutputStream output = new DataOutputStream(
            new FileOutputStream(fileName, true))) {
                //Writes ints to file.
                for (int num : intArray) {
                    output.writeInt(num);
                }
                //Writes doubles to file.
                for (double num : doubleArray) {
                    output.writeDouble(num);
                }
                
                System.out.println("Data successfully written to " + fileName);
            }
        
            catch (IOException e) { //Exception error message.
                System.out.println("Error writing to file: " + fileName);
            }
    }
}