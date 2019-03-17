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
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int id;
	double minScore, maxScore, totalScore, score, judgeID, avgScore;
	double bestAvg = 0, bestID = 0, highScore = 0, highScoreID = 0;
	
	System.out.print("Enter an ID number: ");
	id = input.nextInt();
	
	while(id > 0) {
		totalScore = 0;
		avgScore = 0;
		score = 0;
		minScore = 10;
		maxScore = 0;
		System.out.print("Enter number of judges: ");
		judgeID = input.nextInt();
		System.out.println("Enter scores: "); 
		
			for(int i = 1; i <= judgeID; i++) { 
				score = input.nextDouble();
				if(score < minScore) {										// minimum score
					minScore = score; 
				}
				if(score > maxScore) {										// maximum score 
					maxScore = score;
				}
				
				if(score > highScore) {
					highScore = score;
					highScoreID = id;
					
				}
				totalScore = score + totalScore;

		}	
			avgScore = (totalScore - minScore - maxScore) / (judgeID - 2);  // formula for average score
			
			if(avgScore > bestAvg) {										// track best ID and best average
				bestAvg = avgScore; 
				bestID = id; 
			}
				
			System.out.println("Best ID : " + (int)bestID+ " | Best average: " + bestAvg);
			System.out.println("ID number " + (int)highScoreID + " had the best single score of " + highScore);
			 
			System.out.println("Enter an ID number. Enter zero to STOP: ");
			id = input.nextInt(); 
			
	}
  }
}
