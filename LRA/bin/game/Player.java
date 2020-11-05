package game;

import java.util.*;

public class Player {
	// 6 card deck
	// 5 card hand 
	// 4 statue slot
	// When a statue slot is filled, player receives bonus component
	// When a card is played, it can not be used for the rest of the round. Then shuffled and inserted at bottom of deck.
	
	public ArrayList<Card> deck = new ArrayList();
	public ArrayList<Card> hand = new ArrayList();
	
	int playerNumber;
	
	public Player(int playernum) {
		this.playerNumber = playernum;
	}
	
	public void start() {
		String g = "gold";
		String c = "compass";
		String f = "fear";
		String b = "boot";
		String j = "jeep";
		String sb = "steamboat";
		
		System.out.print(playerNumber + ", ");
		
		// player deck = 2 gold, 2 compass, 2 fear
		// player hand = random 5 from deck 
		deck.add(new Card(g, 1, j));
		deck.add(new Card(g, 1, sb));
		deck.add(new Card(c, 1, j));
		deck.add(new Card(c, 1, sb));
		deck.add(new Card(f, 0, b));
		deck.add(new Card(f, 0, b));
		
		for (int j1 = 0; j1 < deck.size(); j1++) {
			System.out.print(deck.get(j1).name + ", ");
		}
		
		// choose random number between 0-5, remove from deck array and add to hand array
		for (int i = 0; i < 5; i++) {
			int rand = (int)(Math.random() * deck.size());
			System.out.print(rand + ", ");
			Card swap = deck.get(rand);
			deck.remove(rand);
			hand.add(swap);
		}
		
		for (int j1 = 0; j1 < deck.size(); j1++) {
			System.out.print(deck.size() + ", ");
		}
		for (int k1 = 0; k1 < hand.size(); k1++) {
			System.out.print(hand.get(k1).name + ", ");
		}
		
		System.out.print("\n");
	}
	
}
