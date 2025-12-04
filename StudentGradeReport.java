package Meneses;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class StudentGradeReport {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	
	
	System.out.print("Enter number of students: ");
	int students = sc.nextInt();
	sc.nextLine();
	
	String[] names = new String[students];
	double[] grades = new double[students];
	
	for (int i = 0 ; i < students ; i++) {
		System.out.print("Enter student name " + (i + 1) + ": ");
		names[i] = sc.nextLine();
		
		System.out.print("Enter grade of " + names[i] + ": ");
		grades[i] = sc.nextDouble();
		sc.nextLine();
		
	}
	
	int passed = passedgrades(grades);
	
	writeToFile(names, grades, passed);
	
	
	sc.close();

	} // closing btacket of main method
	
	
	
	
	public static int passedgrades(double[] grades) {
		int passedcount = 0;
		for (double num : grades) {
			if (num >= 75) {
				passedcount++;
			}
		}
		return passedcount;
	}
	
	
	
	public static void writeToFile(String[] names, double[] grades, double passed) {
		try {
			FileWriter fw = new FileWriter("GradesReport.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			
			
			pw.println("Student Grades: \n");
			
			for (int i = 0 ; i < names.length ; i++) {
				pw.println(names[i] + " - " + grades[i]);
			}
			
			pw.println("\n");
			double failed = names.length - passed;
			
			pw.println("Passed: " + passed);
			pw.println("Failed: " + failed);
			
			
			
			pw.close();
			fw.close();
			
			
		}
		
		
		
		catch (Exception e) {
			System.out.print("An error has occured.");
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
