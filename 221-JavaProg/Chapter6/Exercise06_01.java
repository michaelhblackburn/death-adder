/*Michael Blackburn
  CSCI 221
  Exercise06_01.java*/
  
/*This program reads in student scores from the user, finds the best grade, and assigns
  grades relative to the best grade.*/
  
import java.util.Scanner;

public class Exercise06_01{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of grades: ");
		int numGrades = input.nextInt();
		int [] grade = new int[numGrades];
		char [] letterGrade = new char[numGrades];
		int max = 0;
		for (int i = 0; i < numGrades; i++){
			System.out.print("Enter a grade: ");
			grade[i] = input.nextInt();
			if (grade[i] > max){
				max = grade[i];
			}
		}
		for (int i = 0; i < numGrades; i++){
			if (grade[i] >= (max - 10))
				letterGrade[i] = 'A';
			else if (grade[i] >= (max - 20))
				letterGrade[i] = 'B';
			else if (grade[i] >= (max - 30))
				letterGrade[i] = 'C';
			else if (grade[i] >= (max - 40))
				letterGrade[i] = 'D';
			else
				letterGrade[i] = 'F';
		}
		for (int i = 0; i < numGrades; i++){
			System.out.println("Student " + i + " score is " + grade[i] + 
								" and grade is " + letterGrade[i]);
		}
	}
}