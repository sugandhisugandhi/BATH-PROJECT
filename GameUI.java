package wars;

import java.util.*;
/**
 * Task 2 - provide command line interface
 * 
 * @author A.A.Marczyk
 * @version 16/02/25
 */


public class GameUI {
    private BATHS navalGame;
    private Scanner inputScanner = new Scanner(System.in);
    private String playerName;

    public void doMain() {
        int userChoice;
        System.out.println("Please enter your name as admiral:");
        playerName = inputScanner.nextLine();
        navalGame = new SeaBattles(playerName);

        userChoice = 100;
        while (userChoice != 0) {
            userChoice = getMenuSelection();
            if (userChoice == 1) {
                System.out.println("Reserve Fleet Ships:\n" + navalGame.getReserveFleet());
            }
            else if (userChoice == 2) {
                System.out.println("Admiral's Squadron Ships:\n" + navalGame.getSquadron());
            }
            else if (userChoice == 3) {
                System.out.println("Enter the name of the ship to view:");
                inputScanner.nextLine();
                String shipRef = (inputScanner.nextLine()).trim();
                System.out.println("Ship Details:\n" + navalGame.getShipDetails(shipRef));
            } 
            else if (userChoice == 4) {
                System.out.println("Enter the name of the ship to commission:");
                inputScanner.nextLine();
                String shipRef = (inputScanner.nextLine()).trim();
                String commissionResult = navalGame.commissionShip(shipRef);
                System.out.println("Commission Result: " + commissionResult);
            }
            else if (userChoice == 5) {
                System.out.println("Enter the encounter number to fight:");
                int encounterNum = inputScanner.nextInt();
                if (navalGame.isEncounter(encounterNum)) {
                    String battleResult = navalGame.fightEncounter(encounterNum);
                    System.out.println("Battle Outcome: " + battleResult);
                } else {
                    System.out.println("Error: No encounter exists with that number");
                }
            }
            else if (userChoice == 6) {
                System.out.println("Enter the name of the ship to restore:");
                inputScanner.nextLine();
                String shipRef = (inputScanner.nextLine()).trim();
                if (navalGame.isInSquadron(shipRef)) {
                    navalGame.restoreShip(shipRef);
                    System.out.println("Ship restored to active service");
                } else {
                    System.out.println("Error: Ship not found in squadron");
                }
            }
            else if (userChoice == 7) {
                System.out.println("Enter the name of the ship to decommission:");
                inputScanner.nextLine();
                String shipRef = (inputScanner.nextLine()).trim();
                if (navalGame.isInSquadron(shipRef)) {
                    boolean decommissionResult = navalGame.decommissionShip(shipRef);
                    if (decommissionResult) {
                        System.out.println("Ship successfully decommissioned");
                    } else {
                        System.out.println("Error: Could not decommission ship");
                    }
                } else {
                    System.out.println("Error: Ship not found in squadron");
                }
            }
            else if (userChoice == 8) {
                System.out.println("Current Admiral Status:\n" + navalGame.toString());
            }
            else if (userChoice == 9) {
                System.out.println("Saving game progress...");
                navalGame.saveGame("game_save.dat");
                System.out.println("Game saved successfully");
            }
            else if (userChoice == 10) {
                System.out.println("Loading saved game...");
                SeaBattles loadedGame = ((SeaBattles)navalGame).loadGame("game_save.dat");
                if (loadedGame != null) {
                    navalGame = loadedGame;
                    System.out.println("Game loaded successfully:\n" + navalGame.toString());
                } else {
                    System.out.println("Error: Failed to load game");
                }
            }
        }
        System.out.println("Thank you for playing!");
    }
    
    private int getMenuSelection() {
        int selection = 100;  
        System.out.println("\n=== NAVAL COMMAND MENU ===");
        System.out.println("0. Exit Game");
        System.out.println("1. Display Reserve Fleet");
        System.out.println("2. Display Squadron Ships"); 
        System.out.println("3. Inspect Ship Details");
        System.out.println("4. Add Ship to Squadron");
        System.out.println("5. Engage in Battle");
        System.out.println("6. Repair and Restore Ship");
        System.out.println("7. Remove Ship from Service");
        System.out.println("8. View Admiral's Log");
        System.out.println("9. Save Current Game");
        System.out.println("10. Load Saved Game");
        
        while (selection < 0 || selection > 10) {
            System.out.print("Enter menu option (0-10): ");
            selection = inputScanner.nextInt();
        }
        return selection;        
    } 
    
    public static void main(String[] args) {
        GameUI gameSession = new GameUI();
        gameSession.doMain();
    }
}