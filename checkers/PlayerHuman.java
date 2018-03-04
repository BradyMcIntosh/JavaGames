package checkers;

/** 
 * Allows a human player to play a checkers game
 * 
 * @author Brady McIntosh
 * @version 0.1
 */
public class PlayerHuman extends Player {
	
	// TODO Adds human-specific functionality to Player class.
	
	private Board board;
	private Interface face;
	private int team;
	
	private int selRow = -1;
	private int selCol = -1;
	
	private boolean turnActive;
	
	/**
	 * Constructs a human player with the given interface, board and team parameters
	 * 
	 * @param face
	 * 			The given interface.
	 * @param board
	 * 			The given checkers board.
	 * @param team
	 * 			The given team.
	 */
	public PlayerHuman(Interface face, Board board, int team) {
		
		this.face = face;
		this.board = board;
		this.team = team;
	}
	
	/**
	 * Contains the main runtime loop, the turn ends when runTurn ends
	 */
	public void runTurn() {
		
		System.out.println("PlayerHuman.runTurn()");
		
		turnActive = true;
		
		face.showString("Type \"help\" for a list of options");
		
		// never ending loop
		while(true) {
			face.showBoard(team);
			getChoice();
			face.showBoard(team);
			getChoice();
			team = team == 1? 2: 1;
		}
	}
	
	/**
	 * Asks the user for the next command
	 */
	public void getChoice() {
		
		System.out.println("PlayerHuman.getChoice()");
		
		String input = face.getStringHeader("Please enter a command.");
		
		if(input.startsWith("sel") || input.startsWith("mov")) {
			if(checkSelectMove(input)) {
				if(input.startsWith("sel")) {
					face.showString("Piece selected.");
				}
				else {
					face.showString("Piece moved.");
				}
			}
		}
		else {
			//default
			face.showError("return with no input");
		}
	}
	
	/**
	 * Returns a String with an amount of characters taken from the beginning.
	 * 
	 * @param input
	 *            The initial given String.
	 * @param skip
	 *            The number of characters to drop.
	 * @return the given String after dropping the given number of characters.
	 */
	private String getAfter(String input, int skip) {
		
		String post = "";
		for(int i = skip; i < input.length(); i++) {
			post += input.charAt(i);
		}
		
		return post;
	}
	
	/**
	 * Returns the board location corresponding to a character.
	 * 
	 * @param a
	 * 			The given character.
	 * @return An int corresponding to the board location of the given character.
	 */
	private int getLoc(char loc) {
		
		int a = loc;
		
		if(a-'1' >= 0 && a-'1' < 8) {
			face.showString("loc = " + (a-'1'));
			return a - '1';
		}
		if(a-'a' >= 0 && a-'a' < 8) {
			face.showString("loc = " + (a-'a'));
			return a - 'a';
		}
		if(a-'A' >= 0 && a-'A' < 8) {
			face.showString("loc = " + (a-'A'));
			return a - 'A';
		}
		
		face.showString("loc char = " + loc);
		face.showString("loc int = " + a);
		face.showString("loc adj = " + (a - '1'));
		
		face.showError("Invalid board location.");
		return -1;
	}
	
	/**
	 * Determines if a select or a move action is possible, then 
	 * calls the relevant method, depending on which was indicated. 
	 * Returns whether or not an action was performed.
	 * 
	 * @param input
	 * 			The input String to be examined.
	 * @return True if an action was performed, false if not.
	 */
	private boolean checkSelectMove(String input) {
		
		String newInput = getAfter(input, 4);
		
		if(newInput.length() == 2) {
			
			int r = getLoc(newInput.charAt(1));
			int c = getLoc(newInput.charAt(0));
			
			face.showString("location: " + r + ", " + c);
			
			if(board.isLegal(r,c)) {
				
				face.showString("legal check");
				
				if(input.startsWith("sel")) {
					
					face.showString("startsWith \"sel\" check");
					
					if(board.isSelectable(r, c, team)) {
						selectPiece(r, c);
						return true;
					}
				}
				else {
					
					face.showString("startsWith \"mov\" check");
					
					if(board.canMove(selRow, selCol, r, c)) {

						movePiece(r, c);
						return true;
					}
				}
			}
		} 
		else {
			
			// TODO Error message?
		}
		
		return false;
	}
	
	/**
	 * Selects the piece at the given board location.
	 * 
	 * @param row
	 * 			The given row.
	 * @param col
	 * 			The given column.
	 */
	public void selectPiece(int row, int col) {
		
		selRow = row;
		selCol = col;
		
		face.showString("selected: " + row + col);
	}
	
	/**
	 * Moves the currently selected piece to the given location, 
	 * then resets the selected piece to default.
	 * 
	 * @param row
	 * 			The given row.
	 * @param col
	 * 			The given column.
	 */
	public void movePiece(int row, int col) {
		
		board.movePiece(selRow, selCol, row, col);
		selRow = -1;
		selCol = -1;
	}
	
}
