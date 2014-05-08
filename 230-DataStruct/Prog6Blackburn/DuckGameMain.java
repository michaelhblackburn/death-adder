/*
 *Michael Blackburn
 *DuckGameMain.java
 *Main method for duck splash game
 */
import java.util.ArrayList;

public class DuckGameMain{
	public static void main(String[] args){
		int[] ducks = DuckReader.read("ducks.txt");
		ArrayList toss = TossReader.read("balloons.txt");
		Toss[] tosses = new Toss[toss.size()];
		int score = 0;
		RubberDuckBST tree = new RubberDuckBST();
		System.out.println("DUCK SPLASH!");
		System.out.println("Bring on the ducks!");
		System.out.println();
		boolean success = false;

		for(int t = 0; t < toss.size(); t++){
			tosses[t] = (Toss)toss.get(t);
		}
		
		for(int i = 0; i < ducks.length; i++){
			tree.insert(ducks[i]);
		}
		System.out.println();
		for(int j = 0; j < tosses.length; j++){
			int coord = tosses[j].getCoord();
			int rad = tosses[j].getRadius();
			int val = tree.checkToss(coord, rad);
			if(val != -1){
				score++;
				System.out.println("Balloon tossed at position " + coord + " with splash radius " +
									rad + " splooshes duck at position " + val + ".");
				System.out.println("Score = " + score);
				System.out.println();
			}
			else{
				System.out.println("Balloon tossed at position " + coord + " with splash radius " +
									rad + " missed.");
				System.out.println("Score = " + score);
				System.out.println();
			}
		}
		System.out.println("Your final score is " + score + " points.");
	}
}
