/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boggle;
import Core.Board;
import inputOutput.ReadDataFile;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Amulyasai Bangaru 
 */
public class Boggle {
    // creating memeber variables
    public static  ArrayList<String> diceData = new ArrayList<String>();
    public static ArrayList<String> dictionaryData = new ArrayList<String>();
    public static  String dataFile = "BoggleData.txt";
    public static  String dictionaryFile = "Dictionary.txt";
    
     /**
     * @param args the command line arguments
    
     */
    /*using the static method to write the output to the output console and also to display a UI message*/ 
    public static void main(String[] args) {
        // prints out a message saying "Welcome to Boggle!"
        System.out.println("Welcome to Boggle!");
        // pop-up box displaying a message saying "Let's Play Boggle"
        JOptionPane.showMessageDialog(null, "Let's Play Boggle!");
        // instantiating and populating the dice and dictionary data 
        ReadDataFile diceDataFile = new ReadDataFile(dataFile);
        diceData = diceDataFile.PopulateData();
        ReadDataFile dictionaryDataFile = new ReadDataFile(dictionaryFile);
        dictionaryData = dictionaryDataFile.PopulateData();
        // instantiating board 
        Board board = new Board();
        board.getData(diceData,dictionaryData);
        board.populateDice();
        // printing out a mesage showing  the number of objects in the dictionary data file 
        System.out.println("There are "+dictionaryData.size()+ " entries in the dictionary.");
    }
}
