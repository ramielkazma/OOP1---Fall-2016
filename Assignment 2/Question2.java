import java.util.Scanner;
public class Question2 {
	
/* This program asks the user for a 5 character string. It then modifies each character
 * abiding by a formula, reverses the order, and generates a new password. */

	public static void main(String[] args) {
		
		Scanner myKeyboard = new Scanner(System.in);
		
		System.out.println("Hello. Thank you for using our new Pasword Generator!\n");
		System.out.print("Enter a 5 character word. ");
		
		String input = myKeyboard.next();	//prompting user input
		
		int loopCount = 5, charCount = 4; 
		//loopCount defines how long the loop will go for
		//charCount defines the character that will be extracted from the code at each loop in order to
		//change it into the desired form and add it in the right order
		char letter; 	//store letters that will be encrypted
		String password = ""; //null string where we will add the modified characters to store the final password 
				
		if (input.length()==5) //checks whether the input String is 5 characters long or not
		{
			while (loopCount>=1) 
			//We require the it to loop 5 times (the condition is set since loopCount is initialized at 5)
			{
				//values of letter and letterPassword change with each loop allowing us to store the other characters
				letter = input.charAt(charCount);
				//extracts the character at index given by charCount and stores it into letter
				char letterPassword = (char)(letter-7); //modification of character and storing it in letterPassword
				password += letterPassword; //adds new characters onto existing ones
				loopCount--; charCount--;
				//loopCount is decremented to ensure a certain number (5) of loops
				//charCount is decremented at each loop so that the previous character from the input 
				//string is taken
			}
			System.out.println("The password is: " + password + "\n");
		}	
		else //if input String is not 5 characters long
			System.out.print("Sorry this is not a valid 5 character"
					+ " word.");
		
		System.out.print("We hope that you were satisfied with Password Generator! Goodbye.");

	}

}
