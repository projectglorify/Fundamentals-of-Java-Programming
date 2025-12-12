package FinalsPractice;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
public class EnergyConsumptionBilling {
	
	
	
	// method one
	
	
	
	static double[] inputUsage() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many households to process? ");
		int household = sc.nextInt();
		sc.nextLine();
		
		double[] usage = new double[household];
		
		System.out.print("Enter monthly kWh usage. ");
		System.out.println();
		for (int i = 0; i < household; i++) {
			System.out.print("Household " + (i+1) + ": ");
			usage[i] = sc.nextDouble();
			sc.nextLine();
		}
		
		
		return usage;
		
	}
	
	
	
	// method two
	
	
	
	static String determineCategory(double usage) {
		
		if (usage > 500) {
			return "High Usage";
		} else if (usage >= 300) {
			return "Moderate Usage";
		} else {
			return "Low Usage";
		}
	}
	
	
	
	
	// method three
	
	
	static void saveReport(String data) {
		try {
			FileWriter fw = new FileWriter("electricity_report.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			
			pw.print(data);
			pw.close();
			fw.close();
			
			System.out.print("Saved to text file electricity_report.txt");
			
			
		}
		catch (IOException e) {
			System.out.print("An error has occured.");
		}
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		double[] usage = inputUsage();
		
		StringBuilder electricityreport = new StringBuilder();
		System.out.println();
		
		for (int i = 0; i < usage.length; i++) {
			String category = determineCategory(usage[i]);
			String info = String.format("Household %d: %.2f - %s \n", (i+1), usage[i], category);
			
			
			System.out.print(info);
			electricityreport.append(info).append("\n");
		}
		
		saveReport(electricityreport.toString());
		

	}

}
