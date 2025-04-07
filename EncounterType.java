package wars;

import java.io.*;
/**
 * Enumeration class EncounterType - write a description of the enum class here
 * 
 * @author A.Marczyk
 * @version 12/02/2025
 */

public enum EncounterType implements Serializable {
    BLOCKADE("Blockade"), 
    BATTLE("Battle"), 
    SKIRMISH("Skirmish"), 
    INVALID("Invalid");

    private final String name;

    EncounterType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}