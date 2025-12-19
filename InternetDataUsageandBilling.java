package FinalsPractice;
import java.io.*;
import java.util.*;
public class InternetDataUsageandBilling {
	
	
	// method A - usage category
	
	static String usageCategory(double usage) {
		if (usage >= 500) {
			return "Heavy User";
		} else if (usage >= 200) {
			return "Regular User";
		} else {
			return "Light User";
		}
	}
	
	
	// method B - computing the internet bill
	
	static double computeBill(double usage) {
		double bill = 0;
		
		if (usage < 200) {
			bill = usage * 5; 
		} else if (usage >= 200) {
			bill = usage * 7;
		} else {
			bill = usage * 10;
		}
		return bill;
	}
	
	
	
	// computing for discount eligibility
	
	static double applyDiscount(double bill, String category) {
		double discount = 0;
		if (category.equals("Light User")) {
			return discount = bill * 0.20;
		} else {
			return discount;
		}
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		StringBuilder internet = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many households? ");
		int hh = sc.nextInt();
		sc.nextLine();
		
		// using number of households (hh) to declare arrays
		String[] hhNames = new String[hh];
		double[] dataUsage = new double[hh];
		double[] billAmount = new double[hh];
		
		// storing data to the arrays
		for (int i = 0; i < hh; i++) {
			System.out.println();
			System.out.print("Enter household name: ");
			hhNames[i] = sc.nextLine();
			
			System.out.print("Enter data usage (in GB): ");
			dataUsage[i] = sc.nextDouble();
			sc.nextLine();
			
			String category = usageCategory(dataUsage[i]);
			double totalbill = computeBill(dataUsage[i]);
			double discount = applyDiscount(totalbill, category);
			
			System.out.println();
			
			String bill = String.format
					("Household: %s \nData Usage: %.2f \nCategory: %s \nOriginal Bill: \u20B1%.2f \nDiscounted Bill: \u20B1%.2f \n",
							hhNames[i], dataUsage[i], category, totalbill, discount);
			
			System.out.print(bill);
			
			internet.append(bill).append("\n");
			
		}
		
		
		
		
		try {
			FileWriter fw = new FileWriter("InternetBill.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			
			pw.print(internet.toString());
			pw.close();
			fw.close();
			
			System.out.print("Internet Bill saved - InternetBill.txt");
		}
		
		
		catch (IOException e) {
			System.err.print("There was an error writing file to text.");
		}
		
		
		
		
		
	}

}
