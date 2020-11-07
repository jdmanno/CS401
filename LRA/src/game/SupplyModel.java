package game;

public class SupplyModel {
	/*
	27 Coin tokens
	27 Compass tokens
	16 Tablet tokens
	12 Arrowhead tokens
	9 Jewel tokens
	*/
	
	private int coins = 0;
	private int compasses = 0;
	private int tablets = 0;
	private int arrowheads = 0;
	private int jewels = 0;
	
	// Constructor
	public SupplyModel(int coin, int compass, int t, int a, int j) {
		this.coins = coin;
		this.compasses = compass;
		this.tablets = t;
		this.arrowheads = a;
		this.jewels = j;
	}
	
	// Populate the Supply Crate with fixed values. Not used for players
	public void populate() {
		this.setCoins(27);
		this.setCompasses(27);
		this.setTablets(16);
		this.setArrowheads(12);
		this.setJewels(9);
	}
	
	// More code here..
	
	
	// Getters and Setters
	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int getCompasses() {
		return compasses;
	}

	public void setCompasses(int compasses) {
		this.compasses = compasses;
	}

	public int getTablets() {
		return tablets;
	}

	public void setTablets(int tablets) {
		this.tablets = tablets;
	}

	public int getArrowheads() {
		return arrowheads;
	}

	public void setArrowheads(int arrowheads) {
		this.arrowheads = arrowheads;
	}

	public int getJewels() {
		return jewels;
	}

	public void setJewels(int jewels) {
		this.jewels = jewels;
	}
}
