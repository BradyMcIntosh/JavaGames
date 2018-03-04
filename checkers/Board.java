package checkers;

/**
 * Assembles and manipulates pieces for a checkers game.
 * 
 * @author Brady McIntosh
 * @version 0.1
 */
public class Board {
	
	// TODO Assemble and manipulate pieces.
	
	private final int ROW = 8, COL = 8;
	
	private Piece[][] pieces = new Piece[ROW][COL];

	/**
	 * Puts down pieces in a specified order and layout.
	 * 
	 * @param code Determines piece layout.
	 */
	public Board(int code) {
		
		// standard board setup
		if(code==0) {
			
			for(int j = 0; j < (COL-5); j++) {
				
				for(int p = 0 + (j % 2); p < ROW; p+=2) {
					
					pieces[j][p] = new Piece(2);
					
					// debug:
					// System.out.println("" + j + p + 2);
				}
			}
			for(int j = (COL-3); j < COL; j++) {
				
				for(int p = 0 + (j % 2); p < ROW; p+=2) {
					
					pieces[j][p] = new Piece(1);
					
					// debug:
					// System.out.println("" + j + p + 1);
				}
			}
		}
	}
	
	/**
	 * Returns the team of the specified piece.
	 * 
	 * @param row
	 * 			The given row.
	 * @param col
	 * 			The given column.
	 * @return Returns the piece's team integer.
	 */
	public int getTeam(int row, int col) {
		
		return pieces[row][col].getTeam();
	}
	
	/**
	 * Returns the king state of the specified piece.
	 * 
	 * @param row
	 * 			The given row.
	 * @param col
	 * 			The given column.
	 * @return Returns the piece's boolean king value.
	 */
	public boolean getKing(int row, int col) {
		
		return pieces[row][col].getKing();
	}
	
	/**
	 * Sets the team integer of the specified piece to the specified value.
	 * 
	 * @param row
	 * 			The given row.
	 * @param col
	 * 			The given column.
	 * @param team
	 * 			The given team value.
	 */
	public void setTeam(int row, int col, int team) {
		
		pieces[row][col].setTeam(team);
	}
	
	/**
	 * Sets the boolean king value of the specified piece to the specified value.
	 * 
	 * @param row
	 * 			The given row.
	 * @param col
	 * 			The given column.
	 * @param king
	 * 			The given king value.
	 */
	public void setKing(int row, int col, boolean king) {
		
		pieces[row][col].setKing(king);
	}
	
	/**
	 * Checks if the specified board location has a piece that can be selected by the current player.
	 * 
	 * @param row
	 * 			The given row.
	 * @param col
	 * 			The given column.
	 * @param team
	 * 			The team of the current player.
	 * @return Returns true if a piece exists and is selectable. Returns false otherwise.
	 */
	public boolean isSelectable(int row, int col, int team) {
		
		if(isLegal(row, col)) {
		
			if(!isNull(row,col)) {
				
				if(pieces[row][col].getTeam() == team) {
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Checks if the specified board location is legal (exists on the board).
	 * 
	 * @param row
	 * 			The given row.
	 * @param col
	 * 			The given column.
	 * @return Returns true if the board location is legal. Returns false otherwise.
	 */
	public boolean isLegal(int row, int col) {
		
		if((row >= 0 && row < ROW) && (col >= 0 && col < COL)) {
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks if the specified board location has a piece on it or not.
	 * 
	 * @param row
	 * 			The given row.
	 * @param col
	 * 			The given column.
	 * @return Returns true if a piece exists at the given location. Returns false otherwise.
	 */
	public boolean isNull(int row, int col) {
		
		if(pieces[row][col] == null) {
			
			return true;
		}
		
		return false;
	}

	/**
	 * Counts all possible moves available for the specified piece.
	 * 
	 * @param row
	 * 			The given row.
	 * @param col
	 * 			The given column.
	 * @return Returns an integer representing the number of possible moves. 
	 * Returns zero if there are no possible moves, 
	 * or if there is no piece at the specified location.
	 */
	public int countMoves(int row, int col) {
		
		//TODO Count how many moves the specified piece has available
		
		int moves = 0;
		int team = getTeam(row,col);
		
		// check for number of possible normal moves in given piece
		for(int i = -1; i <= 1; i+=2) {
			
			for(int j = -1; j <= 1; j+=2) {
				
				if(isLegal(row + i, col + j)) {
					
					if(canMove(row, col, row + i, row + j)) {
						
						moves++;
					}
				}
			}
		}
		
		// check for number of possible jump moves in given piece
		for(int i = -2; i <= 2; i+=4) {
			
			for(int j = -2; j <= 2; j+=4) {
				
				if(isLegal(row + i, col + j)) {
					
					if(canJump(row, col, row + i, row + j, team)) {
						
						moves++;
					}
				}
			}
		}
		
		return moves;
	}
	
	/**
	 * Checks if a specified move, from one location to another, is possible.
	 * 
	 * @param row1
	 * 			The row to move from.
	 * @param col1
	 * 			The column to move from.
	 * @param row2
	 * 			The row to move to.
	 * @param col2
	 * 			The column to move to.
	 * @return Returns true if a piece exists at the first location, 
	 * no piece exists at the second, and the locations are diagonally adjacent.
	 */
	public boolean canMove(int row1, int col1, int row2, int col2) {
		
		//TODO Check if specified piece can move to specified board location
		
		if(!isNull(row1,col1) && isNull(row2,col2)) {
				
			if(Math.abs(row1 - row2) == 1 && Math.abs(col1 - col2) == 1) {
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Checks if a specified jump, from one location to another,
	 * over an enemy piece, is possible.
	 * 
	 * @param row1
	 * 			The row to jump from.
	 * @param col1
	 * 			The column to jump from.
	 * @param row2
	 * 			The row to jump to.
	 * @param col2
	 * 			The column to jump from.
	 * @param team
	 * 			The team of the current player.
	 * @return Returns true if a piece exists at the first location,
	 * no piece exists at the second location, a piece exists between these locations,
	 * and that piece's team is not the player's current team.
	 */
	public boolean canJump(int row1, int col1, int row2, int col2, int team) {
		
		//TODO Check if specified piece can jump to specified board location
		
		if(!isNull(row1,col1) && isNull(row2,col2)) {
				
			if(Math.abs(row1 - row2) == 2 && Math.abs(col1 - col2) == 2) {
				
				int rowTemp,colTemp;
				
				if(row1 - row2 == 2) {
					rowTemp = row1 - 1;
				}
				else if(row1 - row2 == -2) {
					rowTemp = row1 + 1;
				} 
				else {
					return false;
				}
				
				if(col1 - col2 == 2) {
					colTemp = col1 - 1;
				}
				else if(col1 - col2 == -2) {
					colTemp = col1 + 1;
				}
				else {
					return false;
				}
				
				if(!isNull(rowTemp,colTemp)) {
					
					if(getTeam(rowTemp,colTemp) != team) {
						
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Moves a piece at the first location to the second location.
	 * 
	 * @param row1
	 * 			The row to move from.
	 * @param col1
	 * 			The column to move from.
	 * @param row2
	 * 			The row to move to.
	 * @param col2
	 * 			The column to move to.
	 */
	public void movePiece(int row1, int col1, int row2, int col2) {
		
		pieces[row2][col2] = pieces[row1][col1];
		pieces[row1][col1] = null;
		
	}
	
}
