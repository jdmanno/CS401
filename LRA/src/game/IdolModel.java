package game;

// import java.util.*;

public class IdolModel extends CardModel{
	/*
	Idols can be obtained from the supply crate and then can be put into 1 of the 4 idol slots in the player board. Once per game, an idol can be removed from its slot to perform 1 of 5 free actions. 
	*/
	
	// Constructor
	public IdolModel(boolean free, String effects, Travel travel) {
		super(free = true, effects, travel);
	}
	
	// Use an idol and remove from its idol slot
	public void use() {
		
		/* Actions:
		1. Trade 1 coin for 1 gem
		2. Get 1 arrowhead
		3. Get 2 tablets
		4. Get 1 coin and 1 compass
		5. Draw 1 card 
		*/
		
	}
}
