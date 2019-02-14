/*Jason Moreau 
 * CISC 1115 - ETR6
 * Spring 2019
 * 
 * Assignment #1 
 * 
 * This program will evaluate and display the output of the equation: 4x^3 + 8x^2 - 31x - 35 / (3x^2 + 1)^1/2 + 2 * |x - 1.5|
 * The x-value will be all real numbers between -3 and +3 in increments of 0.5.
 * It will also tell the user which y-values are within 2 units (negative or positive) of zero.   
 * 
 */

	import java.lang.Math;   // imports math functions 
	public class assignmentmac 
		{
			public static void main(String[] args)
			{
				double x;   // x will be the independent variable of equation
				double y;   // y will be the dependent variable of equation
				int positive = 0;
				int negative = 0;
				int zero = 0;
				System.out.println("This program was created by Jason Moreau.\n");
				System.out.println("The following program evaluates and displays the output of the following equation:\n");
				System.out.println("y =      4x\u00B3 + 8x\u00B2 - 31x - 35\n");   // displays exponents using Unicode
				System.out.println("     ---------------------------\n");
				System.out.println("     (3x\u00B2 + 1)\u00B9\u2E0D\u00B2 + 2 * |x - 1.5|\n\n");   // displays exponents using Unicode
				
					for(x = -3.0; x <= 3.0; x+= 0.5)
						{
							y = (4 * Math.pow(x,3) + 8 * Math.pow(x,2) - 31 * x - 35) / 
									(Math.sqrt(3 * Math.pow(x,2) + 1) + 2 * Math.abs(x - 1.5)); 
							System.out.printf("x = " + x + " , " + "y = %.2f", y);
							
							if(y > 0)
								{
									System.out.println(", Y is POSITIVE"); 
								}
								 else if (y < 0)
								 {
									System.out.println(", Y is NEGATIVE");
								 }
									else if (y == 0)
								 {
									System.out.println(", Y is ZERO");
								 }
							if (y > 0)
								{	
									positive++; 
								}
							else if (y < 0)
								{
								    negative++;
								}
							else if (y == 0)
								{
									zero++; 
								}
					
							if(y >= -2.0 & y != 0 & y <= 2.0)
								{
									System.out.printf("This y-value is close to zero. " + 
									    "The associated x-value is " + x + ".");
									System.out.printf(" The distance from zero is: " + "%.2f", Math.abs(0-y));
									System.out.println("\n");
								}
						}
					System.out.println("\n");
					System.out.println("There are " + positive + " positive, " + negative + 
							" negative and " + zero + " zero " + "y-values displayed in this output.\n");
					System.out.println("This program is complete.");  
			}
		} 
