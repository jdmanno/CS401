package game;

import java.util.*;

public class PlayGame {
	public static void main(String[] args) {
		System.out.println("Start Game");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of players: ");
		int numPlayers = scan.nextInt();
		scan.close();
		
		ArrayList<Player> players = new ArrayList();
		for (int i = 0; i < numPlayers; i++) {
			players.add(new Player(i));
			players.get(i).start();
		}
		
		// Player 1: 2 gold
		// Player 2: 1 gold, 1 compass
		// Player 3: 2 gold, 1 compass
		// Player 4: 1 gold, 2 compass
		
		int round = 1; 
		// At each end of round, archaeologists return to players
		// Market = 6 slots. #Artifacts = (6 - round #)
	}
}
