// ---------------------------------------------
// Assignment 4
// Written by: Rami El-Kazma ID 40035141
// COMP 248 Section R
// ---------------------------------------------
import java.util.Scanner;
public class IceCreamStore {

/* Stores a shopping cart and will manipulate the values inside the shopping cart by calling methods from 
 * the ShoppingCart class. This is the main menu of where the user will decide what they want to do. 
 * It calls all other methods in order to facilitate the user. */
	
	//stores a shopping cart
	ShoppingCart cart=new ShoppingCart();
	IceCreamOrder order;
	
	//creates an object of type IceCreamOrder everytime an order is placed
	public void placeOrder(){
		order=new IceCreamOrder();
		cart.add(order);
	}
	
	//lists the available orders in the cart in Menu form to allow the user to select which order is to be deleted
	public void deleteOrder(){
		if(cart.toString()!=null)
		{
			System.out.println("You have selected to remove an order from your cart.\nWhich order would you "+
		"to remove?");
			String[]deleteMenu=new String[cart.size()+1];
			deleteMenu[deleteMenu.length-1]="Exit this menu"; //adding the exit menu option at the end to allow the
															  //user to keep the orders if they wish
			
			for(int i=0;i<deleteMenu.length-1;i++)
				deleteMenu[i]=cart.orders[i].toString(); //assigning the orders to the Menu
			
			Menu delMenu=new Menu(deleteMenu);
			delMenu.setTopPrompt(null);
			int choice=delMenu.getOptionNumber();
			
			if (choice>0&&choice<deleteMenu.length)
			{
				cart.remove(choice-1);
				deleteMenu[choice-1]=null;
				System.out.println("Your order was successfully deleted.\n");
			}
		}
		else cart.remove(0);
	}
	
	//computes price by getting the price of each order in the cart and adding it to variable price 
	public double computeTotalPrice(){
		double price=0;
		for(int i=0;i<cart.size();i++){
			if (cart.orders[i]!=null) //checks whether an order exists to computer the price
				price+=cart.orders[i].price();
		}
		return (price);
	}
	
	//prints the price
	public void printTotalPrice(){
		if(cart.toString()!=null)
			System.out.println("You have "+cart.getCounter()+" ice cream order(s) for a total of: $"+
		computeTotalPrice()+".\n");
	}
	
	public void reviewOrder(){
		if(cart.toString()!=null)
			System.out.println(cart);
	}
	
	public void checkout(){
		reviewOrder();
		if (cart.toString()!=null)
			printTotalPrice();
	}
	
	//runs the program by creating a main menu type list that will loop until the user selects to exit
	public void run(){
		String[] options={"Place an order","Delete an order","Price the cart","List the cart","Proceed to checkout",
		"Exit this menu"};
		Menu shoppingCart=new Menu(options);
		int choice=0;
		while (choice!=6){ //until the user selects to exit the menu
			shoppingCart.chooseMessages(cart.getCounter(),cart.getCartSize()); //determines what messages will
																			   //be printed
			choice = shoppingCart.getOptionNumber();
			//this depends on what the user would like to do
			switch (choice){
			case 1: placeOrder();
			break;
			case 2: deleteOrder();
			break;
			case 3: printTotalPrice();
			break;
			case 4: reviewOrder();
			break;
			case 5: checkout();
			break;
			case 6: System.out.println("We hope you enjoy our delicious Ice Cream!");
			break;
		}
		}
	}

}
