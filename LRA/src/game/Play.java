package game;

import java.util.*;

public class PlayGame {
	public static void main(String[] args) {
        System.out.print("Start Game\n");               
        
        System.out.print("Enter number of players: ");
        Scanner scan = new Scanner(System.in);
        int numPlayers = scan.nextInt();
        scan.close();
        
        int round = 1; 
        
        // At end of each round, return archaeologists to players 
        // Market = 6 slots, Items in market = (6 - Round #)
    }
}
