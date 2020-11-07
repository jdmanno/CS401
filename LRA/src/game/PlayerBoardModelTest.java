package game;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class PlayerBoardModelTest {

	@Test
	void testGetHandLength() {
		PlayerBoardModel board = new PlayerBoardModel();
		assertEquals(board.getHandLength(), 6);
	}

}
