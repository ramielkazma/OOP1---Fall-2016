
//--------------------------------------
// Assignment 1
// Written by: Rami El-Kazma 40035141
// For COMP 248 Section R - Fall 2016
//--------------------------------------

import java.util.Scanner;
public class Question3 {
/* This program acts as a package price calculator for a movie streaming website. It asks the 
 * user to input the amount of shows and movies they watch in a month in order to calculate the 
 * best package in terms of saving money as each package has certain advantages. */
	public static void main(String[] args) {
		System.out.println("Hello! Welcome to CineShow package calculator. We will help you"
				+ "determine how you could save the most money while enjoying our services.\n");
		//These constants are to simplify the operations that will be used to calculate the price
		//of each package.
		final double showPPV = 0.99, moviePPV = 3.99, showLimited = 1.99, 
				movieLimited = 3.99;
		Scanner keyboard = new Scanner(System.in);
		
		//Number of shows input will be integers but the prices of the packages have to be exact
		//and they contain decimals, so doubles are used.
		int shows, movies;
		double PayPerView, limited, unlimited;
		
		//Since the number of shows input is per week, we will need to multiply by 4 to calculate
		//the equivalence for the month as the packages are priced by month.
		System.out.print("How many shows a week do you watch? ");
		shows = 4*keyboard.nextInt();
		System.out.print("How many movies a month do you watch? ");
		movies = keyboard.nextInt();
		System.out.println("");
		
		//PayPerView has a fixed calculation based on the amount of shows and movies.
		PayPerView = (shows * showPPV) + (movies * moviePPV);
		
		//LIMITED PACKAGE CALCULATION
		//The limited package is priced for a limited amount of movies and shows, but might still
		//be the best option if the price is less than the other packages.
		limited = 15.95; //set price for up to 2 movies and 20 shows
		if (movies >= 2)
			limited = limited + ((movies - 2)*movieLimited); //price if movies limit is surpassed
		if (shows >= 20)
			limited = limited + ((shows - 20)*showLimited); //price if shows limit is surpassed
		//at every step we add onto the limited calculation depending on user input.
		
		//unlimited package has a fixed priced no matter the user input.
		unlimited = 25.95;
		
		//We use the if, else if, and else statements because there is only one condition that 
		//will be acceptable.
		if (PayPerView < unlimited && PayPerView < limited)
				System.out.println("The cost of Pay-per-view would be: $.\n"
						+ PayPerView);
		else if (limited < unlimited)
		{	
			System.out.println("The cost of the limited package would be $" + limited + ". We "
					+ "recommend getting the limited package!");
			System.out.println("You would save $" + (PayPerView - limited) +
					" from pay-per-view!\n");
		}
		else
		{
			System.out.println("The cost of the limited package would be $" + unlimited + ". We "
					+ "recommend getting the unlimited package!");
			System.out.println("You would save $" + (limited - unlimited) + " from"
			+ " the limited package and $" + (PayPerView - unlimited) 
							+ " from the pay-per-view!\n");
		}
		System.out.println("Thank you for using the CineShow package calculator. Happy streaming!");
		keyboard.close();

		}
		
	}


