/*Jason Moreau  
 * CISC 1115 - ETR6
 * Spring 2019
 * 
 * Assignment #2 
 * 
 * This program will compute baseball statistics by reading in ID numbers, win-loss record,
 * games remaining in a season and how many teams are in the league. 
 * 
 */ 

import java.util.Scanner; 
public class hw2 
	{
		public static void main(String[] args)
		{
			Scanner input = new Scanner(System.in);
			int id, leagueTotal = 0, loses, wins, gp, gr;
			double pct; 
			char letter; 
			System.out.print("Please enter an ID number: ");
			id = input.nextInt(); 
			 
			while (id > 0)
			{
				System.out.print("Please enter number of wins: ");
				wins = input.nextInt(); // number of team wins
				System.out.print("Please enter number of loses: "); 
				loses = input.nextInt(); // number of team losses
				gp = (wins + loses); 	//	formula for total games played
				gr = (25 - gp);			// 	formula for total games remaining
				pct = (double)wins / gp; // formula for winning percentage; temporally converts wins integer to a double
				System.out.println("ID     W     L     AVG");   
				System.out.printf(id + "     " + wins + "     " + loses + "     " + "%.4f" , pct); 
				System.out.println("\n");
					if (gp > 25)	// continue will skip to end of loop and restart
						{
							System.out.println("Games played cannot exceed 25. Please enter another value."); continue;
						}
					if(gr == 0) 	// statement will be displayed when all games have been played
						{
							System.out.print(gp + " games played.");
							System.out.println(" The season is over.\n");
						}
							else
							{
								System.out.print(gp + " game(s) played. ");
								System.out.println(gr + " game(s) remain in the season.\n");
							}
					if(gr >= wins)	//	statement determines if games remaining is greater than number won
						{
							System.out.println("The number of games remaining is greater than or equal to" + 
										" the number won.");
						}
							else
							{
								System.out.println("The number of games remaining is less than or equal to" + 
										" the number won.");
							}
					if(gr >= loses)	//	statement determines if games remaining is greater than number lost
						{
							System.out.println("The number of games remaining is greater than or equal to" + 
									" the number lost.");
						} 
							else
							{
								System.out.println("The number of games remaining is not greater than the" +
									" number lost.");
							}
				System.out.println("\nPlease enter another ID number. " +
				"Enter zero to STOP");
				leagueTotal++;		//	increments after loop is complete
				id = input.nextInt();   
				
				if (id == 0)		//	message is displayed when user enters zero
					{
						System.out.println("There are a total of " + leagueTotal + " team(s) in the league."); 
					}
			} 
		} 
	}
