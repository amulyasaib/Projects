/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.ArrayList;

/**
 *
 * @author Amulyasai Bangaru
 */
public interface IBoard {
    // adding constant fiels 
    public static final int NUMBER_OF_DICE = 16;
    public static final int GRID = 4;
    // adding method signatures for populateDice and shakeDice
    public ArrayList shakedice();
    public void populatedice();
}
