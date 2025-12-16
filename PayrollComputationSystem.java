package FinalsPractice;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
public class PayrollComputationSystem {

	
	static String[] names;
	
	
	// method one
	
	static double[] inputHours() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees? ");
		int employees = sc.nextInt();
		sc.nextLine();
		
		// initializing arrays to store names and hours
		
		names = new String[employees];
		double[] hoursWorked = new double[employees];
		
		
		// storing the names and hours to the arrays
		
		for (int i = 0; i < employees; i++) {
			System.out.print("Enter employee name " + (i+1) + ": ");
			names[i] = sc.nextLine();
			
			System.out.print(names[i] + "'s hours worked: ");
			hoursWorked[i] = sc.nextDouble();
			sc.nextLine();
			
		}
		
		return hoursWorked;
	}
	
	
	
	/* method two - computing payroll 
	 
	 hourly rate = 150
	 regular hours == 40
	 regular pay = reg hours x hourly rate
	 overtime hours > 40
	 overtime pay = overtime hours x (hrly rate x 1.5)
	 grosspay = regularpay + overtimepay
	 tax = grosspay x 0.12
	 netpay = grosspay - tax
	 * */
	
	
	static String computePayroll(double hoursWorked) {
		double hourlyrate = 150;
		double regularpay = 0;
		double overtimepay = 0;
		double grosspay = 0;
		double tax = 0;
		double netpay = 0;
		if (hoursWorked == 40) {
			regularpay = hoursWorked * hourlyrate;
		} else if (hoursWorked > 40) {
			overtimepay = hoursWorked * (hourlyrate * 1.5);
		}
		
		grosspay = regularpay + overtimepay;
		tax = grosspay * 0.12;
		netpay = grosspay - tax;
		
		
		return
		String.format("\nRegular: \u20B1%.2f \nOvertime: \u20B1%.2f \nGross: \u20B1%.2f \nTax: \u20B1%.2f \nNet: \u20B1%.2f \n\n", regularpay, overtimepay, grosspay, tax, netpay);
		
	}
	
	
	
	
	
	
	// method three - write to file
	
	
	static void employeePayroll(String payroll) {
		
		
		try {
			
			FileWriter fw = new FileWriter("payroll_report.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.print(payroll);
			pw.close();
			fw.close();
				
			
			
		}
		
		catch (IOException e) {
		
			System.out.print("An error has occured.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
	double[] hours = inputHours();
	
	StringBuilder payroll = new StringBuilder();
	
	System.out.println();
	
	for (int i = 0; i < hours.length; i++) {
		String computation = computePayroll(hours[i]);
		String line = String.format("%d. %s: %s", (i+1), names[i], computation);
		
		
		
		System.out.print(line);
		payroll.append(line).append("\n");
	}
		
		
		
		employeePayroll(payroll.toString());
		
		
		

	}

}
