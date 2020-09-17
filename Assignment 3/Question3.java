// ---------------------------------------------
// Assignment 3
// Written by: Rami El-Kazma ID 40035141
// COMP 248 Section R
// ---------------------------------------------

public class Question3 {

/* This program is a test code for the class Scale. It checks whether the different methods in 
 * the class work as intended. */
	
	public static void main(String[] args) {
		
		int workout1 = 90, workout2 = 60; //workout minutes
		Scale weight1 = new Scale(); //Default constructor
		Scale weight2 = new Scale(50); //One argument constructor
		Scale weight3 = new Scale(110, "lbs"); //Two argument constructor

		System.out.println("Test Program\n");

		//Testing constructors with the toString method.
		System.out.println("Weight 1: " + weight1.toString());
		System.out.println("Weight 2: " + weight2.toString());
		System.out.println("Weight 3: " + weight3.toString() + "\n");

		//Testing accessors
		System.out.println("Weight 2 in pounds: " + weight2.getLbs());
		System.out.println("Weight 3 in kg: " + weight3.getKg() + "\n");

		//Testing both waterIntake() methods first without workout followed by with a workout
		System.out.println("Daily water intake for " + weight2.toString() + " is " + weight2.waterIntake() 
		+ " cups");
		System.out.println("Daily water intake for " + weight3.toString() + " is " + weight3.waterIntake() 
		+ " cups");
		System.out.println("Daily water intake for " + weight2.toString() + " and " + workout1 + "min workout is " 
		+ weight2.waterIntake(workout1) + " cups");
		System.out.println("Daily water intake for " + weight3.toString() + " and " + workout2 + "min workout is " 
		+ weight3.waterIntake(workout2) + " cups\n");

		//Testing equals method
		System.out.println("Weight 1 (" + weight1.toString() + ") = Weight 2 (" + weight2.toString() + ")? \t" + 
				weight1.equals(weight2));
		System.out.println("Weight 2 (" + weight2.toString() + ") = Weight 3 (" + weight3.toString() + ")?\t" + 
				weight2.equals(weight3) + "\n");
		
		//Modify weight1 to 50kg using the first mutator
		weight1.setWeight(50);
		System.out.println("Modify Weight 1: " + weight1.toString());

		//Checking whether Weight 1 is equal to Weight 2 and Weight 3
		System.out.println("Weight 1 (" + weight1.toString() + ") = Weight 2 (" + weight2.toString() + ")?\t" + 
				weight1.equals(weight2));
		System.out.println("Weight 1 (" + weight1.toString() + ") = Weight 3 (" + weight3.toString() + ")?\t" + 
				weight1.equals(weight3) + "\n");
		
		//Creating a "Weight 4" through object weight4 using second mutator
		Scale weight4 = new Scale();
		weight4.setWeightAndUnit(50, "lbs");
		System.out.println("Weight 4: " + weight4.toString());

		//Checking whether Weight 4 is equal to Weight 2 and Weight 3
		System.out.println("Weight 4 (" + weight4.toString() + ") = Weight 2 (" + weight2.toString() + ")?\t" + 
				weight4.equals(weight2));
		System.out.println("Weight 4 (" + weight4.toString() + ") = Weight 3 (" + weight3.toString() + ")?\t" + 
				weight4.equals(weight3) + "\n");
		
		//Testing the isLessThan() method
		System.out.println("Weight 2 (" + weight2.toString() + ") < Weight 4 (" + weight4.toString() + ")?\t" + 
				weight2.isLessThan(weight4));
		System.out.println("Weight 3 (" + weight3.toString() + ") < Weight 4 (" + weight4.toString() + ")?\t" + 
				weight3.isLessThan(weight4) + "\n");
	
		//Testing the isGreaterThan() method
		System.out.println("Weight 2 (" + weight2.toString() + ") > Weight 4 (" + weight4.toString() + ")?\t" + 
				weight2.isGreaterThan(weight4));
		System.out.println("Weight 3 (" + weight3.toString() + ") > Weight 4 (" + weight4.toString() + ")?\t" + 
				weight3.isGreaterThan(weight4) + "\n");
		
		//More comparisons
		System.out.println("Weight 1 (" + weight1.toString() + ") < Weight 2 (" + weight2.toString() + ")?\t" + 
				weight1.isLessThan(weight2));
		System.out.println("Weight 1 (" + weight1.toString() + ") > Weight 3 (" + weight3.toString() + ")?\t" + 
				weight1.isGreaterThan(weight3) + "\n");
		
		System.out.print("Enjoy the rest of your day!");		

	}

}
