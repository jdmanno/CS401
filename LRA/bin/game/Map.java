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
	
	// first 5 tiles on map only require "boot" travel 
	public void start() {
		for (int i = 0; i < 5; i++) {
			mapTiles.add(new Tile());
			mapTiles.get(i).travelReq = "boot";
		}
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
	
	public void market(int marketNum) {
		
	}
} 
