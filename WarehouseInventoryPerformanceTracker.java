package FinalsPractice;
import java.io.*;
import java.util.*;
public class WarehouseInventoryPerformanceTracker {
	
	// method one
	
	static int[] inputUsage() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many warehouse section to anaylze? ");
		int section = sc.nextInt();
		sc.nextLine();
		
		int[] usage = new int[section];
		
		System.out.print("Enter monthly inventory usage for " + section + " sections.");
		System.out.println();
		
		for (int i = 0; i < section; i++) {
			System.out.print("Section " + (i+1) + ": ");
			usage[i] = sc.nextInt();
			sc.nextLine();
			
		}
		
		return usage;
	}
	
	
	
	
	// method two
	
	
	
	static String evaluateUsage(int usage) {
		if (usage > 1000) {
			return "High Usage";
		} else if (usage >= 500) {
			return "Moderate Usage";
		} else {
			return "Low Usage";
		}
		
	}
	
	
	// method three
	
	
	static int calculateAverage(int[] usage) {
		int average = 0;
		int totaluse = 0;
		for (int use : usage) {
			totaluse += use;
		}
		average = totaluse / usage.length;
		return average;
	}
	
	
	// method four
	
	
	static void warehouseInventory(String summary) {
		
		try {
			
			FileWriter fw = new FileWriter("WarehouseInventory.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.print(summary);
			pw.close();
			fw.close();
	
			
		}
		
		
		
		catch (IOException e) {
			System.err.print("An error has occured.");
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
	int[] usage = inputUsage();
	int average = calculateAverage(usage);
	
	StringBuilder summary = new StringBuilder();
	
	System.out.println();
	
	for (int i = 0; i < usage.length; i++) {
		String evaluation = evaluateUsage(usage[i]);
		
		String line = String.format("Section: %d | %d items - %s \n", (i+1), usage[i], evaluation);
		System.out.print(line);
		summary.append(line).append("\n");
		
		
	}
		
		
	System.out.print("Average inventory usage: " + average);	
		
		
		
	warehouseInventory(summary.toString());	
		
		
		
		
		
		

	}

}
