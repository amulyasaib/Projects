/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amulyasai Bangaru
 */
// updating the class so it implements an interface IReadDataFile
public class ReadDataFile implements IReadDataFile {
    public URL url;
    // storing the files
    public ReadDataFile(String filename){
        url = getClass().getResource("/data/"+filename);
    }
    // implementing method populateData
    public ArrayList<String> PopulateData(){
        // initializing member variable of type scanner based on the file 
        File populateFile = null;
        try { 
            populateFile = new File(url.toURI());
        } 
        catch(URISyntaxException ex){
            Logger.getLogger(ReadDataFile.class.getName()).log(Level.SEVERE,null,ex);
        }
        // scanning 
        Scanner scanning = null;
        ArrayList<String> output;
        output = new ArrayList<>();
        try{
            scanning = new Scanner(populateFile);
            while(scanning.hasNext()){
                output.add(scanning.nextLine());
            }
        }  
        catch (FileNotFoundException ex) {
                Logger.getLogger(ReadDataFile.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    return output;
}    

    @Override
    public void populateData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
