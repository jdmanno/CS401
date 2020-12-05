package game;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMarketBuy {
	Map testMap = new Map();
	Player testPlayer = new Player(0);
	
	@BeforeEach
	public void setup() {
		testMap.start();
		testPlayer.playerInv.gold = 99;
		testPlayer.playerInv.compass = 99;
		testPlayer.playerInv.arrowhead = 99;
		testPlayer.playerInv.jewel = 99;
		testPlayer.playerInv.tablet = 99;
	}
	
	@Test
	void test() {
		assertTrue(testMap.buy(testMap.marketCards.get(0), testPlayer));
		assertTrue(testMap.buy(testMap.marketCards.get(1), testPlayer));
		assertTrue(testMap.buy(testMap.marketCards.get(2), testPlayer));
		assertTrue(testMap.buy(testMap.marketCards.get(3), testPlayer));
		assertTrue(testMap.buy(testMap.marketCards.get(4), testPlayer));
	}

}
