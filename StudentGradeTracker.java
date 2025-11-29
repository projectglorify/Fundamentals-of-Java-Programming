package aTinyBitofPractice;
import java.util.Scanner;
public class StudentGradeTracker {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	

	System.out.print("Enter number of students: ");
	int students = sc.nextInt();
	sc.nextLine();
	
	
	
	String names[] = new String[students];
	int grades[] = new int[students];
	
	
	
	for (int i = 0 ; i < students ; i++) {
		System.out.print("Enter student name: ");
		names[i] = sc.nextLine();
		
		System.out.print("Enter student grade: ");
		grades[i] = sc.nextInt();
		sc.nextLine();
		
	}
	
	
	
	//MENU
	int choice = 0;
	int sum = 0;
	int average = 0;
	
	do {
		System.out.print("\nMENU: \n1. Display all students "
						+ "\n2. Highest Grade "
						+ "\n3. Lowest Grade "
						+ "\n4. Average Grade "
						+ "\n5. Exit \n");
		
		
		
		System.out.print("Enter menu number: ");
		choice = sc.nextInt();
		sc.nextLine();
		
		switch (choice) {
		
		
		
		case 1: // display all students
			System.out.print("LIST OF STUDENTS: ");
			for (int i = 0; i < names.length ; i++) {
			System.out.print((i + 1) + ". " + names[i] + " - " + grades[i] + "\n");
			}
			break;
			
		case 2: //display highest grade
			int highest = grades[0];
			for (int i = 1 ; i < grades.length ; i++) {
			
				if (grades[i] > highest) {
				highest = grades[i];
				
				}
			}
			System.out.print("Highest Grade: " + highest);
			break;
			
			
		case 3: // display lowest grade
			int lowest = grades[0];
			for (int i = 1 ; i < grades.length ; i++) {
				if (grades[i] < lowest) {
					lowest = grades[i];
				
				}
			}
			System.out.print("Lowest Grade: " + lowest);
			break;
			
			
		case 4: // calculate and display average grade
			
			for (int i = 0 ; i < grades.length ; i++) {
			sum += grades[i];
			average = sum / grades.length;
			}
			System.out.print("Average grade: " + average);
			break;
			
		default: System.out.print("Invalid Input");
		}
		
		
		
		
		
		
		
		
		
		
		
	}	 while (choice !=5);
	}
	}


