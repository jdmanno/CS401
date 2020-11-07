package game;

import java.util.*;

import game.CardModel.Travel; 

public class PlayerBoardModel {
	/*
	The player board consists of:
		Player's Hand
		Card Deck 
		Play Area(for played cards. will be shuffed back into deck at endturn)
		4 Idol(statue) slots
		2 Assistant slots 
		Points/Research/Rewards tracker (points will be late feature)
	*/
	
	private ArrayList<CardModel> hand; 
	private ArrayList<CardModel> deck;
	private ArrayList<CardModel> playArea;
	private ArrayList<IdolModel> idolSlots;
	private ArrayList<AssistantModel> assistantSlots;
	private SupplyModel inventory;
	
	public PlayerBoardModel() {	
		/*
		When initialize(new game), add 2 fund cards, 2 explore cards, 2 fear cards to hand.
		*/
		CardModel fund1 = new CardModel(true, "Add 1 coin", Travel.Boat);
		CardModel fund2 = new CardModel(true, "Add 1 coin", Travel.Boot);
		CardModel explore1 = new CardModel(true, "Add 1 compass", Travel.Car);
		CardModel explore2 = new CardModel(true, "Add 1 compass", Travel.Boot);
		CardModel fear1 = new CardModel(true, "", Travel.Boot);
		CardModel fear2 = new CardModel(true, "", Travel.Boot);
		
		hand.add(fund1); hand.add(fund2); hand.add(explore1); hand.add(explore2); hand.add(fear1); hand.add(fear2);
	}

	// Getters
	public ArrayList<CardModel> getHand() {
		return hand;
	}

	public ArrayList<CardModel> getDeck() {
		return deck;
	}

	public ArrayList<CardModel> getPlayArea() {
		return playArea;
	}

	public ArrayList<IdolModel> getIdolSlots() {
		return idolSlots;
	}

	public ArrayList<AssistantModel> getAssistantSlots() {
		return assistantSlots;
	}

	public SupplyModel getInventory() {
		return inventory;
	}
}
