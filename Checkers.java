import checkers.Board;
import checkers.Interface;
import checkers.InterfaceCMD;
import checkers.Player;
import checkers.PlayerHuman;
import checkers.PlayerComputer;

/**
 * Hosts an interface, board, and two players for a checkers game.
 * 
 * @author Brady McIntosh
 * @version 0.1
 */
public class Checkers {

	// TODO Create a checkers board and host two players.
	
	private Interface face;
	private Board board;
	private Player p1, p2;
	
	/**
	 * Sets up an interface, board and player for a checkers game.
	 * 
	 * @param code Determines the kind of game that will be created.
	 */
	public Checkers(int code) {
		
		if(code==0) {
			face = new InterfaceCMD();
		}
		
		face.showStartScreen();
		
		
		String[] boardChoices = {"standard game"};
		char gc = face.getChoiceNoCode("What type of checkers game would you like to play?",boardChoices);
		
		if(gc=='a') {
			board = new Board(0);
			face.setBoard(board);
		}
		
		
		String[] matchupChoices = {"human vs. human"};
		char mc = face.getChoiceNoCode("Please specify a player matchup.",matchupChoices);
		
		if(mc=='a') {
			p1 = new PlayerHuman(face, board, 1);
			p2 = new PlayerHuman(face, board, 2);
		}
		
	}
	
	/**
	 * Runs through each player's turns.
	 */
	public void cycleTurns() {
		
		System.out.println("Checkers.cycleTurns()");
		
		p1.runTurn();
		
		p2.runTurn();
	}
	
	//private char getChoicesAZ(String header, String[] choices) {
	//	
	//	return face.getChoiceNoCode(header, choices);
	//}
	
	
	
	

}
