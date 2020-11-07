package game;

// import java.util.*;

public class CardModel {
	/* 
	Each card has effects and travel values. You can play for either but not both. 
	Fear cards have only travel value.
	
	When cards are played, they will stack onto the player's Play Area. They will be shuffled back at the end of the round. 
	
	Free-action cards(non-Artifacts) can be played before, during, or after the Main Action has been taken. 
	 */
	
	
	//  Variables: free action? effects? travel value?
	boolean free;
	String effects;
	
	enum Travel {
		Boot, Car, Boat, Plane;
		private static final Travel[] travels = Travel.values();
		public static Travel getTravel(int i) {
			return Travel.travels[i];
		}
	}
	
	private final Travel travel;
	
	// Constructor
	public CardModel (boolean free, String effects, final Travel travel){  
		this.free = free;
		this.effects = effects;
		this.travel = travel;
	}
	
	// Display info about the card
	public String info() {
		String info = String.format("(%1$s)(%2$s): %3$s", travel, free, effects);
		return info;
	}

	// More code here
	
	
	
	// Getters 
	public boolean isFree() {
		return free;
	}

	public String getEffects() {
		return effects;
	}

	public Travel getTravel() {
		return travel;
	}
}
