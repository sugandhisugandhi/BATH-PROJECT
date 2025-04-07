/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author 
 */

import java.io.Serializable;

/**
 * Represents a Frigate ship in the Sea Battles game
 * @author yourName
 */

public class Frigate extends Ship implements Serializable {
    private int cannons;
    private boolean hasPinnace;
    
    public Frigate(String name, String captain, int battleSkill, int cannons, boolean hasPinnace) {
        super(name, captain, battleSkill);
        this.cannons = cannons;
        this.hasPinnace = hasPinnace;
        this.commissionFee = cannons * 10;
    }
    
    public int getCannons() {
        return cannons;
    }
    
    public boolean hasPinnace() {
        return hasPinnace;
    }
    
    @Override
    public boolean canFightEncounterType(EncounterType type) {
        if (type == null) return false;
        return type == EncounterType.BATTLE || 
               type == EncounterType.SKIRMISH || 
              (type == EncounterType.BLOCKADE && hasPinnace);
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + cannons + " cannons, " + 
               (hasPinnace ? "with pinnace" : "no pinnace") + ", Frigate";
    }
}