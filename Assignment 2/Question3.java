
public class Question3 {
	
/* This program simulates a game in which two players will roll die and depending on the number
 * they get, they add body parts to elephant. There is a sequence (ie the elephant has to have 
 * a body before any other part, a head before the ears and the trunk) and quantity (the elephant
 * has to have 4 legs and 2 ears) to be followed. The first player to complete the their elephant
 * wins the game. */

	public static void main(String[] args) {

		System.out.println("Welcome to Draw an Elephant!\n");
		
		int roundNumber = 1;	//defines the round number and increments after each loop
		int diceRollP1, diceRollP2;		//simulates the roll of the dice
		int bodyP1=0, trunkP1=0, legsP1=0, earsP1=0, tailP1=0, headP1=0,	//Player 1 body parts 
			bodyP2=0, trunkP2=0, legsP2=0, earsP2=0, tailP2=0, headP2=0,	//Player 2 body parts
			bodyPartsP1=0, bodyPartsP2=0;	//the variables bodyParts allow us to eventually determine the winner
		String player1 = "	Player 1's elephant has no body,"
				+ " no head, no ear(s), no trunk, no tail,"
				+ " and no leg(s).";
		String player2 = "	Player 2's elephant has no body,"
				+ " no head, no ear(s), no trunk, no tail,"
				+ " and no leg(s).";
		//initial statements with no body parts, which the program will use to add
		//body parts according to dice rolls
		
		do
		{
			diceRollP1 = (int)(Math.random()*6)+1;
			diceRollP2 = (int)(Math.random()*6)+1;
			//randomize the dice roll from 1 to 6
			
			System.out.print("Round " + roundNumber++ + ": ");		//increment round number
			System.out.println("Player 1 rolled " + diceRollP1 +
					" while Player 2 rolled " + diceRollP2 + ".");

			//since player 2 statements are a replica of player 1 statements, the comments apply for both
			if (bodyP1==0&&diceRollP1==3)	//body is drawn at dice roll 3
											//the body has to be the first body part drawn, and this if
											//statement checks whether or not the body has been drawn
			{
					bodyP1=1;
					player1=player1.replace("no body", "a body");	// draw a body
			}
			else if (bodyP1==1)	//Player 1 statements after the body has been drawn
			{
				switch (diceRollP1)
				{
				case 1:			    //trunk
					if (headP1==1)	//the trunk cannot be drawn before the head
					{
						player1=player1.replace("no trunk", "a trunk");		//draw the trunk
						trunkP1=1;		//set the variable to 1 as it helps us determine who wins at the end
					}
					break;
				case 2: 			//head
					player1=player1.replace("no head", "a head");	//draw the head
					headP1=1;
					break;
				case 3:		//at this point the body has been drawn so this roll will change nothing
					break;
				case 4:
					player1=player1.replace("no tail", "a tail");	//draw the tail
					tailP1=1;
					break;
				case 5:
					if (legsP1<4)	//there have to be 4 legs to complete the elephant
					{
						++legsP1;	//increment when one leg is added
						player1=player1.replace("no leg(s)", legsP1 + " leg(s)");
						player1=player1.replace((legsP1-1) + " leg(s)", legsP1 + " leg(s)");
						//replace no leg(s) in the statement with the amount of legs.
						//legsP1-1 is to change from for ex. 1 leg to 2 legs in the statement.
					}
					break;
				case 6:
					if (headP1==1&&earsP1<2) //check whether the elephant has a head before adding ears
					{						 //elephant has to have 2 ears to be complete
						++earsP1;	//increment when one ear is added
						player1=player1.replace("no ear(s)", earsP1 + " ear(s)");
						player1=player1.replace((earsP1-1) + " ear(s)", earsP1 + " ear(s)");
						//replace no ear(s) in the statement with the amount of ears.
						//earsP1-1 is to change from 1 ear to 2 ears in the statement.
					}
					break;
				}
			}
			System.out.println(player1);	//general statement to print out Player 2's elephant

			if (bodyP2==0&&diceRollP2==3) //Player 2
			{
				bodyP2=1;
				player2=player2.replace("no body", "a body");
			}
			else if (bodyP2==1) //Player 2 statements with body
			{
				switch (diceRollP2)
				{
				case 1:
					if (headP2==1)
					{
						player2=player2.replace("no trunk", "a trunk");
						trunkP2=1;
					}
					break;
				case 2:
					player2=player2.replace("no head", "a head");
					headP2=1;
					break;
				case 3:
					break;
				case 4:
					player2=player2.replace("no tail", "a tail");
					tailP2=1;
					break;
				case 5:
					if (legsP2<4)
					{
						legsP2++;
						player2=player2.replace("no leg(s)", legsP2 + " leg(s)");
						player2=player2.replace((legsP2-1) + " leg(s)", legsP2 + " leg(s)");
					}
					break;
				case 6:
					if (headP2==1&&earsP2<2)
					{
							earsP2++;
							player2=player2.replace("no ear(s)", earsP2 + " ear(s)");
							player2=player2.replace((earsP2-1) + " ear(s)", earsP2 + " ear(s)");
					}
					break;
				}
			}
			System.out.println(player2 + "\n");
			
			//total number of body parts
			bodyPartsP1 = earsP1+tailP1+legsP1+trunkP1+headP1+bodyP1;
			bodyPartsP2 = earsP2+tailP2+legsP2+trunkP2+headP2+bodyP2;
		}
		while (bodyPartsP1!=10&&bodyPartsP2!=10); //goes on until one of the players has completed all body parts
		//we could avoid computing bodyParts and have all the separate body parts (ex. bodyP1=1, headP1=1, etc.
		//but this is simpler
		
		if (bodyPartsP1==10)	//Player 1 completed the elephant
			System.out.println("CONGRATULATIONS Player 1! Your elephant is complete.\n");
		else 					//Player 2 completed the elephant
			System.out.println("CONGRATULATIONS Player 2! Your elephant is complete.\n");
		
		System.out.println("Hope you enjoyed playing Draw an Elephant!");
	
	}
	
}