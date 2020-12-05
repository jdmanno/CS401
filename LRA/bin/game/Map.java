package game;

import java.util.*;

public class Map {
	// 17 locations
	// 1-5 require 1 boot
	// 6-7, 10-11 require 1 jeep
	// 8-9, 12-13 require 1 steamboat
	// 14-15 require 2 jeep
	// 16-17 require 2 steamboat
	// 18 research locations 
	// 8 gold assistant
	// 6 silver assistant
	
	public ArrayList<Tile> mapTiles = new ArrayList();
	public ArrayList<Card> marketCards = new ArrayList();
	
	// first 5 tiles on map only require "boot" travel 
	public void start() {
		for (int i = 0; i < 5; i++) {
			mapTiles.add(new Tile());
			mapTiles.get(i).travelReq = "boot";
		}
		
		// Research tile 5 requires 1 jewel
		mapTiles.add(new Tile());
		mapTiles.get(5).tileInv.jewel += 1;
		
		// Research tile 6 requires 1 tablet + 1 arrowhead
		mapTiles.add(new Tile());
		mapTiles.get(6).tileInv.tablet +=1;
		mapTiles.get(6).tileInv.arrowhead +=1;
		
		// axe cost: 2 gold effect: +2 jewel
		marketCards.add(new Card("axe", 0, "none"));
		marketCards.get(0).cardReq.gold = 2;
		marketCards.get(0).cardEffect.jewel = 2;
		
		// backpack cost: 1 gold 1 compass effect: +2 tablet
		marketCards.add(new Card("backpack", 0, "none"));
		marketCards.get(1).cardReq.gold = 1;
		marketCards.get(1).cardReq.compass = 1;
		marketCards.get(1).cardEffect.tablet = 2;
		
		// sea turtle cost: 3 gold effect: +1 steamboat
		marketCards.add(new Card("sea turtle", 0, "steamboat"));
		marketCards.get(2).cardReq.gold = 3;
		
		// guardian cost: 4 compass effect: +1 archaeologist +1 plane
		marketCards.add(new Card("guardian", 0, "plane"));
		marketCards.get(3).cardReq.compass = 4;
		marketCards.get(3).cardEffect.archaeologist = 1;
		
		// serpents gold cost: 3 compass effect: +1 arrowhead +3 gold
		marketCards.add(new Card("serpents gold", 0, "none"));
		marketCards.get(4).cardReq.compass = 3;
		marketCards.get(4).cardEffect.arrowhead = 1;
		marketCards.get(4).cardEffect.gold = 3;
	}
	
	// return string back to main game driver where effects will take place 
	public String move(int tileNum, String userTravel) {
		switch (tileNum) {
			case 0: {
					 mapTiles.get(0).travelCheck(userTravel);
					 return "gold";
				}
			case 1: {
				mapTiles.get(1).travelCheck(userTravel);
				 return "compass";
				}
			case 2: {
				mapTiles.get(2).travelCheck(userTravel);
				 return "tablet";
			}
			case 3: {
				mapTiles.get(3).travelCheck(userTravel);
				 return "arrowhead";
			}
			case 4: {
				mapTiles.get(4).travelCheck(userTravel);
				 return "jewel";
			}
		}
		return "";
	}
	
	// Controller to reference Tile and Player from Main 
	public boolean research(Tile t, Player p) {
		return t.researchCheck(p);
	}
	
	public boolean buy(Card c, Player p) {
		return c.buyCheck(p);
	}
} 
