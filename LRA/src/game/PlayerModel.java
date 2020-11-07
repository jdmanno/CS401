package game;

import java.util.*;

import org.junit.Test;

public class PlayerModel {
	/*
	Each player starts with their boards.
	Starting resources is different for each player:
		P1: 2 coins
		P2: 1 coin, 1 compass
		P3: 2 coins, 1 compass
		P4: 1 coin, 2 compasses
		
	Each round, each player draw until 5 cards in hand -> play cards -> pass -> shuffle decks -> move Moon Staff
	*/
	
	private PlayerBoardModel board;
	private SupplyModel inventory;
	
	// Constructor 
	public PlayerModel() {
		
	}

	
	
	// Getters
	@Test
	public PlayerBoardModel getBoard() {
		return board;
	}

	public SupplyModel getInventory() {
		return inventory;
	}
}
