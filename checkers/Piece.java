package checkers;

/**
 * A piece for a checkers board.
 * 
 * @author Brady McIntosh
 * @version 0.1
 */
class Piece {
	
	private int team;
	private boolean king;
	
	/**
	 * Constructs a piece with a given team int and a default (false) king boolean.
	 * 
	 * @param team
	 * 			The given team int.
	 */
	Piece(int team) {
		this.team = team;
		this.king = false;
	}
	
	/**
	 * Constructs a piece with a given team int and a given king boolean.
	 * 
	 * @param team
	 * 			The given team int.
	 * @param king
	 * 			The given king boolean.
	 */
	Piece(int team, boolean king) {
		this.team = team;
		this.king = king;
	}
	
	/**
	 * Sets a given king value on this piece.
	 * 
	 * @param king
	 * 			The given king value.
	 */
	public void setKing(boolean king) {
		this.king = king;
	}
	
	/**
	 * Sets a given team int on this piece.
	 * 
	 * @param team
	 * 			The given team int.
	 */
	public void setTeam(int team) {
		this.team = team;
	}
	
	/**
	 * Returns this piece's king boolean.
	 * 
	 * @return The king boolean of this piece.
	 */
	public boolean getKing() {
		return this.king;
	}
	
	/**
	 * Returns this piece's team int.
	 * 
	 * @return The team int of this piece.
	 */
	public int getTeam() {
		return this.team;
	}
}
