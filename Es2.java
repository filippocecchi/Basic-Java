/*
Leggere da file di input una sequenza di int uno sotto l’altro e stampare a 
video l'insieme corrispondente usando la classe RangeList
*/

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Es2 {

  public static void main(String[] args) {
    final String inFile = "numeri.dat";
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    try {
      Scanner scan = new Scanner(new File(inFile));
      while (scan.hasNextLine())
        numbers.add(Integer.parseInt(scan.nextLine()));
    }
    catch (Exception e) {
      System.out.println("FATAL! " + e);
      return;
    }
    int n = numbers.size();
    int[] a = new int[n];
    for (int i = 0; i < n; ++i)
      a[i] = numbers.get(i);
    System.out.println(new RangeList(a));
  }
  
}
