/* Jason Moreau
 * CISC 1115 - ETR6
 * Spring 2019
 * 
 * Assignment #3
 * This program will read in scores given by judges during the Olympic games 
 * It will track the best ID, single score, and average score
 */

package hw3; 

import java.util.Scanner;

public class hw3 {
	
	public static void emptyLine() {										// method prints a blank line in console
		System.out.println();
	}
	
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int id, judgeNum;
	double avgScore, minScore, maxScore, score, totalScore ;
	double bestAvg = 0, bestID = 0, highScore = 0, highScoreID = 0;		    // initialized variables will "save" values
	
	System.out.print("Enter an ID number: ");
	id = input.nextInt();
	
	while(id > 0) {														    // initialized variables reset values when while loop restarts
		totalScore = 0;
		avgScore = 0;
		score = 0;
		minScore = 10;
		maxScore = 0;
		System.out.print("Enter number of judges: ");
		judgeNum = input.nextInt();
		System.out.println("Enter scores: "); 
			for(int i = 1; i <= judgeNum; i++) { 							// loop to input scores
				score = input.nextDouble();
				if(score < minScore) {										// minimum score
					minScore = score; 
				}
				if(score > maxScore) {										// maximum score 
					maxScore = score;
				}
				if(score > highScore) {										// best single score
					highScore = score;
					highScoreID = id;				
				}
				totalScore = score + totalScore;							// sums scores in loop
		}	
			avgScore = (totalScore - minScore - maxScore) / (judgeNum - 2);  // formula for average score
			
			if(avgScore > bestAvg) {										// track best ID and best average
				bestAvg = avgScore; 
				bestID = id; 
			}	
			System.out.printf("ID: %d | Average score: %.1f.\n", id, avgScore);
			emptyLine();
			System.out.printf("Highest average score: %.1f [ID: %.0f]\n", bestAvg, bestID);
			System.out.printf("ID %.0f recorded the highest single score amongst all athletes [%.1f].\n", highScoreID, highScore);
			emptyLine();
			System.out.println("Enter another ID number to continue. Enter zero to STOP: ");
			id = input.nextInt(); 
			}	
	
	switch(id = 0) {													    // end of program 
	case 0: System.out.println("----END OF PROGRAM----");
	input.close();
	}
  }
} 
