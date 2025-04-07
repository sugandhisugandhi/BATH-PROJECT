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
import java.util.Objects;

/**
 * Represents a naval encounter with attributes like type, location, and rewards.
 * Implements Serializable to allow object serialization for saving game state.
 */
public class Encounter implements Serializable {
    
    private static final long serialVersionUID = 1L;  // Recommended for Serializable classes
    
    private final int encounterNumber;
    private final EncounterType type;
    private final String location;
    private final int requiredSkill;
    private final double prizeMoney;
    
    /**
     * Constructs a new Encounter with specified parameters.
     * 
     * @param encounterNumber Unique identifier for the encounter
     * @param type Type of encounter (enum)
     * @param location Where the encounter takes place
     * @param requiredSkill Minimum skill level needed
     * @param prizeMoney Monetary reward for completion
     */
    public Encounter(int encounterNumber, EncounterType type, String location, 
                    int requiredSkill, double prizeMoney) {
        this.encounterNumber = encounterNumber;
        this.type = Objects.requireNonNull(type, "Encounter type cannot be null");
        this.location = Objects.requireNonNull(location, "Location cannot be null");
        this.requiredSkill = requiredSkill;
        this.prizeMoney = prizeMoney;
    }
    
    // Getters (no setters to maintain immutability)
    public int getEncounterNumber() { return encounterNumber; }
    public EncounterType getType() { return type; }
    public String getLocation() { return location; }
    public int getRequiredSkill() { return requiredSkill; }
    public double getPrizeMoney() { return prizeMoney; }

    /**
     * Provides formatted string representation of the encounter.
     * @return Human-readable encounter description
     */
    @Override
    public String toString() {
        return String.format("Encounter #%d: %s at %s (Skill: %d, Prize: £%.2f)",
                encounterNumber, type, location, requiredSkill, prizeMoney);
    }

    /**
     * Checks equality based on encounter number.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encounter encounter = (Encounter) o;
        return encounterNumber == encounter.encounterNumber;
    }

    /**
     * Generates hash code based on encounter number.
     */
    @Override
    public int hashCode() {
        return Objects.hash(encounterNumber);
    }
}
