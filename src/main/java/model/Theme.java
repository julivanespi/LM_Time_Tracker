/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author julio
 */
public enum Theme {
    LIGHT("light"),
    DEFAULT("default");
    
    private final String label;
    
    private Theme(String label){
        this.label = label;
    }
    
    public String getLabel(){
        return this.label;
    }
}
