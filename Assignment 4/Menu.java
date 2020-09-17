// ---------------------------------------------
// Assignment 4
// Written by: Rami El-Kazma ID 40035141
// COMP 248 Section R
// ---------------------------------------------
import java.util.Arrays;
import java.util.Scanner;
public class Menu {

/* Represents the template on which all the menus in this program are based on. Sets the messages and
 * the way in which items are represented. */
	
	//instance variables for object Menu
	private String openingMessage;
	private String closingMessage;
	private String topPrompt;
	private String[] optionList = new String[0];
	private String bottomPrompt;
	private final String literalPrompt="?->";
	private int optionNumber;
	
	//constructor containing array
	public Menu(String[] options){
		openingMessage=null;
		closingMessage=null;
		topPrompt="Choose an option:";
		bottomPrompt="Enter an option number:";
		optionList=options; //assigns input array to Menu form
	}
	
	//constructor initializing all values to 0 of the type.
	public Menu(){
		openingMessage=null;
		closingMessage=null;
		topPrompt=null;
		bottomPrompt=null;
	}
	
	public boolean isEmpty(){
		return (optionList==null||optionList.length==0);
	}
	
	//returns the size of the array of the form Menu
	public int length(){
		if (optionList==null)
			return 0; //if array is empty
		else return(optionList.length);
	}
	
	//sets the string form of Menu to the desired form
	public String toString(){
		String array="";
		String str;
		for (int i=0; i<optionList.length;i++)
		{
			if (i<optionList.length-1)
				array=array+"\t"+"("+(i+1)+") "+optionList[i]+"\n";
			else array=array+"\t"+"("+(i+1)+") "+optionList[i];
		}
		
		//if the array is empty, print the messages without the array
		if (isEmpty())
			str = openingMessage+"\n"+topPrompt+"\n"+literalPrompt+" "
					+closingMessage+"\n"+bottomPrompt+" ";
		//print array
		else str = openingMessage+"\n"+topPrompt+"\n"+array+"\n"+literalPrompt+" "
				+closingMessage+"\n"+bottomPrompt+" ";
		//get rid of unnecessary spaces
		str = str.replaceAll(null+"\n","");
		str = str.replaceAll(null+" ","");
		return str;
	}
	
	//evaluates whether the option input by the user is valid
	public int getOptionNumber(){
		System.out.print(toString());
		Scanner myKeyboard = new Scanner(System.in);
		optionNumber = myKeyboard.nextInt();
		System.out.println();
		
		if(isEmpty())
			return optionNumber;
		else{
			while (optionNumber<1||optionNumber>optionList.length){
				System.out.print(toString());
				optionNumber = myKeyboard.nextInt();
				System.out.println();
			}
			return optionNumber;
		}
	}
	
	//getters
	public String getOpeningMessage(){
		return openingMessage;
	}
	
	public String getTopPrompt(){
		return topPrompt;
	}
	
	public String getClosingMessage(){
		return closingMessage;
	}
	
	public String getBottomPrompt(){
		return bottomPrompt;
	}
	
	//setters
	public void setOpeningMessage(String message){
		openingMessage=message;
	}
	
	public void setTopPrompt(String message){
		topPrompt=message;
	}
	
	public void setClosingMessage(String message){
		closingMessage=message;
	}
	
	public void setBottomPrompt(String message){
		bottomPrompt=message;
	}
	
	//method to set messages based on how many ice cream orders in the cart
	//takes the number of orders and the maximum size of the cart as input
	public void chooseMessages(int counter, int size){
		if (counter==0) //empty cart
		{
			setOpeningMessage("Your shopping cart is empty.");
			setTopPrompt("You have only two options: 1 or 6");
			setClosingMessage("Please enter 1 or 6");
		}
		if (counter>0&&counter<size) //presence of orders in cart
		{
			setOpeningMessage("Your shopping cart contains "+counter+" ice cream orders.");
			setTopPrompt("What would you like to do?");
			setClosingMessage(null);
		}
		if (counter==size) //full
		{
			setOpeningMessage("Your shopping cart is full with "+size+" ice cream orders.");
			setTopPrompt("Cannot place order! What would you like to do?");
			setClosingMessage("Please select option 2, 3, 4, 5, or 6");
		}
	}
}
