package FinalsPractice;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
public class StoreSalesPerformanceAnalyzer {
	
	
	// method 1
	
	
	static double[] inputSales() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many branches to analyze? ");
		int branches = sc.nextInt();
		sc.nextLine();
		
		double[] sales = new double[branches];
		
		
		System.out.print("Enter weekly sales for " + branches + " branches. \n");
		
		
		for (int i = 0 ; i < branches ; i++) {
			System.out.print("Branch " + (i + 1) + ": ");
			sales[i] = sc.nextDouble();
			sc.nextLine();
		}
		
		return sales;

	}

	
	
	
	
	// method 2
	
	static String evaluatePerformance(double sales) {
		if (sales > 100000) {
			return "Excellent Performance";
		} else if (sales >= 50000) {
			return "Good Performance";
		} else {
			return "Needs Improvement";
		}
		
	}
	
	
	
	
	
	
	// method 3
	
	static void saveReport(String data) {
		
		try {
			
			FileWriter fw = new FileWriter("Sales_Report.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.print(data);
			pw.close();
			fw.close();
			
			System.out.print("\n Saved to text file Sales_Report");
				
			
		}
		
		
		
		catch (IOException e) {
			System.out.print("An error has occured.");
		}
			
		
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		double[] sales = inputSales();
		
		StringBuilder report = new StringBuilder();
		
		System.out.println();
		
		
		for (int i = 0 ; i < sales.length ; i++) {
			
			String category = evaluatePerformance(sales[i]);
			
			String line = String.format("Branch %d: \u20B1%.2f - %s", (i+1), sales[i], category);
			
			
			
			
			
			
			System.out.println(line);	
			report.append(line).append("\n");
		}
		
		
		
	
		saveReport(report.toString());
		
		

	}

}
