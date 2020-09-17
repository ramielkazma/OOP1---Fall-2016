// ---------------------------------------------
// Assignment 3
// Written by: Rami El-Kazma ID 40035141
// COMP 248 Section R
// ---------------------------------------------

import java.util.Scanner;
import java.util.Arrays;
public class Question1 {

/* This program takes nouns and adjectives (as well as the number of them) as input from the user
 * in order to write a poem using just those words. It generates a poem of 3 lines every time (3 adjectives
 * and 3 nouns). It has to go through all adjectives and nouns before selecting an already used word again. */
	
	public static void main(String[] args) {
		Scanner myKeyboard = new Scanner(System.in);
		int nouns=0,adjectives=0, adjCounter=0, nounCounter=0, randomAdjective, randomNoun;
		String repeat="no", tempAdjective, tempNoun;
		
		System.out.println("Do you want to write a poem?\n");
		while (nouns<3){ //cannot select less than 3 nouns
			System.out.println("How many nouns? (min 3)");
			nouns = myKeyboard.nextInt();
			if (nouns<3) //error message in case user attempts to input less than 3 nouns
				System.out.println("Please enter at least 3 nouns.");
		}
			
		while (adjectives<3){
			System.out.println("How many adjectives? (min 3)");
			adjectives = myKeyboard.nextInt();
			if (adjectives<3)
				System.out.println("Please enter at least 3 adjectives.");
		}
		//creating the noun and adjective arrays with user input values as length
		String[]nounList = new String[nouns];
		String[]adjectiveList = new String[adjectives];
		
		System.out.println("Enter " + nouns + " nouns:");
		for (int i=0; i<nounList.length;i++)
			nounList[i]=myKeyboard.next(); //store the noun values in the array
		
		System.out.println("Enter " + adjectives + " adjectives:");
		for (int i=0; i<adjectiveList.length;i++)
			adjectiveList[i]=myKeyboard.next(); //store adjective values in the array
		
		System.out.println("Here is the poem:\n"); //Begin writing the poem.
		
		do{
			for (int i=0; i<3; i++)
			{
				//forming the spacing (tabs)
				for (int j=0; j<i;j++)
					System.out.print("\t"); //line 1: 0 tabs, line 2: 1 tab, line 3: 2 tabs

				if (nounCounter > nounList.length - 1) //Reset adjective counter once all nouns are used.
					nounCounter = 0;
				if (adjCounter > adjectiveList.length - 1) //Reset adjective counter once all adjectives are used.
					adjCounter = 0;

				//Select random noun and adjective and print.
				randomNoun = (int)(Math.random()*(nounList.length - nounCounter));
				randomAdjective = (int)(Math.random()*(adjectiveList.length - adjCounter));
				System.out.println(adjectiveList[randomAdjective] + " " + nounList[randomNoun]);
				
				//sort the arrays such that the most recently used adjective or noun is set to the last index
				tempAdjective = adjectiveList[randomAdjective];
				adjectiveList[randomAdjective] = adjectiveList[adjectiveList.length - 1 - adjCounter];
				adjectiveList[adjectiveList.length - 1 - adjCounter] = tempAdjective;
				
				tempNoun = nounList[randomNoun];
				nounList[randomNoun] = nounList[nounList.length - 1 - nounCounter];
				nounList[nounList.length - 1 - nounCounter] = tempNoun;
				
				//incrementing the counters so that the random function has one less element (most recently
				//used adjective or noun) to choose from, until it is reset when all elements have been used).
				adjCounter++; nounCounter++;
			}
			System.out.println();
			System.out.print("Another poem? Type \"yes\" or \"no\": ");
			repeat = myKeyboard.next();
			System.out.println();
		}
		while(repeat.equalsIgnoreCase("yes"));
		
		System.out.println("Hope you enjoyed writing poems with JAVA!");
	}
		
}
