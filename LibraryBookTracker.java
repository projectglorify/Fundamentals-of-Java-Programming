package MenesesLabActivities;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
public class LibraryBookTracker {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Enter number of books: ");
	int num = sc.nextInt();
	sc.nextLine();
	
	
	String[] name = new String[num];
	int[] qty = new int[num];
	
	
	
	
	
	for (int i = 0 ; i < num ; i++) {
		System.out.print("Enter title of book " + (i+1) + ": ");
		name[i] = sc.nextLine();
		
		System.out.print("Enter copies of " + " " + name[i] + ": " );
		qty[i] = sc.nextInt();
		sc.nextLine();
	}
	
	
	
	
	
	int total = totalbooks(qty);
	int instock = booksinstock(qty);
	int outstock = booksoutstock(qty);
	
	
	
	
	System.out.print("To view summary, refer to text file Library Report");
	
	
	try {
		
		FileWriter fw = new FileWriter("LibraryReport.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("Books and Copies: ");
		for (int i = 0 ; i < num ; i++) {
			pw.println(name[i] + " - " + qty[i]);
		}
		
		
		pw.println("Total Copies: " + total);
		pw.println("Available: " + instock);
		pw.println("Unavailable: " + outstock);
		
		
		
		
		fw.close();
		pw.close();
		
	}
	
	catch (IOException e) {
		System.out.print("Error writing file to text.");
	}
	
	
	
	
	
	
	
	
	
	sc.close();

	} // closing bracket of the main method
	
	
	static int totalbooks(int[] qty) {
		int totalcounter = 0;
		for (int q : qty) {
			totalcounter += q;
		}
		return totalcounter;
	}
	
	
	static int booksinstock(int[] qty) {
		int instock = 0;
		for (int q : qty) {
			if (q > 0) {
				instock++;
			}
		}
		return instock;
	}
	
	
	static int booksoutstock(int[] qty) {
		int outstock = 0;
		for (int q : qty) {
			if (q == 0) {
				outstock++;
			}
		}
		return outstock;
	}
	
	
	
	
	
	
	
	
	
	
	

}
