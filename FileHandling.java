package Meneses;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileHandling {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	
		/* for file writing:
		 
		 FileWriter - good for small or medium-sized text files
		 BufferedWriter - better performance for large amounts of text
		 PrintWriter - best for structured data, like reports or logs
		 FileOutputStream - best for binary files (e.g images, audio files)
		 */
		
		
	System.out.print("Enter number of products: ");
	int products = sc.nextInt();
	sc.nextLine();
	
	String productname[] = new String[products];
	int productqty[] = new int[products];
	
	
	//to input each product names and quantities: 
	
	
	for (int i = 0 ; i < products ; i++) {
		System.out.print("Enter product name" + " " + (i+1) + ": ");
		productname[i] = sc.nextLine();
		
		System.out.print("Enter product quantity: ");
		productqty[i] = sc.nextInt();
		sc.nextLine();
		
	}
	
	int instock = prodInStock(productqty);
	int outofstock = prodOutofStock(productqty);
	int total = totalqty(productqty);
	
	
	
	
	
	
	// without using methods, I can use the following structure below:
	
/*	int instock = 0;
 	int outofstock = 0;
  	int total = 0;
  
 
 	for (int i = 0; i < products ; i++) {
		totalqty += productqty[i];
		
		if (productqty[i] == 0) {
			outofstock++;
		} else {
			instock++;
		}
	
	}
	*/
	
	
	
	
	
	
	try {
		
		FileWriter fw = new FileWriter("InventoryTracker.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		pw.print("Products and Quantities: \n");
		for (int i = 0; i < products; i++) {
			pw.println(productname[i] +  " - " + productqty[i] + "\n");
		}
		
		pw.println("Total product quantity: " + total);
		pw.println("In Stock: " + instock);
		pw.println("Out of Stock: " + outofstock);
		
		
		
		
		
		
		
		fw.close();
		pw.close();
		
		
	}
	
	catch (IOException e) {
		System.out.print("Error writing to file.");
	}
	
	
	
	
		sc.close();
	
}
	
	
	static int prodInStock(int[] productqty) {
		int instockcount = 0;
		for (int qty : productqty) {
		if (qty > 0) {
			instockcount++;
		}
		}
		return instockcount;
	}
	
	
	
	static int prodOutofStock(int[] productqty) {
		int outofstockcount = 0;
		for (int qty : productqty) {
		if (qty == 0) {
			outofstockcount++;
		}
		}
		return outofstockcount;
	}
	
	
	
	static int totalqty(int[] productqty) {
		int totalcount = 0;
		for (int qty : productqty) {
			totalcount += qty;
		}
		return totalcount;
	}
	
		
	
	
	
	
	
	
	
	
}
