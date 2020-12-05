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
	Component cardReq = new Component();
	Component cardEffect = new Component();
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
	
	// Check player inv with card req. 
	public boolean buyCheck(Player p) {
		if (p.playerInv.gold >= this.cardReq.gold && 
				p.playerInv.compass >= this.cardReq.compass && 
				p.playerInv.tablet >= this.cardReq.tablet && 
				p.playerInv.arrowhead >= this.cardReq.arrowhead && 
				p.playerInv.jewel >= this.cardReq.jewel) {
				
				// Subtract card cost from player inventory
				p.playerInv.gold = p.playerInv.gold - this.cardReq.gold;
				p.playerInv.compass = p.playerInv.compass - this.cardReq.compass;
				p.playerInv.tablet = p.playerInv.tablet - this.cardReq.tablet;
				p.playerInv.arrowhead = p.playerInv.arrowhead - this.cardReq.arrowhead;
				p.playerInv.jewel = p.playerInv.jewel - this.cardReq.jewel;
				
				// Add card effect to player inventory
				p.playerInv.gold = p.playerInv.gold + this.cardEffect.gold;
				p.playerInv.compass = p.playerInv.compass + this.cardEffect.compass;
				p.playerInv.tablet = p.playerInv.tablet + this.cardEffect.tablet;
				p.playerInv.arrowhead = p.playerInv.arrowhead + this.cardEffect.arrowhead;
				p.playerInv.jewel = p.playerInv.jewel + this.cardEffect.jewel;
				return true;
		}
		else return false;
	}
}
