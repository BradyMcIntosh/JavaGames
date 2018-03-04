
import java.util.Scanner;

/**
 * Handles top-level interface requirements while no game is running.
 * 
 * @author Brady McIntosh
 * @version 0.1
 */
class MenuCMD {
	
	// TODO Handle top-level interface requirements.
	
	Scanner in = new Scanner(System.in);
	
	private char getUserChar() {
		
		return in.next().charAt(0);
	}
	
	public char gameChoice() {
		
		System.out.println("What game would you like to play?");
		System.out.println("c = checkers");
		
		return getUserChar();
	}
	
	public char playAgain() {
		
		System.out.println("Would you like to play another game?");
		System.out.println("y = yes");
		System.out.println("n = no");
		
		return getUserChar();
	}
	
	public void exitPrompt() {
		
		System.out.println("Goodbye.");
	}
	
	
	
	
	
}
