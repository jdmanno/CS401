package game;

import java.util.*;

public class Tile {
	// 15 guardian tiles
	// 10 level 2 tiles
	// 6 level 3 tiles
	
	String travelReq = "";
	public Component tileInv = new Component();
	
	// 2 gold > plane > jeep/steamboat > boot
	public boolean travelCheck(String userTravel) {
		return conversion(this.travelReq, userTravel);
	}
	
	
	// Compare travel icons of the map tile vs the card played by user 
	// Convert to integer points for true/false comparison
	public boolean conversion(String tile, String user) {	
		double tilee = 0;
		double userr = 0;
		
		if (tile == "plane") tilee = 3;
		else if (tile == "jeep" || tile == "steamboat") tilee = 2;
		else if (tile == "boot") tilee = 1;
		else tilee = 0;
		
		if (user == "plane") userr = 3;
		else if (user == "jeep" || user == "steamboat") userr = 2;
		else if (user == "boot") userr = 1;
		else userr = 0;
		
		if (userr >= tilee) return true;
		else return false;
	}
	
	
	// Research tile should only have a max of 1 or 2 inventory components = 1
	// Rest should be 0
	// Subtract player inv.component if greater than required tile inv.component and return true
	// Players other components should not change if tile inv.component = 0
	// Else return false
	public boolean researchCheck(Player p) {
		if (p.playerInv.gold >= this.tileInv.gold && 
			p.playerInv.compass >= this.tileInv.compass && 
			p.playerInv.tablet >= this.tileInv.tablet && 
			p.playerInv.arrowhead >= this.tileInv.arrowhead && 
			p.playerInv.jewel >= this.tileInv.jewel) {
			
			p.playerInv.gold = p.playerInv.gold - this.tileInv.gold;
			p.playerInv.compass = p.playerInv.compass - this.tileInv.compass;
			p.playerInv.tablet = p.playerInv.tablet - this.tileInv.tablet;
			p.playerInv.arrowhead = p.playerInv.arrowhead - this.tileInv.arrowhead;
			p.playerInv.jewel = p.playerInv.jewel - this.tileInv.jewel;
			return true;
		}
		else return false;
	}
}
