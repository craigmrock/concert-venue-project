package venue;

import java.util.ArrayList;
import java.util.List;

/**
 * The Customer class creates a customer for the venue. 
 * Each customer has a ticket.
 * Each customer has a list of sales items that can be printed for review.
 * @author craig
 *
 */
public class Customer 
{
	private List <Sales> salesItems;
	
	/**
	 * The Customer constructor takes a ticket and adds the ticket to the list of the customer's sales items.
	 * @param ticket
	 */
	public Customer(Ticket ticket)
	{
		
		super();
		salesItems = new ArrayList<Sales>();
		salesItems.add(ticket);
		
	}
	
	/**
	 * The getTotalSales() method takes each item in the sales items list and adds them together to generate the total amount each customer spent. 
	 * @return total sales or how much the customer spent at the show
	 */
	public double getTotalSales()
	{
		
		double totalSales = 0;
		
		for (Sales item : salesItems) //for each item in the sales item list, add the item cost to the total sales variable
		{
			totalSales += item.getItemCost();
		}
		return totalSales;
		
	}
	
	/**
	 * The addMerchandise() method takes a Sales item and adds it to the customers list of sales items.
	 * @param item
	 */
	public void addMerchandise(Sales item)
	{
		
		salesItems.add(item);
		
	}
	
	/**
	 * Getter for ticket by going to the first item in the list of the customer's sales items.
	 * @return zero index element in the salesItems list
	 */
	public Ticket getTicket()
	{
		
		return (Ticket) salesItems.get(0);
		
	}
	
	/**
	 * Getter for the salesItems list to print out each customer's items they purchased at the concert.
	 * @return
	 */
	public List<Sales> getSalesItems()
	{
		
		return salesItems;
		
	}

	/**
	 * toString method that returns a customer's total sales, ticket, and sales items.
	 */
	@Override
	public String toString()
	{
		
		return "Customer [getTotalSales()=" + getTotalSales() + ", getTicket()="
				+ getTicket() + ", getSalesItems()=" + getSalesItems() + "]";
		
	}

	
	
	
	
	
	

}
