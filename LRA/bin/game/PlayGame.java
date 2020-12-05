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
		int numPlayers = 0;
		do {
			System.out.print("Enter number of players 1-4: ");
			numPlayers = scan.nextInt();
		} while (numPlayers < 1 || numPlayers > 4);
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
						temp.playerInv.gold += temp.hand.get(playing).effect;
						System.out.println("Player " + temp.playerNumber 
								+ " gold is now " + temp.playerInv.gold);
					}
					
					// If card is compass, +2 player compass
					else if (temp.hand.get(playing).name.equals("compass")) {
						temp.playerInv.compass += temp.hand.get(playing).effect;
						System.out.println("Player " + temp.playerNumber 
								+ " compass is now " + temp.playerInv.compass);
						}
					
					// Fear card is discarded into deck
					else if (temp.hand.get(playing).name.equals("fear")) {
						temp.removeFromHand(playing);
					}
				}
				
				// If player chooses travel, get user input of map tile they want to go to
				else if (tOrE.equals("TRAVEL")) {
					System.out.println("Your card's travel distance is: " + temp.hand.get(playing).travel);
					System.out.println("2 gold > plane > jeep/steamboat > boot");
					System.out.println("Currently programmed map tiles are 0-4 which only require boots.");
					System.out.print("Which tile would you like to travel to? ");
					
					int mapTravel = 0;
					do {
						mapTravel = scan.nextInt();
					} while (mapTravel < 0 || mapTravel > 4);
					
					String moveMap = map.move(mapTravel, temp.hand.get(playing).travel);
					
					// tile 0 returns gold, 1 returns compass, 2 returns tablets, 3 arrowhead, 4 jewel
					if (moveMap.equals("gold")) {
						temp.playerInv.gold += 2;
						System.out.println("Player moved to tile: " 
						+ mapTravel + " and gained 2 gold");
						temp.playerInv.archaeologist -= 1;
					}
					else if (moveMap.equals("compass")) {
						temp.playerInv.compass += 2;
						System.out.println("Player moved to tile: " 
								+ mapTravel + " and gained 2 compass");
						temp.playerInv.archaeologist -= 1;
					}
					else if (moveMap.equals("tablet")) {
						temp.playerInv.tablet += 2;
						System.out.println("Player moved to tile: " 
								+ mapTravel + " and gained 2 tablet");
						temp.playerInv.archaeologist -= 1;
					}
					else if (moveMap.equals("arrowhead")) {
						temp.playerInv.arrowhead += 2;
						System.out.println("Player moved to tile: " 
								+ mapTravel + " and gained 1 arrowhead");
						temp.playerInv.archaeologist -= 1;
					}
					else if (moveMap.equals("jewel")) {
						temp.playerInv.jewel += 1;
						System.out.println("Player moved to tile: " 
								+ mapTravel + " and gained 1 jewel");
						temp.playerInv.archaeologist -= 1;
					}
					
					temp.removeFromHand(playing);
				}
			}
			
			else if(move.equals("BUY")) {
				for (int i = 0; i < map.marketCards.size(); i++) {
					System.out.print("CARD " + i + ": " + map.marketCards.get(i).name + ". COST(to buy): " +
							"Gold " + map.marketCards.get(i).cardReq.gold + ", " + 
							"Compass: " + map.marketCards.get(i).cardReq.compass + ", " + 
							"Tablets: " + map.marketCards.get(i).cardReq.tablet + ", " + 
							"Arrowheads: " + map.marketCards.get(i).cardReq.arrowhead + ", " + 
							"Jewels: " + map.marketCards.get(i).cardReq.jewel + " ");
					System.out.print("EFFECT(returned to player): " + 
							"Gold " + map.marketCards.get(i).cardReq.gold + ", " + 
							"Compass: " + map.marketCards.get(i).cardReq.compass + ", " + 
							"Tablets: " + map.marketCards.get(i).cardReq.tablet + ", " + 
							"Arrowheads: " + map.marketCards.get(i).cardReq.arrowhead + ", " + 
							"Jewels: " + map.marketCards.get(i).cardReq.jewel);
					if (!map.marketCards.get(i).travel.equals("none")) System.out.print(" + Travel: " + map.marketCards.get(i).travel);
					System.out.print("\n");
				}
				
				int marketBuy = 0;
				do {
					System.out.println("Please enter which card from the market you would like to buy 0-4: " );
					marketBuy = scan.nextInt();
				} while (marketBuy < 0 || marketBuy > 5);
				
				
				if (map.buy(map.marketCards.get(marketBuy), temp) == true) {
					System.out.println("Player " + temp.playerNumber + " did bought market card " + map.marketCards.get(marketBuy).name);
					Card tempCard = map.marketCards.get(marketBuy);
					map.marketCards.remove(marketBuy);
					temp.deck.add(tempCard);
				}
				else System.out.println("Player " + temp.playerNumber + " could not buy tile " + map.marketCards.get(marketBuy).name);
				
			}
				
			
			// Invokes tile.researchCheck() where it will compare playerInv with tileReq
			// If player > tileReq, return true and research
			// Else return false
			else if(move.equals("SPEND")) {
				for (int i = 5; i < map.mapTiles.size(); i++) {
				System.out.println("Research tile " + i + " requires " + 
						"Gold: " + map.mapTiles.get(i).tileInv.gold + ", " + 
						"Compass: " + map.mapTiles.get(i).tileInv.compass + ", " + 
						"Tablets: " + map.mapTiles.get(i).tileInv.tablet + ", " + 
						"Arrowheads: " + map.mapTiles.get(i).tileInv.arrowhead + ", " + 
						"Jewels: " + map.mapTiles.get(i).tileInv.jewel);
				}
				
				int mapTravel = 0;
				do {
					System.out.println("Please enter which tile you would like to research 5-6: " );
					mapTravel = scan.nextInt();
				} while (mapTravel < 5 || mapTravel > 6);
				
				if (map.research(map.mapTiles.get(mapTravel), temp) == true) {
					System.out.println("Player " + temp.playerNumber + " did research on tile " + mapTravel);
				}
				else System.out.println("Player " + temp.playerNumber + " could not research tile " + mapTravel);
			}
			
			players.get(index).isTurn(false);
			
			System.out.print("\n");
			if (index < players.size() - 1) {
				index++;
				players.get(index).isTurn(true);
			}
			else {
				index = 0;
				round++;
				players.get(0).isTurn(true);
			}
			
			
			// game is over after 5 rounds
		}while (round < 6);
		
		System.out.println("Game Over!");
		scan.close();
	}
}
