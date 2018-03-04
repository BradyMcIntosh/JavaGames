package checkers;

/**
 * Codifies interactions between user and board.
 * 
 * @author Brady McIntosh
 * @version 0.1
 */
public abstract class Player {
	
	private int selRow;
	private int selCol;
	
	public abstract void runTurn();
	public abstract void getChoice();
	public abstract void selectPiece(int row, int col);
	public abstract void movePiece(int row, int col);
	
	

	// TODO Codify interactions between user and board.
	
}
