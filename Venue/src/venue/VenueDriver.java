package venue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This is the driver class for the venue. 
 * The driver class takes user input to create customers at the venue for a concert.
 * The user begins by selecting a ticket type, then adds sales items like a band shirt, drinks, and more.
 * When the user is done adding items to a particular customer, they can choose to add a new customer or be done.
 * When the user is done adding customers, the program prints out each customer's items, the customer's total sales, and the total sales for the venue.
 * @author craig
 *
 */
public class VenueDriver
{
	private static final int TICKET_PRICE = 10;
	

	public static void main(String[] args)
	{
		/**
		 * Scanner to get user input.
		 * boolean isValid is used to verify user input is a valid input. If not, the user is prompted to re-enter their input.
		 * boolean addMoreCustomers is used to continue or stop adding new customers.
		 * double totalVenueSales is set to zero and is used to tally up all customer ticket, merchandise, and beverage sales the user creates.
		 * A list of customers is generated from each user-created customer.
		 * A userInput variable is used to store user input.
		 */
		Scanner scanner = new Scanner(System.in);
		boolean isValid = false;
		boolean addMoreCustomers = false;
		double totalVenueSales = 0;
		
		List <Customer> customers = new ArrayList<Customer>();
		
		String userInput;
		
		/**
		 * do while loops go through the user input cycle of creating a customer and each customer's items.
		 * The first do while loop is for entering in a valid ticket type.
		 * The inner do while loop is for creating the customer's ticket type and then adding items to each customer.
		 */
		do
		{
			
			Customer customer = null;
			
			do 
			{
				
				System.out.println("Would you like General Admission or Balcony?");
				userInput = scanner.nextLine().toLowerCase().trim(); //takes user input and automatically makes the first letter lower case, and trims away leading and trailing space.
				
				if (userInput.equalsIgnoreCase("general admission"))//if the user input is general admission, we ask if they want the main floor, followed by backstage passes.
				{
					
					boolean mainFloor = false;
					boolean vipUpgrade = false;
					isValid = true;
					
					System.out.println("Would you like to be on the main floor?");
					userInput = scanner.nextLine().toLowerCase().trim();
					
					if (userInput.substring(0,1).equalsIgnoreCase("y")) //if the first letter of the user input is y.
					{
						
						mainFloor = true;
						
						System.out.println("Would you like a VIP upgrade with Backstage Pass?");
						userInput = scanner.nextLine().toLowerCase().trim();
						
						if (userInput.substring(0,1).equalsIgnoreCase("y"))
						{
							
							vipUpgrade = true;
							
						}
						
					}
					
					Ticket ticket = new GeneralAdmission(TICKET_PRICE, mainFloor, vipUpgrade); //creates ticket for a customer
					customer = new Customer(ticket); //creates new customer with the new ticket
					customers.add(customer); //adds the customer to the customer list
					totalVenueSales += ticket.getItemCost(); //adds the ticket cost to total venue sales.
				
				}
				
				else if (userInput.equalsIgnoreCase("balcony"))//if the user enters a balcony ticket, we then ask if they would like a side balcony ticket.
				{
					
					boolean sideBalcony = false;
					isValid = true;
					
					System.out.println("Would you like to be on the side balcony?");
					userInput = scanner.nextLine().toLowerCase().trim();
					
					if (userInput.substring(0,1).equalsIgnoreCase("y")) 
					{
						
						sideBalcony = true;
						
					}
					
					Ticket ticket = new Balcony(TICKET_PRICE, sideBalcony);
					customer = new Customer(ticket);
					customers.add(customer);
					totalVenueSales += ticket.getItemCost();
		
				}
				else
				{
					
					isValid = false;
					System.out.println("Please enter either General Admission or Balcony");
					
				}
				
			} while (!isValid);
			
			/**
			 * Sales items for merchandise and beverages are created.
			 */
			Sales s1 = new Merchandise("Band Tee", 25, .25);
			Sales s2 = new Merchandise("Band Cap", 15, .25);
			Sales b1 = new Beverage("Beer", true);
			Sales b2 = new Beverage("Water", false);
			
			
			/**
			 * A map of sales items is created as the venue kiosk.
			 */
			Map <String, Sales> venueKiosk = new HashMap<String, Sales>();
			venueKiosk.put(s1.getItemName().toLowerCase(), s1);
			venueKiosk.put(s2.getItemName().toLowerCase(), s2);
			venueKiosk.put(b1.getItemName().toLowerCase(), b1);
			venueKiosk.put(b2.getItemName().toLowerCase(), b2); 
			
			for (String key : venueKiosk.keySet()) //for loop prints each item in the kiosk for the user to review
			{
				
				System.out.println(key);
				
			}
			
			System.out.println("Enter item for a customer: "); //user is prompted to enter an item for a customer
			userInput = scanner.nextLine().toLowerCase();
			
			while (venueKiosk.containsKey(userInput)) //while loop prompts the user to add items to a customer until the user input does not match an item in the kiosk. 
			{
				
				Sales item = venueKiosk.get(userInput);
				customer.addMerchandise(item);
				totalVenueSales += item.getItemCost();;
				
				for (String key : venueKiosk.keySet())
				{
					
					System.out.println(key);
					
				}
				
				System.out.println("Enter item for a customer: ");
				userInput = scanner.nextLine().toLowerCase();
			}
			
			System.out.println("Add another customer?: ");
			userInput = scanner.nextLine().toLowerCase().trim();
			
			if (userInput.substring(0,1).equalsIgnoreCase("y"))
			{
				
				addMoreCustomers = true;
			}
			
			else
			{
				
				addMoreCustomers = false;
				
			}
			
		} while(addMoreCustomers);
		
		

		for (Customer customer : customers) //when the user is done entering customers and their items, this for loop prints each customer, their items, and each customer's total sales.
		{
			
			System.out.println("Customer: " + customer.getSalesItems());
			System.out.println("Customer's total sales: " + customer.getTotalSales());
			
		}
		
		System.out.println("Total Venue Sales: " + totalVenueSales); //print total venue sales.

	}

}
