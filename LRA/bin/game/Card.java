package game;

import java.util.*;

public class Card {
	// 19 fear cards
	// 40 item cards
	// 35 artifact cards
	
	// card should have name, effect, and travel cost
	String name;
	int effect;
	String travel;
	
	public Card(String cardName, int eff, String travelCost) {
		this.name = cardName;
		this.effect = eff;
		this.travel = travelCost;
	}
}
