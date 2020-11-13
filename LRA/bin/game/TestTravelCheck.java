package game;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTravelCheck {
	Tile tile1 = new Tile();
	Tile tile2 = new Tile();
	Tile tile3 = new Tile();
	Tile tile4 = new Tile();
	
	@BeforeEach
	public void setup() {
		tile1.travelReq = "boot";
		tile2.travelReq = "jeep";
		tile3.travelReq = "steamboat";
		tile4.travelReq = "plane";
	}
	

	@Test
	void test() {
		assertTrue(tile4.travelCheck("plane"));
		assertFalse(tile4.travelCheck("boot"));
		
		assertTrue(tile3.travelCheck("plane"));
		assertFalse(tile3.travelCheck("jeep"));
		
		assertTrue(tile2.travelCheck("steamboat"));
		assertFalse(tile2.travelCheck("boot"));
		
		assertTrue(tile1.travelCheck("boot"));
		assertFalse(tile1.travelCheck("none"));
	}

}
