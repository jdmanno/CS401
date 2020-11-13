package game;

import java.util.*;

public class Tile {
	// 15 guardian tiles
	// 10 level 2 tiles
	// 6 level 3 tiles
	
	String travelReq = "";
	
	// 2 gold > plane > jeep/steamboat > boot
	public boolean travelCheck(String userTravel) {
		return conversion(this.travelReq, userTravel);
	}
	
	public boolean conversion(String tile, String user) {	
		double tilee = 0;
		double userr = 0;
		
		if (tile == "plane") tilee = 3;
		else if (tile == "steamboat") tilee = 2.5;
		else if (tile == "jeep") tilee = 2;
		else if (tile == "boot") tilee = 1;
		else tilee = 0;
		
		if (user == "plane") userr = 3;
		else if (user == "steamboat") userr = 2.5;
		else if (user == "jeep") userr = 2;
		else if (user == "boot") userr = 1;
		else userr = 0;
		
		if (userr >= tilee) return true;
		else return false;
	}
}
