/*
Chiedere da input due numeri interi N e M, e generare N stringhe casuali di 
lunghezza M. Scrivere le stringhe su file, una sotto l’altra
*/

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Es1 {

  private static String getRandomString(int len, char minChar, char maxChar) {
    String s = "";
    for (int i = 0; i < len; ++i)
      s += (char) ((Math.random() * (maxChar - minChar)) + minChar);
    return s;
  }

  public static void main(String[] args)
  throws FileNotFoundException {
    final String outFile = "random_strings.txt";
    Scanner scan = new Scanner(System.in);
    System.out.println("Dammi il numero di stringhe N:");
    int N = scan.nextInt();
    System.out.println("Dammi la lunghezza di ogni stringa M:");
    int M = scan.nextInt();
    PrintWriter writer = new PrintWriter(outFile);
    for (int i = 0; i < N; ++i)
      writer.println(getRandomString(M, '!', '~'));
    writer.close();
  }
  
}
