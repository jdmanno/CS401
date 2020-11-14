package game;

import java.util.*;

public class PlayGame {
	public static void main(String[] args) {
		System.out.println("Start Game");
		
		// Initialize map tiles 
		Map map = new Map();
		map.start();
		
		// Initialize number of players
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of players: ");
		int numPlayers = scan.nextInt();
		System.out.print("\n");
		
		ArrayList<Player> players = new ArrayList();
		for (int i = 0; i < numPlayers; i++) {
			players.add(new Player(i));
			players.get(i).start();
		}
		
		
		// Start Player 0 turn
		int round = 1; 
		int index = 0;
		// At each end of round, archaeologists return to players
		// Market = 6 slots. #Artifacts = (6 - round #)
		do {
			Player temp = players.get(index);
			String move = temp.turn();
			
			
			// If player chooses play, get index of card in hand they want to play
			if (move.equals("PLAY")) {
				int playing = temp.chooseCard();
				System.out.println(temp.hand.get(playing).name);
				String tOrE = temp.playCard(playing);
				System.out.println(tOrE);
				
				// If card is played for effect, if it is a gold card, +2 player gold
				if (tOrE.equals("EFFECT")) {
					if (temp.hand.get(playing).name.equals("gold")) { 
						temp.gold += temp.hand.get(playing).effect;
						System.out.println("Player " + temp.playerNumber 
								+ " gold is now " + temp.gold);
					}
					
					// If card is compass, +2 player compass
					else if (temp.hand.get(playing).name.equals("compass")) {
						temp.compass += temp.hand.get(playing).effect;
						System.out.println("Player " + temp.playerNumber 
								+ " compass is now " + temp.compass);
						}
					
					// If fear, fear can not be played for effect
					else if (temp.hand.get(playing).name.equals("fear")) {
						System.out.println("The fear card can not be played for effect.");
						tOrE = "TRAVEL";
					}
				}
				
				// If player chooses travel, get user input of map tile they want to go to
				else if (tOrE.equals("TRAVEL")) {
					System.out.println("Your card's travel distance is: " + temp.hand.get(playing).travel);
					System.out.println("2 gold > plane > jeep/steamboat > boot");
					System.out.println("Currently programmed map tiles are 0-4 which only require boots.");
					System.out.print("Whhich tile would you like to travel to? ");
					
					int mapTravel = 0;
					do {
						mapTravel = scan.nextInt();
					} while (mapTravel < 0 && mapTravel > 4);
					
					String moveMap = map.move(mapTravel, temp.hand.get(playing).travel);
					
					// tile 0 returns gold, 1 returns compass, 2 returns tablets, 3 arrowhead, 4 jewel
					if (moveMap.equals("gold")) {
						temp.gold += 2;
						System.out.println("Player moved to tile: " 
						+ mapTravel + " and gained 2 gold");
						temp.archaeologist -= 1;
					}
					else if (moveMap.equals("compass")) {
						temp.compass += 2;
						System.out.println("Player moved to tile: " 
								+ mapTravel + " and gained 2 compass");
						temp.archaeologist -= 1;
					}
					else if (moveMap.equals("tablet")) {
						temp.tablet += 2;
						System.out.println("Player moved to tile: " 
								+ mapTravel + " and gained 2 tablet");
						temp.archaeologist -= 1;
					}
					else if (moveMap.equals("arrowhead")) {
						temp.arrowhead += 2;
						System.out.println("Player moved to tile: " 
								+ mapTravel + " and gained 1 arrowhead");
						temp.archaeologist -= 1;
					}
					else if (moveMap.equals("jewel")) {
						temp.jewel += 1;
						System.out.println("Player moved to tile: " 
								+ mapTravel + " and gained 1 jewel");
						temp.archaeologist -= 1;
					}
				}
				
				temp.removeFromHand(playing);
			}
			
			System.out.print("\n");
			if (index < players.size() - 1) {
				index++;
				players.get(index).playerTurn = true;
			}
			else {
				index = 0;
				round++;
			}
			
			
			// a round doesnt end until all players turns = false
			// archaeologists in inv. = 0 and cards in hand = 0
			
		}while (players.get(index).playerTurn == true 
				&& players.get(index).archaeologist > 0
				&& players.get(index).hand.size() > 0);
		
		scan.close();
	}
}
