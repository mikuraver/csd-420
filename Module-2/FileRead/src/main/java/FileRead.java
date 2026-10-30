/*
Rebecca Palmer
CSD 420
Assignment 2.2
10/29/26
 */

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class FileRead {

    public static void main(String[] args) throws IOException {
        String fileName = "../palmer_datafile.dat"; //File location.
        
        try (DataInputStream input = new DataInputStream(
            new FileInputStream(fileName))) {
            while (true) { //Reads to end of file.
                try {
                    int firstInt = input.readInt(); //Checks for EOF first.
                    
                    //Read and print int values.
                    System.out.print("Random Integers: " + firstInt + " ");
                    for (int i = 0; i < 4; i++) {
                        System.out.print(input.readInt() + " ");
                    }
                    System.out.println();
            
                    //Read and print double values.
                    System.out.print("Random Doubles: ");
                    for (int i = 0; i < 5; i++) {
                        System.out.printf("%.2f ", input.readDouble());
                    }
                    System.out.println();
                }
            
                catch (EOFException eof) { //End of file breaks loop.
                    System.out.println("End of file reached.");
                    break;
                }
            }
        }
        catch (IOException e) { //Exception error message.
        System.out.println("Unexpected error. Unable to read file " + fileName);
        }
    }
}