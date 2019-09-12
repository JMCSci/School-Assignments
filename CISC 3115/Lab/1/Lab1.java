/* Lab 1 
 * Program prompts user to enter a series of exam grades
 * Arrays are not used in this program
 * Once complete, the highest grade, lowest grade and average are printed to the console
 */


package lab9_11;

import java.util.Scanner; 

public class Lab9_11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int grade = 0, hiGrade = 0, lowGrade = 0, count = 0, sum = 0;
		double average = 0; 
		System.out.println("Enter a grade: ");
		grade = input.nextInt();
		lowGrade = grade;
		hiGrade = grade;
		
		while(grade > 0) {
			System.out.println("Grade is " + grade);
			if(grade > hiGrade) {
				hiGrade = grade;
			}
			else if(grade < lowGrade) {
				lowGrade = grade;
			}
			count++;
			// Find average 
			sum = sum + grade; 
			average = sum / count;
			System.out.println("Enter another grade or enter -1 to stop: ");
			grade = input.nextInt();
		}
		blank();
		System.out.println("The highest grade entered is: " + hiGrade);
		System.out.println("The lowest grade entered is: " + lowGrade);
		System.out.println("The grade average is: " + average);
		System.out.println("\n*** END OF PROGRAM ***");
		input.close();
	}
	
/* METHOD: blank() prints an empty line */
	public static void blank() {
		System.out.println();
	}


}
