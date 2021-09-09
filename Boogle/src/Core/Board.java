/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import static Core.IDie.NUMBER_OF_SIDES;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Amulyasai
 */
public class Board implements IBoard{
  // adding memeber variables
  public ArrayList<String> diceData;
  public ArrayList<String> dictionaryData;
  public ArrayList<Die> gamedice;
// constructor with two parameter of typr arraylist  
  public void getData(ArrayList<String>dice,ArrayList<String>dictionary){
      diceData = dice;
      dictionaryData = dictionary;
      this.gamedice = new ArrayList<>();
  }
  public void populateDice(){
      // declaring variable of type calss Die
      Die die;
      // for loop for looping through the 16 dice and instantiating die
      for(int i=0; i<NUMBER_OF_DICE;i++){
          die = new Die();
          String letter = this.diceData.get(i);
          System.out.print("Dice"+i+":");
          // inner for loop for each die instance to loop through the 6 sides of the die
          for(int j=0; j<NUMBER_OF_SIDES;j++){
             // adding each of the 6 letters to the die 
             Scanner scan = new Scanner(letter);
             while(scan.hasNext()){
                 die.addLetter(scan.next());
                }
            }
          // displaying the letters of each die
          die.displayLetters();
          gamedice.add(die);
    }
}

    @Override
    public ArrayList shakedice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void populatedice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
