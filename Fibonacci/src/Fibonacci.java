/*
 * Amulyasai Bangaru
 * Documentation Assignment 
 * Professor Dr.Macon
 * October 13th,2021
 * */

import java.io.*;

public class Fibonacci {
	//function to calculate f(n) using iterative method
	public static int iterativeMethod(int n) {
		//System.out.println(n);
		//declaring values and setting them to default values for the base functions
		int sum = 1, current =1, previous =0;
		//looping through the values to calculate the sum till the nth value
		for(int i=0;i<n;i++) {
			sum = previous + current;
			previous = current;
			current = sum;
			//System.out.println(sum);
		}
		return sum;
	}
	//function to calculate f(n) using recursive method
	public static int recursiveMethod(int n) {
		//System.out.println(n);
		//if statement for the base value f(0)=1 and f(1)=1
		if(n == 0 || n==1){
			return 1;
		}
		
		else {
			return (recursiveMethod(n-1)+recursiveMethod(n-2));
		}
	}
	//main function
	public static void main(String[] args) throws IOException {
		System.out.println("Runtime efficiency in both recursive and iterative!");
		System.out.println("n               	Iterative              Recursive");
		System.out.println("------------------------------------------------------------");
		//for loop to loop through the values
		for(int n=0; n<41; n++) {
			//System.out.println(n);
			//calling the nano-function to start calculating the runtime while running the below function
			long startTime_i = System.nanoTime();
			//calling the iterative function
			iterativeMethod(n);
//			int value = iterativeMethod(n);
//			System.out.println(n+ ": " + value);
			//calling the nano-function to end
			long endTime_i = System.nanoTime();
			//finding the difference between the start and end time while running the function for each n value
			long iterative = (endTime_i - startTime_i);
			
			//calling the nano-function to start calculating the runtime while running the below function
			long startTime_r = System.nanoTime();
			//calling the recursive function
			recursiveMethod(n);
//			value = recursiveMethod(n);
//			System.out.println(n+": "+value);
			long endTime_r = System.nanoTime();
			//finding the difference between the start and end time while running the function for each n value
			long recursive = endTime_r - startTime_r;
			//printing the runtime for each n value in iterative and recursive Fibonacci functions
			System.out.println(n + ":			" + iterative +"			" + recursive);
		}
	}
	
}
