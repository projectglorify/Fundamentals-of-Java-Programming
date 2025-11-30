package Meneses;
import java.util.Scanner;
public class Methods {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int choice, num1, num2;
	
	do {
		
		choice = 0;
		calcmenu();
		
		System.out.print("Choose your option: ");
		choice = sc.nextInt();
		sc.nextLine();
		
		
		switch (choice) {
		case 1: // addition
			System.out.print("Enter first number: ");
			num1 = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Enter second number: ");
			num2 = sc.nextInt();
			sc.nextLine();
			
			int add = sum(num1, num2);
			System.out.print("Answer: " + add);
			sc.nextLine();
			break;
			
			
			
		case 2: // subtraction
			System.out.print("Enter first number: ");
			num1 = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Enter second number: ");
			num2 = sc.nextInt();
			sc.nextLine();
			
			int subtract = diff(num1, num2);
			System.out.print("Answer: " + subtract);
			sc.nextLine();
			break;
			
		case 3: // multiply
			System.out.print("Enter first number: ");
			num1 = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Enter second number: ");
			num2 = sc.nextInt();
			sc.nextLine();
			
			int multiply = multi(num1, num2);
			System.out.print("Answer: " + multiply);
			sc.nextLine();
			break;
			
		case 4: // divide
			System.out.print("Enter first number: ");
			num1 = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Enter second number: ");
			num2 = sc.nextInt();
			sc.nextLine();
			
			int divide = divi(num1, num2);
			System.out.print("Answer: " + divide);
			sc.nextLine();
			break;
			
		case 5:
			System.out.print("Thank you for using the calculator!");
			break;
			
			default:
				System.out.print("Invalid Input!");
			
			
			
		}
		
		
		
		
	} while (choice!= 5);
		
	
		
	}
	
	
	
	
	
	static void calcmenu() {
		System.out.println("SIMPLE CALCULATOR");
		System.out.println("1. Addition \n2. Subtraction \n3. Multiplication \n4. Division \n5. Exit");
	}
	
	
	
	static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	static int diff(int num1, int num2) {
		return num1 - num2;
	}
	
	static int multi(int num1, int num2) {
		return num1 * num2;
	}
	
	static int divi(int num1, int num2) {
		return num1 / num2;
	}

}
