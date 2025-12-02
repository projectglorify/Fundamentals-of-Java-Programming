package Meneses;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
public class MiniStoreManagement {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	
	System.out.print("How many products are there in your store? ");
	int num = sc.nextInt();
	sc.nextLine();
	
	
	String name[] = new String[num];
	int qty[] = new int[num];
	
	for (int i = 0 ; i < num ; i++) {
	System.out.print("Enter product name: ");
	name[i] = sc.nextLine();
	System.out.print("Enter quantity: ");
	qty[i] = sc.nextInt();
	sc.nextLine();
	
	}
	
	
	int choice = 0;
	int totalstock = totalqty(qty);
	int prodinstock = instock(qty);
	int prodoutstock = outstock(qty);
	
	
	do {
	
		menu();
		System.out.print("\n");
		System.out.print("Choose your option: ");
		choice = sc.nextInt();
		sc.nextLine();
		
		
		switch (choice) {
		
		case 1: //Display products and quantities
			for (int i = 0 ; i < num ; i++) {
				System.out.print("ALL AVAILABLE PRODUCTS: \n" + name[i] + " - " + qty[i]);
			}
		break;
		
		case 2: //stock summary
		

		
		System.out.println("Total: " + totalstock);
		System.out.println("Product in Stock: " + prodinstock);
		System.out.println("Product Out of Stock: " + prodoutstock);
		break;
		
		
		case 3: //receipt in text file
			System.out.print("To view mini store summary, refer to text file MiniStore. \n");
			
			
			try {
				
			FileWriter fw = new FileWriter("MiniStore.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println("YOUR MINI STORE INVENTORY SUMMARY \n");
			
			for (int i = 0 ; i < num ; i++) {
				pw.println(name[i] + " - " + qty[i]);
			}
				
			pw.println("In Stock: " + prodinstock);
			pw.println("Out of Stock: " + prodoutstock);
			pw.println("TOTAL: " + totalstock);
				
			
			fw.close();
			pw.close();
				
			}
		
		catch (IOException e) {
			System.out.print("Error.");
		}
			break;
			
		default: 
			System.out.print("Invalid input");
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} while (choice != 4);
	
	
	
	
	
	
	sc.close();
	
	
	} //main method closing bracket
	
	
	
	
	
	
	
	
	
	static void menu() {
		System.out.print("MENU: \n1. Display all products and quantities "
				+ "\n2. Stock Summary "
				+ "\n3. Generate  Receipt "
				+ "\n4. Exit");
	}
	
	static int totalqty(int[] qty) {
		int totalcounter = 0; //the variable i should return
		for (int i : qty) {
			totalcounter += i;	
		}
		return totalcounter;
	}
	
	
	
	static int instock(int[] qty) {
		int instockcounter = 0;
		for (int q : qty) {
			if (q > 0) {
				instockcounter++;
			}
		}
		return instockcounter;
	}
	
	static int outstock(int[] qty) {
		int outstockcounter = 0;
		for (int q : qty) {
			if (q == 0) {
				outstockcounter++;
			}
		}
		return outstockcounter;
	}
	
	
	
}


