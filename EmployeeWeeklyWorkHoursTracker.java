package FinalsPractice;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
public class EmployeeWeeklyWorkHoursTracker {
	
	
	
	
	
	// method one
	
	static double[] inputHours() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees to analyze? ");
		int employees = sc.nextInt();
		sc.nextLine();
		
		double[] weeklyhours = new double[employees];
		
		System.out.print("Enter the weekly hours worked for " + employees + " employee/s. \n");
		
		
		for (int i = 0 ; i < employees ; i++) {
			System.out.print("Employee " + (i+1) + ": ");
			weeklyhours[i] = sc.nextDouble();
			sc.nextLine();
		}
		
		return weeklyhours;
		
		
	}
	
	
	
	// method two
	
	
	static String evaluateWork(double weeklyhours) {
		if (weeklyhours > 50) {
			return "Excellent Workload";
		} else if (weeklyhours >= 40) {
			return "Standard Workload";
		} else {
			return "Needs Improvement";
		}
		
	}
	
	
	
	
	//method three
	
	static void saveSummary(String summary) {
	
	try {	
	FileWriter fw = new FileWriter("work_hours_report.txt");
	PrintWriter pw = new PrintWriter(fw);
	
	
	pw.println(summary);
	pw.close();
	fw.close();
	
	System.out.print("\nSaved to text file work_hours_report.txt");
	
	}
	
	
	catch (IOException e) {
		System.out.print("An error has occured.");
	}
		
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		double[] hours = inputHours();
		
		StringBuilder report = new StringBuilder();
		
		System.out.println();
		
		for (int i = 0 ; i < hours.length ; i++) {
		String category = evaluateWork(hours[i]);
		
		String line = String.format("Employee %d:  %.2f hrs - %s ", (i+1), hours[i], category);
		
		
		System.out.println(line);
		
		report.append(line).append("\n");
		
		
		}
		
		
		
		
		
		saveSummary(report.toString());
		
		
		
		
		
	}

}
