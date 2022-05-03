package venue;

import java.util.Random;

/**
 * The Balcony class extends the Ticket class for the upper level of the venue.
 * Customers can choose to be on the side balcony for an additional cost, or be in the standard upper level. 
 * @author craig
 *
 */
public class Balcony extends Ticket
{
	/**
	 * boolean for side balcony to determine if the additional cost will be added.
	 * static final variable for the standard upper level ticket price.
	 * static final variable for the markup amount for side balcony.
	 * id variable for the ticket ID.
	 */
	public boolean sideBalcony;
	private static final double STANDARD_UPPER_LEVEL_TICKET_PRICE = 15;
	private static final int SIDE_BALCONY_MARKUP = 25;
	private int id;

	/**
	 * Constructor for the Balcony class.
	 * @param ticketPrice each ticket has a price.
	 * @param sideBalcony each ticket is either side balcony or not.
	 */
	public Balcony(double ticketPrice, boolean sideBalcony)
	{
		super(ticketPrice);
		this.sideBalcony = sideBalcony;
		Random random = new Random();
		id = random.nextInt();
		setTicketId("BA-" + id);
		
	}

	@Override
	public double getItemCost()
	{
		double total = getTicketPrice();
		if(sideBalcony) //if sideBalcony is true, add the side balcony market. Else, use the standard upper level ticket price.
		{
			total += SIDE_BALCONY_MARKUP;
		
		}
		else
		{
			total += STANDARD_UPPER_LEVEL_TICKET_PRICE;
		}
		
		return total;
	}

	@Override
	public int getItemId()
	{
		return id;
	}

	/**
	 * Getter for standard upper level ticket price.
	 * @return
	 */
	public static double getStandardUpperLevelTicketPrice()
	{
		return STANDARD_UPPER_LEVEL_TICKET_PRICE;
	}

	/**
	 * Getter for side balcony markup. 
	 * @return
	 */
	public static int getSideBalconyMarkup()
	{
		return SIDE_BALCONY_MARKUP;
	}

	/**
	 * Getter for ticket ID.
	 * @return
	 */
	public int getId()
	{
		return id;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + id;
		result = prime * result + (sideBalcony ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Balcony other = (Balcony) obj;
		if (id != other.id)
			return false;
		if (sideBalcony != other.sideBalcony)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Balcony [sideBalcony=" + sideBalcony + ", id=" + id + "]";
	}

	@Override
	public String getItemName()
	{
		// TODO Auto-generated method stub
		return "Balcony Ticket";
	}
	
	
	
	
}
