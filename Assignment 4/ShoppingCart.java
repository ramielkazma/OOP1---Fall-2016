// ---------------------------------------------
// Assignment 4
// Written by: Rami El-Kazma ID 40035141
// COMP 248 Section R
// ---------------------------------------------
public class ShoppingCart {

/* Creates an array or IceCreamOrders that will store 5 orders and then manipulate them based on the
 * requirements of the user. */	
	
	private int counter=0; //count the number of orders
	private final int MAX_ORDERS=5; //max number of orders
	IceCreamOrder[] orders;
	
	//creating an array of type IceCreamOrder objects
	public ShoppingCart(){
		orders=new IceCreamOrder[MAX_ORDERS];
	}
	
	//we cannot add orders if the the ice cream orders already exceed 5
	public void add(IceCreamOrder order){
		if (isFull())
			System.out.println("Sorry, request cannot be processed. Your cart is full.\n");
		else 
		{
			orders[counter]=order;
			counter++; //increments the counter everytime an ice cream order is added
		}
	}
	
	//we cannot remove orders if there are no orders
	public void remove(int position){
		if(isEmpty()||position<0||position>MAX_ORDERS-1)
			System.out.println("Sorry, request cannot be processed. Your cart is empty or invalid order number.\n");
		else 
		{
			orders[position]=null; //removes the ice cream order in this position
			counter--; //decrements after order is removed to allow another order to take its place
			
			int i=MAX_ORDERS-1;
			while (orders[i]==null)
				i--;
			orders[position]=orders[i];
			orders[i]=null;
		}
	}

	public String toString(){
		String str="", s="";
		if(!isEmpty()){
			for(int i=0;i<counter;i++){
					str=orders[i].toString()+"\n";
					s+=str;
				}
			return s;
		}	
			else return "";
	}
		
	//if the counter=5, then we have added enough orders for the cart to be full
	public boolean isFull(){
		return(counter==MAX_ORDERS);
	}
	
	//if the counter=0 then we have not added any orders
	public boolean isEmpty(){
		return (counter==0); 
	}
	
	//returns the ice cream order at the determined position.
	public IceCreamOrder get(int position){
		if(isEmpty()||position<0||position>MAX_ORDERS-1||orders[position]==null)
		{
			System.out.println("Sorry order could not be processed.");
			return null; //returns null when the desired position is not within the bounds of the array or the order
						 //does not exist
		}
		else return (orders[position]);
	}
	
	//computes the number of orders available by going through the array and incrementing when an order is found
	public int size(){
		int numberOfOrders=0;
		for (int i=0; i<orders.length;i++)
		{
			if (orders[i]!=null) //if it is not null then it contains an order
				numberOfOrders++;
		}
		return numberOfOrders;
	}
	
	//My methods
	//use this method to determine the messages (ie if the cart is full or empty or contains 1 order, etc.)
	public int getCounter(){
		return counter;
	}
	
	//method to return the maximum possible value of orders
	public int getCartSize(){
		return MAX_ORDERS;
	}
	
}
