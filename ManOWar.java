/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author 
 */
/**
 * Represents a ManOWar warship - a powerful ship with multiple decks and marine complement.
 */
public class ManOWar extends Ship {
    private static final int TWO_DECK_FEE = 300;
    private static final int THREE_DECK_FEE = 500;
    
    private final int decks;          // Number of gun decks (2 or 3)
    private final int marineCount;    // Number of marines aboard
    
    /**
     * Constructs a ManOWar ship
     * @param name Ship's name
     * @param captain Captain's name
     * @param battleSkill Combat skill rating
     * @param decks Number of gun decks (2 or 3)
     * @param marines Number of marines aboard
     */
    public ManOWar(String name, String captain, int battleSkill, int decks, int marines) {
        super(name, captain, battleSkill);
        this.decks = validateDecks(decks);
        this.marineCount = Math.max(marines, 0);  // Ensure non-negative
        this.commissionFee = calculateCommissionFee();
    }
    
    private int validateDecks(int decks) {
        if (decks < 2 || decks > 3) {
            throw new IllegalArgumentException("ManOWar must have 2 or 3 decks");
        }
        return decks;
    }
    
    private int calculateCommissionFee() {
        return (decks == 2) ? TWO_DECK_FEE : THREE_DECK_FEE;
    }
    
    public int getDecks() {
        return decks;
    }
    
    public int getMarines() {
        return marineCount;
    }
    
    @Override
    public boolean canFightEncounterType(EncounterType type) {
        // ManOWar can only fight battles and blockades
        return type == EncounterType.BATTLE || type == EncounterType.BLOCKADE;
    }
    
    @Override
    public String toString() {
        return String.format("%s, Decks: %d, Marines: %d, ManOWar", 
               super.toString(), decks, marineCount);
    }
}