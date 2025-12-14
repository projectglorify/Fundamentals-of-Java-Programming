package FinalsPractice;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
public class EmployeeAttendanceandOvertime_Analyzer {
	
	static String[] name;
	
	// method one
	
	static double[] inputEmployees() {
		
	Scanner sc = new Scanner(System.in);
	
	System.out.print("How many employees? ");
	int employees = sc.nextInt();
	sc.nextLine();
	
	double[] hours = new double[employees];  // initializing arrays
	name = new String[employees]; 
	
	for (int i = 0; i < employees; i++) {
		System.out.print("Enter employee name " + (i+1) + ": ");
		name[i] = sc.nextLine();
		
		System.out.print(name[i] + "'s hours worked: ");
		hours[i] = sc.nextDouble();
		sc.nextLine();
	}
		return hours;
	}
	
	
	
	
	
	
	// method two
	
	static String determineStatus(double hours) {
		if (hours > 40) {
			return "Overtime";
		} else if (hours == 40) {
			return "Regular";
		} else {
			return "Undertime";
		}
	}
	
	
	
	
	// method three
	
	
	static void attendanceReport(String attendance) {
	try {
		
		FileWriter fw = new FileWriter("Attendance_Report.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		pw.print(attendance);
		pw.close();
		fw.close();
	
		
		
	}
	
	catch (IOException e) {
		System.out.print("An error has occured.");
	}
	
	
	
}
	
	
	
	

	public static void main(String[] args) {
		
	
	double[] hours = inputEmployees();
	
	StringBuilder report = new StringBuilder();
	
	System.out.println();
	

	
	for (int i = 0; i < hours.length; i++) {
		
		String classify = determineStatus(hours[i]);
		
		
		String line = String.format("Employee %d: %s | %.2f hrs | %s \n", (i+1), name[i], hours[i], classify);
		
		
		System.out.print(line);
		report.append(line).append("\n");
	}
		
		
		
		
	attendanceReport(report.toString());	
		
		
		
		
		
		
		
		
		
		

	}
	
	
	
	
	
	
	
	
	

}
