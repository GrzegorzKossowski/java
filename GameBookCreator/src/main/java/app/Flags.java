/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author grze
 */
public enum Flags {
    
    START("START"),
    READY("READY"),
    DEAD("DEAD"),
    END("END"),
    WIN("WIN"),
    TODO("TODO");
    
    private final String value;

    private Flags(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }    
    
        
}
