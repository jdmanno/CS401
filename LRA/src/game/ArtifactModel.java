package game;

import java.util.*;

public class ArtifactModel extends CardModel{

	/* 
	Artifacts costs a tablet token to activate. They can be bought with 1-4 compasses. If found, can be activated without tablet cost. Once in deck, need to pay with a tablet to reactivate. 
	*/
	
	Random random = new Random();
	private int cost = random.nextInt(4) + 1;

	// Constructor
	public ArtifactModel(boolean free, String effects, Travel travel, int cost) {
		super(free = false, effects, travel);
		this.cost = cost;
	}

	// More code here..
	
	
	// Getters
	public int getCost() {
		return cost;
	}	
}
