package checkers;

public abstract class Interface {
	
	// TODO Codify display and input functionality.
	
	public abstract void setBoard(Board board);
	
	public abstract char getChoiceWithCode(String header, char[] codes, String[] choices);
	public abstract char getChoiceNoCode(String header, String[] choices);
	
	public abstract String getStringHeader(String header);
	public abstract int getIntHeader(String header);
	public abstract char getCharHeader(String header);
	
	public abstract void showStartScreen();
	public abstract void showEndScreen();
	public abstract void showBoard(int currentPlayer);
	public abstract void showScore();
	public abstract void showHelp();
	public abstract void showError(String error);
	
	public abstract void showString(String string);
	
	
}
