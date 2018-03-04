package checkers;

import java.util.Scanner;

/**
 * Adds command-line-specific functionality to Interface class.
 * 
 * @author Brady McIntosh
 * @version 0.1
 */
public class InterfaceCMD extends Interface {
	
	// TODO Add command-line-specific functionality to Interface class.
	
	private final char X_UP = 'X';
	private final char X_LO = 'x';
	private final char O_UP = 'O';
	private final char O_LO = 'o';
	
	private Board board;
	private Scanner in = new Scanner(System.in);
	
	public void setBoard(Board board) {
		
		this.board = board;
	}
	
	public char getChoiceWithCode(String header, char[] codes, String[] choices) {
		
		char option;
		boolean valid = false;
		
		
		// tests if arrays are of equal length, for debugging purposes
		if(codes.length != choices.length) {
			
			showError("code.length inequal to choices.length");
		}
		
		// print header, codes and choices and take user input
		do {
			
			System.out.println(header);
			for(int i = 0; i < codes.length; i++) {
				System.out.println(codes[i] + ": " + choices[i]);
			}
			option = getChar();
			
			for(char code : codes) {
				if (code == option) {
					valid = true;
					break;
				}
			}
			
			if(!valid) {
				showError("Please enter a valid option.");
			}
		// repeat loop if user input is invalid
		} while(!valid);
		
		return option;
	}
	
	public char getChoiceNoCode(String header, String[] choices) {
		
		char[] codes = new char[choices.length];
		
		for(int i = 0; i < choices.length; i++) {
			char code = (char)('a'+i);
			codes[i] = code;
		}
		
		return getChoiceWithCode(header, codes, choices);
	}
	
	public String getStringHeader(String header) {
		
		System.out.println(header);
		return getString();
	}
	
	private String getString() {
		
		return in.nextLine();
	}
	
	public int getIntHeader(String header) {
	
		System.out.println(header);
		return getInt();
	}
	
	private int getInt() {
		
		int input = in.nextInt();
		in.nextLine();
		
		return input;
	}
	
	public char getCharHeader(String header) {
		
		System.out.println(header);
		return getChar();
	}
	
//	private char getChar0(String option) {
//		
//		return option.charAt(0);
//	}
	
	private char getChar() {
		
		char input =  in.next().charAt(0);
		in.nextLine();
		
		return input;
	}
	
	public void showStartScreen() {
		
		System.out.println("\n  = = = = = = = = = =\n"+
				"  = C H E C K E R S =\n"+
				"  = W I T H   T H E =\n"+
				"  = B R A D S T E R =\n"+
				"  = = = = = = = = = =\n");
	}
	
	public void showEndScreen() {
		
	}
	
	public void showBoard(int team) {
		
		System.out.println("InterfaceCMD.showBoard()");
		
		String boardPrint = new String();
		
		if(team == 1) {
			boardPrint += "\n    a b c d e f g h  \n";
			boardPrint += "  = = = = = = = = = =\n";
			for(int row = 0; row < 8; row++) {
				
				boardPrint += (row+1)+" = ";
				for(int col = 0; col < 8; col++) {
					
					boardPrint += getPiece(row, col);
					boardPrint += " ";
				}
				boardPrint+= "=\n";
			}
		}
		else {
			boardPrint += "\n    h g f e d c b a  \n";
			boardPrint += "  = = = = = = = = = =\n";
			for(int row = 7; row > -1; row--) {
				
				boardPrint += (row+1)+" = ";
				for(int col = 7; col > -1; col--) {
					
					boardPrint += getPiece(row, col);
					boardPrint += " ";
				}
				boardPrint+= "=\n";
			}
		}
		
		boardPrint += "  = = = = = = = = = =\n";
		
		System.out.println(boardPrint);
	}
	
	private char getPiece(int row, int col) {
		
		if(!board.isNull(row, col)) {
			return getSymbol(row, col);
		}
		
		return '-';
	}
	
	private char getSymbol(int row, int col) {
		
		if (board.getTeam(row, col) == 1) {
			if (board.getKing(row, col) == true) {
				return X_UP;
			}
			else {
				return X_LO;
			}
		}
		else {
			if (board.getKing(row, col) == true) {
				return O_UP;
			}
			else {
				return O_LO;
			}
		}
		
	}
	
	public void showScore() {
		
	}
	public void showHelp() {
		
	}
	public void showError(String error) {
		
		showString("Error: " + error);
	}
	
	public void showString(String string) {
		
		System.out.println(string);
	}
}
