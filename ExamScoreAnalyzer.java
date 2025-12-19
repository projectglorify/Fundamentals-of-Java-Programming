package FinalsPractice;
import java.io.*;
import java.util.*;
public class ExamScoreAnalyzer {
	
	
	
	// method 1
	
	static double[] inputScores() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many students? ");
		int students = sc.nextInt();
		sc.nextLine();
		
		
		double[] scores = new double[students];
		
		System.out.print("Enter exam scores of " + students + " students. \n\n");
		for (int i = 0; i < students; i++) {
			System.out.print("Student " + (i+1) + " score: ");
			scores[i] = sc.nextDouble();
			sc.nextLine();
		}
		return scores;
	}
	
	
	
	// method 2
	
	
	static String evaluateResult(double scores) {
		if (scores >= 90) {
			return "Excellent!";
		} else if (scores >= 75 && scores <= 89) {
			return "Passed.";
		} else {
			return "Failed.";
		}
	}
	
	
	
	// method three
	
	static void scoresEvaluation(String evaluation) {
		try {
			FileWriter fw = new FileWriter("student_results.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			
			pw.print(evaluation);
			pw.close();
			fw.close();
			
			
		}
		
		catch (IOException err) {
			System.err.print("An error has occured.");
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		
	double[] scores = inputScores();
	
	StringBuilder evaluation = new StringBuilder();
	
	System.out.println();
	
	for (int i = 0; i < scores.length; i++) {
		String evaluate = evaluateResult(scores[i]);
		
		String info = String.format("Student: %d | Grade: %.2f = %s \n", (i+1), scores[i], evaluate);
		
		System.out.print(info);
		evaluation.append(info).append("\n");
	}
	
	scoresEvaluation(evaluation.toString());

	}

}
