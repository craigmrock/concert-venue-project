package venue;

/**
 * The Ticket class implements the Sales interface.
 * The Ticket class is abstract because the General Admission and Balcony classes are subclasses of the Ticket class.
 * @author craig
 *
 */
public abstract class Ticket implements Sales
{
	/**
	 * Each ticket has a price and ID.
	 */
	private double ticketPrice;
	private String ticketId;
	
	/**
	 * Constructor for the Ticket class.
	 * @param ticketPrice
	 */
	public Ticket(double ticketPrice)
	{
		
		super();
		this.ticketPrice = ticketPrice;
		
	}

	/**
	 * Getter for ticket ID.
	 * @return
	 */
	public String getTicketId()
	{
		
		return ticketId;
		
	}

	/**
	 * Getter for ticket price.
	 * @return
	 */
	public double getTicketPrice()
	{
		
		return ticketPrice;
		
	}
	
	/**
	 * Setter for ticket ID.
	 * @param ticketId
	 */
	public void setTicketId(String ticketId)
	{
		
		this.ticketId = ticketId;
		
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ticketId == null) ? 0 : ticketId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(ticketPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (ticketId == null)
		{
			if (other.ticketId != null)
				return false;
		}
		else if (!ticketId.equals(other.ticketId))
			return false;
		if (Double.doubleToLongBits(ticketPrice) != Double.doubleToLongBits(other.ticketPrice))
			return false;
		return true;
	}
	
}
