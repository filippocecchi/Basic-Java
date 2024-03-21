/*
Chiedere un intero N e successivamente inserire da tastiera N libri. Per ogni 
libro chiedere titolo, autori (separati da virgola) e l'anno di prima scrittura.
Se l'inserimento va a buon fine, scrivere in modalità append ogni libro nel formato:
<BOOK>
  <TITLE>titolo<\TITLE>
  <AUTHOR>autore1<\<AUTHOR>
  <AUTHOR>autore2<\AUTHOR>
  ...
  <YEAR>anno<\YEAR>
<\BOOK>
Eliminare spazi prima e dopo titolo/autori. Salvare il file con estensione .book
*/

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Es5 {

  final static String OUT_FILE = "elenco.book";
  
  private static Book[] storeBooks(Scanner scan) {    
    System.out.println("Dammi il numero di libri:");
    int n = Integer.parseInt(scan.nextLine());
    if (n <= 0)
      System.exit(0);
    Book[] books = new Book[n];
    for (int i = 0; i < n; i++) {
      System.out.println("*** " + (i+1) + "o libro ***");
      System.out.println("Dammi il titolo:");
      String title = scan.nextLine().trim();
      System.out.println("Dammi autore(i) separati da virgola:");
      String[] authors = scan.nextLine().split(",");
      System.out.println("Dammi l'anno di prima scrittura:");
      int year = Integer.parseInt(scan.nextLine());
      books[i] = new Book(title, authors, year);
    }
    return books;
  }

  public static void main(String[] args)
  throws IOException {
    Book[] books = storeBooks(new Scanner(System.in));
    PrintWriter pw = new PrintWriter(new FileWriter(OUT_FILE, true));    
    for (Book b : books) {
      pw.println("<BOOK>");
      pw.println("\t<TITLE>" + b.getTitle() + "<\\TITLE>");
      String[] authors = b.getAuthors();
      for (String a : authors)
        pw.println("\t<AUTHOR>" + a.trim() + "<\\AUTHOR>");
      pw.println("\t<YEAR>" + b.getYear() + "<\\YEAR>");
      pw.println("<\\BOOK>");
    }    
    pw.close();
  }
  
}
