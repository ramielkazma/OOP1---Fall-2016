
//--------------------------------------
// Assignment 1
// Written by: Rami El-Kazma 40035141
// For COMP 248 Section R - Fall 2016
//--------------------------------------

import java.util.Scanner;
public class Question1 {
	
/* This program takes as input from the user the amount of students coming from in province, outside the
 * province, and internationally. It then calculates the number of total students in class in order to
 * provide percentages of students based on where they come from. */
	
	public static void main(String[] args) {
		
		System.out.println("Hello! We are collecting statistics about where the students come from.\n");
		
		Scanner keyboard = new Scanner(System.in);
		//The user inputs integer values for the number of students. We also require the percentages
		//to be integer values. The doubles are for decimal notation of percentages.
		int inProvince, outProvince, international, totalStudents, percentIn, percentOut, percentIntl;
		double in, out, intl;
		
		//Prompting user input and calculating the total number of students.
		System.out.print("Please enter the amount of in province students. ");
		inProvince = keyboard.nextInt();
		System.out.print("Please enter the amount of out of province students. ");
		outProvince = keyboard.nextInt();
		System.out.print("Please enter the amount of international students. ");
		international = keyboard.nextInt();
		totalStudents = inProvince + outProvince + international;
		System.out.println("Great! There are " + totalStudents + " students "
				+ "in the class.");
		System.out.println("");
		
		//In order to calculate the decimals (ratios), we have to convert the integers into 
		//doubles by way of casting.
		in = (double)inProvince/totalStudents;
		out = (double)outProvince/totalStudents;
		intl = (double)international/totalStudents;
		
		//We keep percentages in integer form.
		percentIn = inProvince*100/totalStudents;
		percentOut = outProvince*100/totalStudents;
		percentIntl = international*100/totalStudents;
		
		//Display percentage of students from each location.
		System.out.println("In Province: " + in + " or ~" + percentIn + "%");
		System.out.println("Out of Province: " + out + " or ~" + percentOut + "%");
		System.out.println("International: " + intl + " or ~" + percentIntl + "%\n");
		
		System.out.println("Thank you. Have a great term!");
		keyboard.close();

	}

}
