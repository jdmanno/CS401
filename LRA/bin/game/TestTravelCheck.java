package game;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTravelCheck {
	Tile tile1 = new Tile();
	Tile tile2 = new Tile();
	Tile tile3 = new Tile();
	Tile tile4 = new Tile();
	Tile tile5 = new Tile();
	Tile tile6 = new Tile();
	Player testPlayer = new Player(0);
	
	@BeforeEach
	public void setup() {
		tile1.travelReq = "boot";
		tile2.travelReq = "jeep";
		tile3.travelReq = "steamboat";
		tile4.travelReq = "plane";
		
		tile5.tileInv.jewel += 1;
		tile6.tileInv.tablet += 1;
		tile6.tileInv.arrowhead += 1;
		
		tile4.tileInv.gold += 1;
		tile4.tileInv.tablet += 1;
		tile4.tileInv.arrowhead += 1;
		
		testPlayer.playerInv.jewel += 1;
		testPlayer.playerInv.tablet += 1;
		testPlayer.playerInv.arrowhead += 1;
	}
	

	@Test
	void travelTest() {
		assertTrue(tile4.travelCheck("plane"));
		assertFalse(tile4.travelCheck("boot"));
		
		assertTrue(tile3.travelCheck("plane"));
		assertFalse(tile3.travelCheck("boot"));
		
		assertTrue(tile2.travelCheck("steamboat"));
		assertFalse(tile2.travelCheck("boot"));
		
		assertTrue(tile1.travelCheck("boot"));
		assertFalse(tile1.travelCheck("none"));
	}
	
	void researchTest() {
		assertTrue(tile5.researchCheck(testPlayer));
		assertTrue(tile6.researchCheck(testPlayer));
		assertFalse(tile4.researchCheck(testPlayer));
	}

}
