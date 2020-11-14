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
	
	// spend travel cost
	// or receive card effect 		
	// return string back to main game driver to implement logic 
	public String play() {
		System.out.print("Play for travel or effect? ");
		Scanner scan = new Scanner(System.in);
		String travelOrEffect;
		do {
			travelOrEffect = scan.nextLine().toUpperCase();
		}while(!travelOrEffect.equals("TRAVEL") && !travelOrEffect.equals("EFFECT"));
		
		return travelOrEffect;
	}
}
