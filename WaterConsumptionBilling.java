package FinalsPractice;
import java.io.*;
import java.util.*;
public class WaterConsumptionBilling {
	
	
	// method A
	
	static String usageClassification(double consumption) {
		if (consumption >= 50) {
			return "High Usage";
		} else if (consumption >= 20 && consumption <=49) {
			return "Normal Usage";
		} else {
			return "Low Usage";
		}
	}
	
	
	
	// method B
	
	static double computeBill(double consumption) {
		double rate = 0;
		if (consumption >= 50) {
			rate = consumption * 25;
		} else if (consumption >= 20 && consumption <= 49) {
			rate = consumption * 20;
		} else {
			rate = consumption * 15;
		}
		return rate;
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder bill = new StringBuilder();
		
		
		
		System.out.print("How many households? ");
		int households = sc.nextInt();
		sc.nextLine();
		
		
		String[] householdNames = new String[households];
		double[] consumption = new double[households];
		double[] billAmount = new double[households];
		
		
		
		
		for (int i = 0; i < households; i++) {
			System.out.print("Enter household name: ");
			householdNames[i] = sc.nextLine();
			
			
			System.out.print("Enter monthly water consumption (in cubic meters): ");
			consumption[i] = sc.nextDouble();
			sc.nextLine();
			
			String classification = usageClassification(consumption[i]);
			double waterbill = computeBill(consumption[i]);
			
			String line = String.format
			("Household name: %s \nConsumption: %.2f \nCategory: %s \nTotal Bill: \u20B1%.2f \n\n",
					householdNames[i], consumption[i], classification, waterbill);
			
			System.out.print(line);
			bill.append(line).append("\n");
		}
		
		
		
		try {
			FileWriter fw = new FileWriter("waterbill.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.print(bill.toString());
			pw.close();
			fw.close();
			
			
			
			
		}
		
		
		catch (IOException err) {
			System.err.print("An error has occured.");
		}

	}

}
