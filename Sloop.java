/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;
import java.io.Serializable;
/**
 *
 * @author 
 */

public class Sloop extends Ship {
    private boolean hasDoctor;

    // Constructor: Initializes a Sloop with its name, captain, commission fee, and doctor presence
    public Sloop(String name, String captain, double commissionFee, boolean hasDoctor) {
        super(name, captain, 5); // All Sloops have a fixed crew size of 5
        this.hasDoctor = hasDoctor;
        this.commissionFee = commissionFee; // Assuming this is a field inherited from Ship
    }

    // Returns whether the Sloop has a doctor on board
    public boolean hasDoctor() {
        return hasDoctor;
    }

    // Defines the types of encounters this ship can participate in
    @Override
    public boolean canFightEncounterType(EncounterType type) {
        return type == EncounterType.BATTLE || type == EncounterType.SKIRMISH;
    }

    // Returns a string representation of the Sloop including doctor presence and ship type
    @Override
    public String toString() {
        return super.toString() + String.format(", %b, Sloop", hasDoctor);
    }
}
