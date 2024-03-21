/*
Leggere un file di testo in input, contare e stampare quante cifre da 0 a 9 
sono presenti nel file.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Es4 {


  public static void main(String[] args)
  throws FileNotFoundException {
    File file = null;
    Scanner scan = new Scanner(System.in);
    do {
      System.out.println("Dammi il nome del file:");      
      file = new File(scan.nextLine());
      if (!file.exists())
        System.out.println("File non esistente!");
      else if (!file.canRead())
        System.out.println("File non leggibile!");
      else
        break;
    } while (true);
    scan = new Scanner(file);
    int[] counter = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    while (scan.hasNextLine()) {
      String line = scan.nextLine();
      for (int i = 0; i < line.length(); ++i)
        // ASCII('0') = 48, ASCII('1') = 49, ..., ASCII('9') = 57
        if (line.charAt(i) >= '0' && line.charAt(i) <= '9')
          counter[line.charAt(i) - '0']++;
    }
    for (int i = 0; i < 10; ++i)
      System.out.println("Numero di " + i + ": " + counter[i]);
  }
  
}
