

class Session {
	
	
	private void startCheckers() {
		
		Checkers c = new Checkers(0);
		
		c.cycleTurns();
		
	}
	
	public static void main(String[] args) {
		
		// TODO Begin game and construct all necessary classes.
		Session game = new Session();
		MenuCMD menu = new MenuCMD();
		
		do {
			if(menu.gameChoice() == 'c') {
				game.startCheckers();
			}
		} while(menu.playAgain() == 'y');
		
		menu.exitPrompt();

	}

	
}
