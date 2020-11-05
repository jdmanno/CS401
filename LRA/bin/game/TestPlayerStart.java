package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPlayerStart {
	Player player1 = new Player(1);
	@BeforeEach
	public void setup() {
		player1.start();
	}
	
	@Test
	public void removeAndAdd() {
		assertEquals(player1.deck.size(), 1);
		assertEquals(player1.hand.size(), 5);
	}
}
