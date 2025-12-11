package FinalsPractice;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
public class TemperatureMonitoringandAlertSystem {
	
	
	//method 1
	
	static double[] inputTemperatures() {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("How many days of temperature data? ");
	int days = sc.nextInt();
	sc.nextLine();
	
	double[] temperature = new double[days];
	
	System.out.print("Enter temperature readings.");
	System.out.println();
	for (int i = 0; i < days; i++) {
		System.out.print("Day " + (i+1) + ": ");
		temperature[i] = sc.nextDouble();
		sc.nextLine();
		
	}
		return temperature;	
		
	}
	
	
	
	
	// method 2
	
	
	static String classifyWeather(double temperature) {
		if (temperature >= 35) {
			return "Extreme Heat";
		} else if (temperature >= 20) {
			return "Normal Weather";
		} else {
			return "Cold Weather";
		}	
		
	}
	
	
	
	// method 3
	
	static void saveReport(String data) {
		
		try {
			
			FileWriter fw = new FileWriter("weather_report.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.print(data);
			pw.close();
			fw.close();
			
			System.out.print("Saved to text file weather_report.txt");	
			
			
		}
		
		
		catch (IOException e) {
			System.out.print("An error has occured.");
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public static void main(String[] args) {
	
	
	double[] temp = inputTemperatures();
	
	StringBuilder weather_report = new StringBuilder();
	
	System.out.print("DAILY WEATHER REPORT");
	System.out.println();
	
	for (int i = 0; i < temp.length; i++) {
		
		
		
		String classification = classifyWeather(temp[i]);
		
		String info = String.format("Day %d: %.2f\u00B0C - %s \n", (i+1), temp[i], classification);
		
		System.out.print(info);
		
		weather_report.append(info).append("\n");
		
	}
	
	
	
	
	saveReport(weather_report.toString());
	
	
	
	
	
	
	
	
	
	
	
	
}
}
