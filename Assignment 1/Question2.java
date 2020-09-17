
//--------------------------------------
// Assignment 1
// Written by: Rami El-Kazma 40035141
// For COMP 248 Section R - Fall 2016
//--------------------------------------

import java.util.Scanner;
public class Question2 {
/* This program is a guessing game. It generates a random number between 0 and 100 and asks the
 * user to guess it in 5 tries, while giving a hint at each guess as to whether the number is 
 * higher or lower. */
	public static void main(String[] args) {
		
		System.out.println("Welcome to \"Guess the Number\", the hardest guessing game in the world.");
		System.out.println("");
		
		Scanner keyboard = new Scanner(System.in);
		//We only deal with integer values as it becomes nearly impossible with decimals.
		//The boolean variable is used at every if else repetition to check whether the guessed answer 
		//is correct in order to exit the program.
		int numberGuessed, randomNumber;
		boolean Answer;
		
		//The Math.random function is used to generate a random number. Since the Math.random() method
		//automatically generates decimals, we need to cast it into an integer.
		//The "* 101" aspect is to generate a number from 0 to 100 as the range will be 101 (lowerbound
		//is 0 and upperbound is 100) since generally this method without any other input produces a 
		//number from 0 to 1.
		randomNumber = (int)(Math.random() * 101);
		System.out.print("Pick a number between 0 and 100. You have 5 tries. ");
		
		numberGuessed = keyboard.nextInt();
		//if, else if, and else are used to calculate for all options available, as there will be one
		//of three options (too high, too low, or correct) for every integer that is input by the user.
		//the boolean variable Answer allows us to moderate when to exit the program (ie. exit if
		//correct but keep going if not
		if (numberGuessed > randomNumber)
			{
			System.out.print("You are too high. Try again. ");
			Answer = false;
			}
		else if (numberGuessed < randomNumber)
			{
			System.out.print("You are too low. Try again. ");
			Answer = false;
			}	
		else
			{
			System.out.println("You are correct! The number is " + randomNumber + ".\n");
			Answer = true;
			}
		
		//Every iteration of the if, else if, and else statements are for new guesses by the user.
		if (Answer == false) //determines whether the previous guessed answer is correct or not
		{
			numberGuessed = keyboard.nextInt();
			if (numberGuessed > randomNumber)
			{
				System.out.print("You are too high. Try again. ");
				Answer = false;
			}
			else if (numberGuessed < randomNumber)
			{
				System.out.print("You are too low. Try again. ");
				Answer = false;
			}
			else
			{
				System.out.println("You are correct! The number is " + randomNumber + ".\n");
				Answer = true;
			}
		}
		
		if (Answer == false)
		{
			numberGuessed = keyboard.nextInt();
			if (numberGuessed > randomNumber)
			{
				System.out.print("You are too high. Try again. ");
				Answer = false;
			}
			else if (numberGuessed < randomNumber)
			{
				System.out.print("You are too low. Try again. ");
				Answer = false;
			}
			else
			{
				System.out.println("You are correct! The number is " + randomNumber + ".\n");
				Answer = true;
			}
		}
		
		if (Answer == false)
		{
			numberGuessed = keyboard.nextInt();
			if (numberGuessed > randomNumber)
			{
				System.out.print("You are too high. Try again. ");
				Answer = false;
			}
			else if (numberGuessed < randomNumber)
			{
				System.out.print("You are too low. Try again. ");
				Answer = false;
			}
			else
			{
				System.out.println("You are correct! The number is " + randomNumber + ".\n");
				Answer = true;
			}
			
		}
		if (Answer == false)
		{
			numberGuessed = keyboard.nextInt();
			//Since this is the last try, either the user will get the correct answer or not. Therefore,
			//in this instance there is only and if else statement.
			System.out.println("");
			if (numberGuessed != randomNumber)
				System.out.println("Sorry, that was wrong. The correct number was " 
						+ randomNumber + ".");
			else
				System.out.println("You are correct! The number is " + randomNumber + ".\n");
		}
		
		System.out.println("Thank you for playing \"Guess the Number\"!");
		keyboard.close();
			
		

	}

}
