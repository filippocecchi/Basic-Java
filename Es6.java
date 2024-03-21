/*
Scrivere un programma che dato un file .book stampa la lista dei libri in formato:
  [n] Autore1, ..., AutoreN. “Titolo”. (Anno)
dove [n] indica l’n-esimo libro stampato.
La lista degli autori deve essere in ordine alfabetico
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Es6 {

  final static String IN_FILE = "elenco.book";

  private static String removeTags(String line, String tagName) {
    int i = line.indexOf("<" + tagName + ">");
    if (i == -1)
      return "";
    int j = line.lastIndexOf("<\\" + tagName + ">");
    if (j == -1)
      return "";
    return line.substring(i + tagName.length() + 2, j);
  }

  public static void main(String[] args)
  throws FileNotFoundException {
    Scanner scan = new Scanner(new File(IN_FILE));
    ArrayList<Book> books = new ArrayList<Book>();
    int n = 1;
    while (scan.hasNextLine()) {
      String line = scan.nextLine();
      if (line.contains("BOOK>"))
        continue;
      String title = removeTags(line, "TITLE");
      ArrayList<String> authors = new ArrayList<String>();
      do {
        line = scan.nextLine();
        String author = removeTags(line, "AUTHOR");
        if (author == "")
          break;
        else
          authors.add(author);
      } while (true);
      Collections.sort(authors);
      String authorStr = authors.toString();
      authorStr = "[" + n + "] " + authorStr.substring(1, authorStr.length()-1);
      String year = removeTags(line, "YEAR");
      System.out.println(authorStr + ". \"" + title + "\". (" + year + ")");
      n++;
    };
    
  }
  
}
