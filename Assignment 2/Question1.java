import java.util.Scanner;
public class Question1 {

/* This program asks the user for a 4 integer "code" in order to encrypt it in another
 * 4 integer code. The aim is to store this data (input code) more securely in a form
 * which only the receiver can decipher. */	
	
	public static void main(String[] args) {
		
		Scanner myKeyboard = new Scanner(System.in);
		
		System.out.println("Hello.\n");
		System.out.print("Enter a 4 digit code you want to encrypt. ");
		//prompting user to input code in order to encrypt it
		int inputCode = myKeyboard.nextInt();
		
		if (inputCode>=1000 && inputCode<=9999) //makes sure that the input code is exactly 4 integers
		{
			int digit4 = (inputCode%10);         //extracts the 4th digit
			inputCode = ((inputCode-digit4)/10); //retains first 3 integers
			int digit3 = (inputCode%10);         //extracts 3rd digit
			inputCode = ((inputCode-digit3)/10); //retains first 2 integers
			int digit2 = (inputCode%10);         //extracts 2nd integers
			inputCode = ((inputCode-digit2)/10); //retains first integer
			int digit1 = (inputCode%10);         //extracts 1st integer
			//the modulus function will divide the code by 10 leaving the final digit as a remainder
			//ex. 1234/10=123 with remainder 4.

			//formula for code encryption
			int digitEncrypted1=(digit1+7)%10;
			int digitEncrypted2=(digit2+7)%10;
			int digitEncrypted3=(digit3+7)%10;
			int digitEncrypted4=(digit4+7)%10;

			System.out.println("The encrypted code is: " + digitEncrypted3 + "" + digitEncrypted4 + "" +
					digitEncrypted1 + "" + digitEncrypted2 + "\n");
			//resets the order of the integers to the desired order in the encrypted code
			//null strings in between integers are necessary to avoid addition and print integers 
		}
		else //if input code is not exactly 4 digits
			System.out.println("Sorry this is not a valid 4 digit number.\n");
			
		System.out.print("Thank you for using 4-Encypter!");
		
	}

}
