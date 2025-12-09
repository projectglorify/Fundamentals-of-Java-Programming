package FinalsPractice;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
public class GradeManagement {

	
	
	static void printMenu() {
		System.out.println("\nMENU:");
		System.out.println("1. Students and Grades List");
		System.out.println("2. Highest Grade");
		System.out.println("3. Lowest Grade");
		System.out.println("4. Average Grade");
		System.out.println("5. Summary");
		System.out.println("6. Exit");
	}
	
	
	static void studentsandgrades(String[] names, double[] grades) {
		for (int i = 0 ; i < names.length ; i++) {
			System.out.print(names[i] + " - " + grades[i] + "\n");
		}
		
	}
	
	
	
	static double highestgrade(double[] grades) {
		double highest = grades[0];
		for (double num : grades) {
			if (num > highest) {
				highest = num;
			}
		}
		return highest;
	}
	
	
	static double lowestgrade(double[] grades) {
		double lowest = grades[0];
		for (double num : grades) {
			if (num < lowest) {
				lowest = num;
			}
		}
		return lowest;
	}
	
	
	static int averagegrade(double[] grades) {
		int average = 0;
		double sum = 0;
		for (double num : grades) {
			sum += num;
		average = (int) sum / grades.length;
		}
		return average;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Enter number of students: ");
	int students = sc.nextInt();
	sc.nextLine();
	
	
	//arrays
	
	String[] names = new String[students];
	double[] grades = new double[students];
	
	
	// storing data to arrays
	
	
	for (int i = 0 ; i < students ; i++) {
		System.out.print("Enter name of student " + (i+1) + ": ");
		names[i] = sc.nextLine();
		
		System.out.print("Enter grades of " + names[i] + ": ");
		grades[i] = sc.nextDouble();
		sc.nextLine();
	}
	int option = 0;
	
	do {
		printMenu();
		
		System.out.print("Choose option: ");
		option = sc.nextInt();
		
		int average = averagegrade(grades);
		int highest = (int) highestgrade(grades);
		int lowest = (int) lowestgrade(grades);
		
		switch (option) {
		
		
		case 1: 
			studentsandgrades(names, grades);
			break;
			
		case 2: 
			System.out.print("The highest grade is: " + highest);
			break;
			
		case 3:
			System.out.print("The lowest grade is: " + lowest);
			break;
			
		case 4:
			System.out.print("The average grade is: " + average);
			break;
		
		case 5: 
			System.out.print("Refer to text file GradesSummary.");
			
		try {
			FileWriter fw = new FileWriter("GradesSummary.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println("STUDENT GRADES SUMMARY \n");
			
			
			for (int i = 0 ; i < names.length ; i++) {
				pw.println(names[i] + " - " + grades[i]);
			}
			pw.println("\n");
			pw.println("Highest Grade: " + highest);
			pw.println("Lowest Grade: " + lowest);
			pw.println("Average: " + average);
			
			
			pw.close();
			fw.close();
			
		}
			
			
			
		catch (IOException e) {
			System.out.print("An error has occured.");
		}
			
			break; 
			
			
		case 6:
			System.out.print("THANK YOU!");
			break;
			
			
		default: System.out.print("Invalid Input");
			
		
		
			
			
		} // switch case close bracket
	}
		while (option != 6);
	
	sc.close();
	
	}

}
