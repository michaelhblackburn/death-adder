/*Michael Blackburn
  CSCI 221
  Exercise09_12.java*/
  
/*This program reads to strings from the user and compares them to see if they are anagrams of each other.*/

import java.util.Scanner;
import java.util.Arrays;

public class Exercise09_12{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first string to compare: ");
		String s1 = input.nextLine();
		System.out.print("Enter the second string to compare: ");
		String s2 = input.nextLine();
		boolean areAnagrams = isAnagram(s1, s2);
		if (areAnagrams == true)
			System.out.println(s1 + " and " + s2 + " is anagram");
		else
			System.out.println(s1 + " and " + s2 + " is not anagram");

	}
	
	public static boolean isAnagram(String s1, String s2){
		char [] c1 = s1.toCharArray();
		char [] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		boolean equal = Arrays.equals(c1, c2);
		return equal;
	}
}