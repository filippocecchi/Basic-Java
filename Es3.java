/*
Leggere una sequenza di double in un file, e scriverli in ordine inverso in un 
altro file.
Se la lettura non va a buon fine, il file di output non deve essere creato
*/

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Es3 {


  public static void main(String[] args) {
    final String inFile = "in_doubles.txt";
    final String outFile = "out_doubles.txt";
    ArrayList<Double> numbers = new ArrayList<Double>();
    try {
      Scanner scan = new Scanner(new File(inFile));      
      while (scan.hasNextLine())
        numbers.add(Double.parseDouble(scan.nextLine()));
      PrintWriter writer = new PrintWriter(outFile);
      for (int i = numbers.size()-1; i >= 0; --i)
        writer.println(numbers.get(i));
      writer.close();
    }
    catch (Exception e) {
      System.out.println(e);
      System.exit(1);
    }    
  }
  
}
