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
public enum EPriviledges {
    
    ADMIN("admin"),
    DOCTOR("doctor"),
    USER("user");
    
    private final String value;

    public String getValue() {
        return value;
    }

    private EPriviledges(String value) {
        this.value = value;
    }
    
}
