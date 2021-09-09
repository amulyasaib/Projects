/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author Amulyasai
 */
public interface IDie {
    // adding a constant field
    public static final int NUMBER_OF_SIDES = 6;
    // adding method signatures
    public String rollDie();
    public void addLetter(String letters);
    public void displayLetters();
    
}
