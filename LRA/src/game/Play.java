package game;

import java.util.*;

public class Play {
	public static void main(String[] args) {
        System.out.print("Starting Lost Ruins of Arnak...\n");               
        System.out.print("--------------------\n--------------------\n");    
        System.out.print("Enter Number Of Players (1-4): ");
        
        // Prioritize 4-person game over solo (1-player) variant, so expecting 2+ input
        Scanner scan = new Scanner(System.in);
        int numPlayers = scan.nextInt();
        if(numPlayers >= 2) {
        	System.out.print("Initializing players' hands and decks...\n"); 
        	gameLoop();
        }
        else {
        	System.out.print("Solo Variant TBA.\n");  
        	main(args);
        }
        scan.close();
    }
	
	public static void gameLoop() {
		// At end of each round, return archaeologists to players 
		// Market = 6 slots, Items in market = (6 - Round #), Max rounds = 5
		// int round = 0;
	}
}
