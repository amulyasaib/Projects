/*
 * Amulyasai Bangaru
 * SDLC Assignment - UI design
 * Professor Dr.Macon
*/


package application;
	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
			
		
	        try {
			primaryStage.setTitle("Word Occurence");
			Label question= new Label("Enter a word to see its occurence in the poem");
			question.setStyle("-fx-text-fill: pink;-fx-font-size: 15px;");
			Label label= new Label();
			label.setStyle("-fx-text-fill:white;-fx-font-size: 15px;");
			Button button= new Button("Submit");
			TextField word= new TextField();
			VBox layout= new VBox(10);
			layout.setStyle("-fx-background-color: black");
			layout.getChildren().addAll(question, word, button, label);
			Scene scene1= new Scene(layout, 300, 150);
			primaryStage.setScene(scene1);
			        
			primaryStage.show();
			// using jsoup library to connect to the website
			Document doc = Jsoup.connect("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm").get();
			// using elementsbyclass feature to only the poem context and using .text to ignore the html tags
			String poem = doc.getElementsByClass("chapter").text();
			//System.out.println(poem);
			// an array to store words and converting words into lowercase and splitting them
			String[] poemWords = poem.toLowerCase().split("[^a-zA-Z]+");
//			for(String i:poemWords) {
//				System.out.println(i);
//			}
			Map<String, Integer> frequencyOfWord = new HashMap<>();
			
			//using for loop to go through each words in the array to find the frequency of each word and then storing the data in the HashMap
	        for(int i=0;i<poemWords.length;i++){
	        	// if it contains the words already then increase the count by 1
	            if(frequencyOfWord.containsKey(poemWords[i])) {
	            	frequencyOfWord.put(poemWords[i], frequencyOfWord.get(poemWords[i])+1);
	            }
	            // else store the word with a count of i
	            else{
	            	frequencyOfWord.put(poemWords[i],1);
	            }
	        }
			//frequencyAndSort(poemWords);
			button.setOnAction(e -> 
			{
			// assigning the word user has entered to a string
			String poemWord = word.getText();
			//using .get to find the frequency of the word user has entered
			int frequency = frequencyOfWord.get(poemWord);

			label.setText("The word " + "'" + word.getText() + "' occurs "+ frequency + " times in the poem.");
			//frequencyAndSort(poemWord);

			});
	        }
	        catch (Exception e) {
	        	  
	            System.out.println(e.getMessage());
	        }
			}


	public static void main(String[] args) throws IOException {

		launch(args);
		//System.out.println("Working Amulya!");
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	//function to sort and get the frequency
//		public static void frequencyAndSort(String[] poemWords) {
//			// using HashMap to store the data of the frequency of the words in the poem
//			Map<String, Integer> frequencyOfWord = new HashMap<>();
//			
//			//using for loop to go through each words in the array to find the frequency of each word and then storing the data in the HashMap
//	        for(int i=0;i<poemWords.length;i++){
//	        	// if it contains the words already then increase the count by 1
//	            if(frequencyOfWord.containsKey(poemWords[i])) {
//	            	frequencyOfWord.put(poemWords[i], frequencyOfWord.get(poemWords[i])+1);
//	            }
//	            // else store the word with a count of i
//	            else{
//	            	frequencyOfWord.put(poemWords[i],1);
//	            }
//	        }
//	        	// creating a set from the elements in the HashMap
//				Set<Map.Entry<String, Integer>> frequencyWordSet = frequencyOfWord.entrySet();
//				//System.out.println(frequencyWordSet);
//				
//				List<Map.Entry<String, Integer>> frequencyWordlist = new ArrayList<Map.Entry<String, Integer>>(frequencyWordSet);
//				//System.out.println(frequencyWordlist);
//				System.out.println("Printing the frequecy of words");
//				System.out.println(frequencyOfWord);
//				int frequency = frequencyOfWord.get("the");
//				System.out.println(frequency);
//				
//				//collections.sort method to sort the values in the list by access the values and comparing to the next value 
////				Collections.sort(frequencyWordlist, new Comparator<Map.Entry<String, Integer>>(){
////					public int compare(Map.Entry<String, Integer>first, Map.Entry<String, Integer>next) {
////						return (next.getValue()).compareTo(first.getValue());
////					}
////				});
//				//System.out.println(list);
//				//printing the values in descending order by displaying their key(word) and value(frequency of the word)
////				for(Map.Entry<String, Integer>i:frequencyWordlist) {
////					System.out.println(i.getKey()+" - "+i.getValue());
////				}
//	        
//		}

