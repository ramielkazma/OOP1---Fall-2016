// ---------------------------------------------
// Assignment 3
// Written by: Rami El-Kazma ID 40035141
// COMP 248 Section R
// ---------------------------------------------

import java.util.Arrays;
import java.util.Scanner;
public class Question2 {
	
/* This program simulates a booking system in which users have the seating plan displayed such that
 * they can see all available seats and it displays the price of each seat as they are different in
 * different levels. At each booking, it asks the users for the amount of tickets needed and the seats
 * they require. The seating plan is adjusted after every booking to show how many seats are left and
 * which seats are taken denoted by the 'X'. If all seats are taken, or the user attempts to book more
 * than the available seats, the program will terminate. */
	
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		int seatsAvailable, seatsRequired, seatsTaken = 0;
		int[][] seatingPlan = new int[6][8];
		double price = 0.0;
		String seat, newBooking;

		System.out.println("Welcome to Ticketmaster: the only official source for your tickets.\n");

		//Forming the seating plan by initializing the array with the number and letter values
		for (int i = 0; i < 6; i++){
			seatingPlan[i][0] = i + 1;
			for (int j = 1; j <= 7; j++)
				seatingPlan[i][j] = '@'+j; //@ is before A in the ASCII code, '@'+1 will give A.
			//at every iteration it will be incremented such that at 2nd iteration it will give B, and so on.
		}
		do{	
			//Print seating plan.
			for (int k = 0; k < 6; k++){
				System.out.print(seatingPlan[k][0] + " ");
				for (int h = 1; h <= 7; h++)
					System.out.print((char)seatingPlan[k][h] + " ");
				System.out.println();
			}
			System.out.println();
			System.out.println("Rows 1 & 2 Gold \t100 CAD/ticket");
			System.out.println("Rows 3 & 4 Silver\t 70 CAD/ticket");
			System.out.println("Rows 5 & 6 Bronze\t 40 CAD/ticket");

			//Count the number of seats reserved.
			for (int i = 0; i < 6; i++)
			{
				for (int j = 1; j <= 7; j++)
					if (seatingPlan[i][j] == 'X')
						seatsTaken++;
			}
			seatsAvailable = seatingPlan.length*(seatingPlan[0].length - 1) - seatsTaken;	

			//Show the user how many seats are still available.
			System.out.println("\nAvailable seats " + seatsAvailable);
			System.out.println("How many tickets do you need?");
			seatsRequired = keyboard.nextInt(); //Input how many tickets needed
			
			//Check if there are enough seats
			if (seatsRequired > seatsAvailable)
			{
				System.out.println("Sorry, the system cannot process your request.");
				System.out.println("No more seats are available.");
				break;
			}
			else //there are enough available seats
			{
				for (int i = 0; i < seatsRequired; i++)
				{
					System.out.println("Input your seat selection.");
					System.out.println("Enter the row number followed by the seat letter (example: 3B):");
					seat = keyboard.next();

					//All forms of user "errors" that will not allow the user to book a seat.
					//We use a loop to allow the user to keep trying to get the right form of the seat
					//they wish to book.
					while (seat.charAt(0) < '1' || seat.charAt(0) > '6' || seat.charAt(1) < 'A' || 
							seat.charAt(1) > 'G' || 
							seatingPlan[seat.charAt(0) - '1'][seat.charAt(1) - 'A' + 1] == 'X')
					{
						if ((seat.charAt(0) < '1' || seat.charAt(0) > '6') && (seat.charAt(1) < 'A' || 
								seat.charAt(1) > 'G'))//invalid seat
							System.out.println("Invalid seat assignment. Please try again:");
						else if (seat.charAt(0) < '1' || seat.charAt(0) > '6') //wrong seat number
							System.out.println("Invalid row number. Please try again:");
						else if (seat.charAt(1) < 'A' || seat.charAt(1) > 'G') //wrong seat letter
							System.out.println("Invalid seat letter. Please try again:");
						else //seat is taken
							System.out.println("Sorry, seat is taken. Please try again:");

						seat = keyboard.next();
					}

					//Calculate and display balance.
					if (seat.charAt(0) == '1' || seat.charAt(0) == '2')
						price += 100;
					else if (seat.charAt(0) == '3' || seat.charAt(0) == '4')
						price += 70;
					else if (seat.charAt(0) == '5' || seat.charAt(0) == '6')
						price += 40;
					System.out.println("Your seat is reserved. Your balance is CAD " + price + "\n");
					
					//Denote a taken seat by an 'X' value.
					seatingPlan[seat.charAt(0) - '1'][seat.charAt(1) - 'A' + 1] = 'X';
					for (int k = 0; k < 6; k++){
						System.out.print(seatingPlan[k][0] + " ");
						for (int h = 1; h <= 7; h++)
							System.out.print((char)seatingPlan[k][h] + " ");
						System.out.println();
					}
				}
				System.out.println("Reservation complete. Please proceed to payement.");
				price = 0.0; // Resets balance for following booking.
				seatsTaken = 0;//Avoid double counting seats taken.
				System.out.println("Do you wish to start a new booking? (yes/no)?");
				newBooking = keyboard.next();
			}
		}
		while (newBooking.equalsIgnoreCase("yes") && seatsRequired <= seatsAvailable);
		
		System.out.println("\nThank you for booking with Ticketmaster. Enjoy the show!");
	}


}
