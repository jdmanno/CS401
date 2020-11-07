package game;

import java.util.*;

public class PlayerModel {
	/*
	Each player starts with 6 cards: 2 funding, 2 exploration and 2 fear 	
	Starting resources is different for each player:
		P1: 2 coins
		P2: 1 coin, 1 compass
		P3: 2 coins, 1 compass
		P4: 1 coin, 2 compasses
	The player board consists of:
		Card Deck 
		4 Idol(statue) slots (if an idol slot is filled, add a component) 
		2 Assistant slots 
		Research tokens
		Points/Rewards tracker
		
	Each round, each player draw until 5 cards in hand -> play cards -> pass -> shuffle decks -> move Moon Staff
	*/
	
	ArrayList<CardModel> deck = new ArrayList<>();
}
