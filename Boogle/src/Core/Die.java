/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.ArrayList;

/**
 *
 * @author Amulyasai
 */
// updating the class so that it implements an interface of IDie
public class Die implements IDie {
    // adding memeber variable
    private static ArrayList<String> sides;
    public Die(){
        this.sides = new ArrayList<>();
    }
    // implementing a method addLetter to add letter to the array list
    @Override
    public void addLetter(String letter){
        this.sides.add(letter);
     }
    // using the for loop to output the letter on each of the six sides of the die
    @Override
    public void displayLetters(){
      for(int i=0;i<NUMBER_OF_SIDES;i++){
         
          System.out.print(this.sides.get(i)+"");
    }
    System.out.print("\n");   
    }

    @Override
    public String rollDie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
