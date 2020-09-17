// ---------------------------------------------
// Assignment 3
// Written by: Rami El-Kazma ID 40035141
// COMP 248 Section R
// ---------------------------------------------

public class Scale {

/* This class stores information about body weight and unit used (kg or lbs). It countains multiple methods
 * to manipulate these input data (calling objects, modifying values, etc.) It also has a method, namely
 * waterIntake() that generates the amount of water required through exercise depending on body weight. */

	private double weight;
	private String unitName;
	
	//Default constructor (sets weight to 0.0 and default unit to kg.)
	public Scale(){
		unitName = "kg";
	}
	
	//One-argument constructor (sets the weight to a value and assumes the unit to be kg.)
	public Scale(double inputWeight){
		weight = inputWeight;
		unitName = "kg";
	}
	
	//Two-argument constructor (sets the weight and the unit to values.)
	public Scale(double inputWeight, String unit){
		weight = inputWeight;
		unitName = unit;
	}
	
	//Accessor 1 (returns weight in kg) 
	public double getKg(){
		if (unitName.equalsIgnoreCase("kg"))
			return (weight);
		return (Math.round(weight*100.0/2.2)/100.0); //leaves only 2 decimal places
	}
	
	//Accessor 2 (returns weight in pounds)
	public double getLbs(){
		if (unitName.equalsIgnoreCase("lbs"))
			return (weight);
		return (Math.round(weight*2.2*100.0)/100.0); //leaves only 2 decimal places
	}
	
	//Mutator 1 (sets value of weight)
	public void setWeight(double inputWeight){
		weight = inputWeight;
	}
	
	//Mutator 2 (sets values for weight and unit)
	public void setWeightAndUnit(int inputWeight, String unit){
		weight = inputWeight;
		unitName = unit;
	}
	
	//Method to return recommended daily water intake (in cups), based on weight in pounds
	public int waterIntake(){
		double toDrink = (getLbs()/2)/8; 
		return ((int)toDrink);
	}

	//Second waterIntake() method, with daily exercise as an argument.
	public int waterIntake(int time){
		double drink = (getLbs()/2 + (12*time/30))/8;
		return ((int)drink);
	}
	
	//Print object
	public String toString(){
		return (weight + " " + unitName);
	}
	
	//Check if two objects are equal.
	public boolean equals(Scale weight_Unit){
		return(weight_Unit.getKg() == getKg()); //Kgs to Lbs conversion is taken into account
	}
	
	//Check if object is less than another object. 
	public boolean isLessThan(Scale weight_Unit){
		return(weight_Unit.getKg() > getKg()); //Kgs to Lbs conversion is taken into account
	}
	
	//Check if object is greater than another object.
	public boolean isGreaterThan(Scale weight_Unit){
		return(weight_Unit.getKg() < getKg()); //Kgs to Lbs conversion is taken into account
	}
	
}
