// ---------------------------------------------
// Assignment 4
// Written by: Rami El-Kazma ID 40035141
// COMP 248 Section R
// ---------------------------------------------
public class IceCreamOrder {
	
/* description of class */	
	
	//instance variables for object IceCreamOrder
	private String flavour;
	private String vessel;
	private String amount;
	private double unitPrice;
	private int quantity;
	
	public String toString(){
		String str = quantity+" orders of "+amount+" of "+flavour+" ice cream in a "+vessel+" for $"+price()+" = "+
				quantity+" x $"+unitPrice+".";
		return str;
	}
	
	//prices each order based on the unit and the orders
	public double price(){
		return unitPrice*quantity;
	}
	
	//getters
	public String getFlavour(){
		return flavour;
	}
	
	public String getVessel(){
		return vessel;
	}
	
	public String getAmount(){
		return amount;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public double getUnitPrice(){
		return unitPrice;
	}
	
	//setters
	public void setFlavour(String input){
		flavour=input;
	}
	
	public void setVessel(String input){
		vessel=input;
	}
	
	public void setAmount(String input){
		amount=input;
	}
	
	public void setQuantity(int input){
		quantity=input;
	}
	
	public void setUnitPrice(double input){
		unitPrice=input;
	}
	
	//constructor allowing setting of all values
	public IceCreamOrder(String inputFlavour,String inputVessel,String inputAmount,double inputUnitPrice, 
			int inputQuantity){
		flavour=inputFlavour;
		vessel=inputVessel;
		amount=inputAmount;
		unitPrice=inputUnitPrice;
		quantity=inputQuantity;
	}
	
	//constructor only initializing the quantity to 1
	public IceCreamOrder(String inputFlavour,String inputVessel,String inputAmount,double inputUnitPrice){
		flavour=inputFlavour;
		vessel=inputVessel;
		amount=inputAmount;
		unitPrice=inputUnitPrice;
		quantity=1;
	}
	
	//lists the choices for the customers in Menu form to allow the user to order the flavour, vessel, etc.
	//sets messages based on type of order
	public IceCreamOrder(){
		//Step A: flavours
		String[] flavourArray={"Avocado","Banana","Chocolate","Hazelnut","Lemon","Mango","Moccha","Vanilla"};
		Menu iceCreamFlavour=new Menu(flavourArray);
		iceCreamFlavour.setOpeningMessage("Placing an order is as easy as ABC, and D.");
		iceCreamFlavour.setTopPrompt("Step A: Select your favorite flavor");
		int flavourChoice=iceCreamFlavour.getOptionNumber();
		flavour=flavourArray[flavourChoice-1];
		
		//Step B: vessel
		String[]vesselArray={"Cone","Cup","Sundae"};
		Menu iceCreamVessel=new Menu(vesselArray);
		iceCreamVessel.setOpeningMessage(null);
		iceCreamVessel.setTopPrompt("Step B: Select a vessel of your choice");
		int vesselChoice=iceCreamVessel.getOptionNumber();
		vessel=vesselArray[vesselChoice-1];
		
		//Step C: amount
		String[]amountArray={"Single Scoop","Double Scoop","Triple Scoop"};
		Menu iceCreamAmount=new Menu(amountArray);
		iceCreamAmount.setTopPrompt("Step C: Select an amount");
		int amountChoice=iceCreamAmount.getOptionNumber();
		amount=amountArray[amountChoice-1];
		
		//Step D: Quantity
		String[]quantityArray={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
		Menu iceCreamQuantity=new Menu(quantityArray);
		iceCreamQuantity.setTopPrompt("Step D: Select a quantity");
		quantity=iceCreamQuantity.getOptionNumber();
		
		//Setting unit prices
		if(vesselChoice==1) //Cone prices
		{
			if (amountChoice==1) //Single scoop
				unitPrice=2.99;
			if (amountChoice==2) //Double scoop
				unitPrice=3.99;
			if (amountChoice==3) //Triple scoop
				unitPrice=3.99;
		}
		if(vesselChoice==2)
		{
			if (amountChoice==1)
				unitPrice=3.49;
			if (amountChoice==2)
				unitPrice=4.49;
			if (amountChoice==3)
				unitPrice=5.49;
		}
		if(vesselChoice==3)
		{
			if (amountChoice==1)
				unitPrice=4.25;
			if (amountChoice==2)
				unitPrice=5.25;
			if (amountChoice==3)
				unitPrice=6.25;
		}
		
	}

}
