/*Jason Moreau  
 * CISC 1115 - ETR6
 * Spring 2019
 * 
 * Assignment #2 
 * 
 * This program will compute baseball statistics by reading in ID numbers, win-loss record,
 * games remaining in the season and how many teams are in the league. 
 * 
 * Program will also keep track of the team with best winning average and the predict win/loss record
 * and winning average based on games remaining
 * 
 */ 

import java.util.Scanner;

public class hw2 
	{
		public static void main(String[] args)
		{
			Scanner input = new Scanner(System.in);
			int id, leagueTotal = 0, bestTeam = 0, losses, wins, gp, gr, wingr, losegr;
			double pct, newPct, bestAvg = 0;
			System.out.print("Please enter an ID number from 1-10: ");
			id = input.nextInt(); 

			while (id > 0) {
				
				if (id >= 11) {			  // only a ID number of 10 or less can be used; loop restarts if greater than 10
					System.out.println("Invalid number. Number must be between 1 and 10."); 
				  }
				else {				      // program will continue if previous condition is met
				System.out.print("Please enter number of wins: ");
				wins = input.nextInt();   // number of team wins
				System.out.print("Please enter number of losses: \n");
				losses = input.nextInt(); // number of team losses
				gp = (wins + losses);     // formula for total games played
				gr = (25 - gp);			  // formula for total games remaining
				pct = (double)wins / gp;  // formula for winning percentage; temporally converts wins integer to a double
				
				if (gp > 25) {			  // will skip to end of loop and restart if games played greater than 25
					System.out.println("Games played cannot exceed 25. Please enter another value."); continue;
				}
				
				System.out.println("Team     W     L     AVG");   
				System.out.printf("%-5d    %d     %d    %.4f" , id, wins, losses, pct); // first formatter adds 5 spaces after output
				System.out.println("\n");
				
					if(gr == 0) {		 // statement will be displayed when all games have been played
							System.out.print(gp + " games played.");
							System.out.println(" The season is over.\n");
						}
							else {
								System.out.print(gp + " game(s) played. ");
								System.out.println(gr + " game(s) remain in the season.\n");
							}
					if(gr >= 1) {		 // statement will predict team record and winning average if remaining games are won
							wingr = gr + wins; 
							newPct = (double)wingr / 25; 
							System.out.printf("If they win their remaining games, their record will be: %d win(s) and %d losses.\n", wingr, losses);
							System.out.printf("Their winning average will increase to %.4f.\n", newPct);
					 	}
					if(gr >= 1) {  		 // statement will predict team record and winning average if remaining games are lost
							losegr = gr + losses; 
							newPct = (double)losegr / 25;  
							System.out.printf("If they lose their remaining games, their record will be: %d win(s) and %d losses.\n", wins, losegr);
							System.out.printf("Their winning average will decrease to %.4f.\n\n", 1 - newPct);
						}
					if(gr >= wins) {	 // statement determines if games remaining is greater than number won
							System.out.println("The number of games remaining is greater than or equal to" + 
										" the number won.");
						}
							else {
								System.out.println("The number of games remaining is less than or equal to" + 
										" the number won.");
							}
					if(gr >= losses) {   // statement determines if games remaining is greater than number lost
							System.out.println("The number of games remaining is greater than or equal to" + 
									" the number lost.");
						} 
							else {
								System.out.println("The number of games remaining is not greater than the" +
									" number lost.");
							}
					if(pct > bestAvg)    //	tracks team with best winning average  
						if(pct != 1) {   //	winning percentage cannot equal 1
						bestAvg = pct;   //	places average into new tracking variable
						bestTeam = id;   //	places id into new tracking variable
					}

				}
				System.out.println("\nPlease enter another ID number. " +
				"Enter zero to STOP");
				
				leagueTotal++;		     //	increments after loop is complete
				if (id >= 11)   	     //	decrement so that teams are not added to final total if user enters ID greater than 10
					leagueTotal--; 
				id = input.nextInt();
			
				if (id == 0) {	  	     //	message is displayed when user enters zero; end of program
						System.out.println("\nThere are a total of " + leagueTotal + " team(s) in the league."); 
						System.out.printf("Team " + "%d" + " has the best winning average of " + 
								"%.4f", bestTeam, bestAvg);
						System.out.println("\n\n----End of program----"); 
						input.close();   // close Scanner
					}
				} 
			} 
	}
