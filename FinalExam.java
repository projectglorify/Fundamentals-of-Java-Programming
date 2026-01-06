package FinalsPractice;
import java.io.*;
import java.util.*;
public class FinalExam {
	
	
	static String temperatureCategory(double temperature) {
		if (temperature >= 10) {
			return "UNSAFE TEMPERATURE (too warm)";
		} else if (temperature >=3 && temperature < 10) {
			return "MODERATE TEMPERATURE";
		} else {
			return "SAFE TEMPERATURE {cold enough)";
		}
	}
	
	
	
	static void writeToFile(String data) {
		try {
			FileWriter fw = new FileWriter("temperature_report.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.print(data);
			pw.close();
			fw.close();
		}
		
		catch (IOException e) {
			System.err.print("There was an error writing file to text.");
		}
	}
	

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many refrigerator? ");
		int num = sc.nextInt();
		sc.nextLine();
		
		double[] temperature = new double[num];
		
		System.out.println("Enter temperature of " + num + " refrigerators (in C).");
		
		for (int i = 0; i < num; i++) {
			System.out.print("Fridge " + (i+1) + ": ");
			temperature[i] = sc.nextDouble();
			sc.nextLine();
		}
		
		
		
		StringBuilder ref = new StringBuilder();
		System.out.println();
		
		
		for (int i = 0; i < num; i++) {
			String category = temperatureCategory(temperature[i]);
			
			String line = String.format("Fridge: %d - %.2f - %s \n", (i+1), temperature[i], category);
			System.out.print(line);
			ref.append(line).append("\n");
			
		}
		
		writeToFile(ref.toString());

	}

}
