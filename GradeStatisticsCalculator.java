package FinalsPractice;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
public class GradeStatisticsCalculator {

	
	// method one
	
	static double[] inputScores() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many students? ");
		int students = sc.nextInt();
		sc.nextLine();
		
		double[] scores = new double[students];
		
		
		System.out.print("Enter final exam scores. (100 items) \n");
		for (int i = 0 ; i < students ; i++) {
			System.out.print("Student " + (i+1) + ": ");
			scores[i] = sc.nextDouble();
			sc.nextLine();
			
		}
		
		return scores;
	}
	
	
	
	// method two
	
	
	static String computeStats(double scores) {
		double difference = 100 - scores;
		double percentage = (scores / 100) * 100;
		double adjusted = scores + 5;
				if (adjusted > 100) {
					adjusted = 100;
				}
				
	return String.format("Difference: %.2f  |  Percentage: %.2f%%  |  Adjusted score: %.2f", difference, percentage, adjusted);
	}
	
	
	
	// method three
	
	static void saveReport(String data) {
		try {
			FileWriter fw = new FileWriter("grade_report.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.print(data);
			pw.close();
			fw.close();
			
			System.out.print("Saved to text file grade_report.txt");
		}
		
	catch (IOException e) {
		System.out.print("An error has occured !");
	}
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		
	double[] scores = inputScores();
	
	StringBuilder summary = new StringBuilder();
	
	System.out.println();
	
	for (int i = 0 ; i < scores.length ; i++) {
		
		String stats = computeStats(scores[i]);
		String line = String.format("Student %d: SCORE: %.2f  |  %s \n", (i+1), scores[i], stats);
		
		System.out.print(line);
		summary.append(line).append("\n");
	}
	
	
	saveReport(summary.toString());
		

	}

}
