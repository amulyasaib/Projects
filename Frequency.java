/*
 * Amulyasai Bangaru
 * SDLC Assignment 
 * Professor Dr.Macon
 * September 20th,2021*/

import java.io.*;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Frequency {

	public static void main(String[] args) throws IOException {
		// using jsoup library to connect to the website
		Document doc = Jsoup.connect("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm").get();
		// using elementsbyclass feature to only the poem context and using .text to ignore the html tags
		String poem = doc.getElementsByClass("poem").text();
		//System.out.println(poem);
		// an array to store words and converting words into lowercase and splitting them
		String[] poemWords = poem.toLowerCase().split("[^a-zA-Z]+");
//		for(String i:poemWords) {
//			System.out.println(i);
//		}
		// calling the functions that finds the frequency and sorts in descending order
		frequencyAndSort(poemWords);
		
	}
	//function to sort and get the frequency
	public static void frequencyAndSort(String[] poemWords) {
		// using HashMap to store the data of the frequency of the words in the poem
		Map<String, Integer> frequncyOfWord = new HashMap<>();
		
		//using for loop to go through each words in the array to find the frequency of each word and then storing the data in the HashMap
        for(int i=0;i<poemWords.length;i++){
        	// if it contains the words already then increase the count by 1
            if(frequncyOfWord.containsKey(poemWords[i])) {
            	frequncyOfWord.put(poemWords[i], frequncyOfWord.get(poemWords[i])+1);
            }
            // else store the word with a count of i
            else{
            	frequncyOfWord.put(poemWords[i],1);
            }
        }
        	// creating a set from the elements in the HashMap
			Set<Map.Entry<String, Integer>> frequencyWordSet = frequncyOfWord.entrySet();
			//System.out.println(frequencyWordSet);
			
			List<Map.Entry<String, Integer>> frequencyWordlist = new ArrayList<Map.Entry<String, Integer>>(frequencyWordSet);
			//System.out.println(list);
			
			//collections.sort method to sort the values in the list by access the values and comparing to the next value 
			Collections.sort(frequencyWordlist, new Comparator<Map.Entry<String, Integer>>(){
				public int compare(Map.Entry<String, Integer>first, Map.Entry<String, Integer>next) {
					return (next.getValue()).compareTo(first.getValue());
				}
			});
			//System.out.println(list);
			//printing the values in descending order by displaying their key(word) and value(frequency of the word)
			for(Map.Entry<String, Integer>i:frequencyWordlist) {
				System.out.println(i.getKey()+" - "+i.getValue());
			}
        
	}
}
