package battleship;

import java.util.Scanner;


public class BattleshipGame {

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.instruction();
        game.runGame();
        System.out.println("Game over!");

    }
    
    void instruction() {
    	System.out.println("Battleship starts. One battleship, two cruisers, "
    			+ "three destoyers, and four submarines are randomly placed.\n"
    			+ "'q' represent quit, and 'row column' represent the position fired");
    }
    
    void runGame() {
    	Ocean ocean = new Ocean();
    	ocean.placeAllShipsRandomly();

    	System.out.print("Action: ");
    	Scanner scanner = new Scanner(System.in);
    	String command = scanner.nextLine();
    	
        while(command.charAt(0) != 'q') {
        	if (command.charAt(0) == 'r') {
        	
        		ocean = new Ocean();
        		ocean.placeAllShipsRandomly();
        		System.out.print("Action: ");
        		command = scanner.nextLine();
        	
        	} else {
        		String[] commandSplit = command.split(" ");
        		ocean.shootAt(Integer.parseInt(commandSplit[0]), Integer.parseInt(commandSplit[1]));
            	ocean.print();
            	System.out.print("Action: ");
        		command = scanner.nextLine();
        	}
        }
        
        scanner.close();
        
    	
    }
    
   

}
