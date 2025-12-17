package FinalsPractice;
import java.io.*;
import java.util.*;
public class ElectricityConsumptonandBilling {
	
	
	// method A
	
	
	static String usageCategory(double consumption) {
		
		if (consumption >= 500) {
			return "High Usage";
		} else if (consumption >= 200 && consumption <= 499) {
			return "Moderate Usage";
		} else {
			return "Low Usage";
		}
	}
	
	
	// method B
	
	static double computeBill(double consumption) {
		double rate = 0;
		if (consumption <= 200) {
			rate = consumption * 8;
		} else if (consumption >= 200 && consumption <= 499) {
			rate = consumption * 10;
		} else {
			rate = consumption * 12;
		}
		return rate;
	}
	
	
	
	// method C
	
	
	static double applyDiscount(double bill, String category) {
		if (category.equals("Low Usage")) {
			return bill * 0.10;
		} else {
			return bill;
		}
	}
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		StringBuilder electricbill = new StringBuilder();
		
		System.out.print("How many households? ");
		int households = sc.nextInt();
		sc.nextLine();
		
		String[] householdNames = new String[households];
		double[] consumption =new double[households];
		double[] billAmount = new double[households];
		
		
		for (int i = 0; i < households; i++) {
			System.out.print("Enter household name: ");
			householdNames[i] = sc.nextLine();
			
			System.out.print("Enter monthly consumption (in kWh): ");
			consumption[i] = sc.nextDouble();
			sc.nextLine();
			
			String category = usageCategory(consumption[i]);
			double totalbill = computeBill(consumption[i]);
			double discountedbill = applyDiscount(totalbill, category);
			
			
	String bill = String.format
			("Household: %s \nConsumption: %.2f kWh \nCategory: %s \nOriginal Bill: \u20B1%.2f \nDiscounted Bill: \u20B1in%.2f \n\n",
				householdNames[i], consumption[i], category, totalbill, discountedbill);
	
	System.out.print(bill);
	
	electricbill.append(bill).append("\n");
		}
		
		
		
	try {
		FileWriter fw = new FileWriter("ElectricityBillingReport.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		pw.print(electricbill.toString());
		pw.close();
		fw.close();
	}
		
		
	catch (IOException e) {
		System.err.print("An error has occured");
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	}

}
