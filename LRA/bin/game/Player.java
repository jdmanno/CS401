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
	
	public boolean playerTurn = false;
	public int gold = 0;
	public int compass = 0;
	public int archaeologist = 2;
	public int tablet = 0;
	public int arrowhead = 0;
	public int jewel = 0;
	
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
		
		
		// Player 0: 2 gold + turn = true
		// Player 1: 1 gold, 1 compass
		// Player 2: 2 gold, 1 compass
		// Player 3: 1 gold, 2 compass
		switch (playerNumber) {
		case 0: 
			this.isTurn(true);
			this.playerGold(3);
			break;
		case 1: 
			this.playerCompass(3);
			break;
		case 2: 
			this.playerGold(2);
			this.playerCompass(1);
			break;
		case 3:
			this.playerGold(1);
			this.playerCompass(2);
			break;
		}
		
		// player deck = 2 gold, 2 compass, 2 fear
		// player hand = random 5 from deck 
		deck.add(new Card(g, 1, j));
		deck.add(new Card(g, 1, sb));
		deck.add(new Card(c, 1, j));
		deck.add(new Card(c, 1, sb));
		deck.add(new Card(f, 0, b));
		deck.add(new Card(f, 0, b));
		
		// choose random number between 0-5, remove from deck array and add to hand array
		for (int i = 0; i < 5; i++) {
			int rand = (int)(Math.random() * deck.size());
			Card swap = deck.get(rand);
			deck.remove(rand);
			hand.add(swap);
		}
	}
	
	public void isTurn(boolean t) {
		if (t == true) this.playerTurn = true;
		else this.playerTurn = false;
	}
	
	public void playerGold(int amount) {
		this.gold += amount;
	}
	
	public void playerCompass(int amount) {
		this.compass += amount;
	}
	
	public String turn() {
		if (this.playerTurn == true) {
			System.out.println("It is player "+ this.playerNumber + "'s turn.");
			System.out.print("Gold: " + this.gold);
			System.out.print(", Compass: " + this.compass);
			System.out.println(", Archaeologists: " + this.archaeologist);
			System.out.print("Tablets: " + this.tablet);
			System.out.print(", Arrowheads: " + this.arrowhead);
			System.out.println(", Jewels: " + this.jewel);
			System.out.print("Hand: ");
			for (int k1 = 0; k1 < hand.size(); k1++) {
				System.out.print(hand.get(k1).name + " ");
			}
			System.out.print("\n\n");
			
			Scanner scan = new Scanner(System.in);
			String playerMove;
			do {
				System.out.println("Please enter PLAY BUY or SPEND: ");
				System.out.println("Play to play a card,"
						+ " Buy to buy an item/artifact from the market,"
						+ " Spend to spend a magnifying glass/book for research");
				System.out.println("Only PLAY is programmed for now.");
				playerMove = scan.nextLine().toUpperCase();
				System.out.println(playerMove);
			} while (!playerMove.equals("PLAY"));
			
			return playerMove;
		} 
		else return "";
	}
	
	public int chooseCard() {
		int temp = this.hand.size() - 1;
		System.out.println("What card from your hand would you like to play? 0-" + temp + ": ");
		for (int k = 0; k < hand.size(); k++) {
			System.out.println(k + ": " + this.hand.get(k).name);
		}
		Scanner scan = new Scanner(System.in);
		int played = scan.nextInt();
		
		return played;
	}
	
	public String playCard(int numHand) {
		return this.hand.get(numHand).play();
	}
	
	public void removeFromHand(int cardRemove) {
		Card tmp = hand.get(cardRemove);
		deck.add(tmp);
		hand.remove(cardRemove);
	}
	
}
