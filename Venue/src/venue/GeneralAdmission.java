package venue;

import java.util.Random;

/**
 * General Admission class extends the Ticket class.
 * Customers can choose general admission, main floor general admission, or add a backstage pass upgrade.
 * @author craig
 *
 */
public class GeneralAdmission extends Ticket
{
	
	/**
	 * boolean variable for main floor. You're either on the main floor or you're not.
	 * static final variable for main floor ticket price.
	 * boolean for VIP markup. You're either want a backstage pass or not.
	 * variable for ticket ID.
	 */
	public boolean mainFloor;
	private static final double MAINFLOOR_TICKET_PRICE = 25;
	public boolean vipMarkUp;
	private static final int BACKSTAGE_PASS = 200;
	private int id;

	/**
	 * Constructor for General Admission class.
	 * @param ticketPrice each ticket has a price.
	 * @param mainFloor each ticket is either main floor or not.
	 * @param vipMarkUp each ticket either has a markup for VIP/backstage pass or not.
	 */
	public GeneralAdmission(double ticketPrice, boolean mainFloor, boolean vipMarkUp)
	{
		
		super(ticketPrice);
		this.mainFloor = mainFloor;
		this.vipMarkUp = vipMarkUp;
		Random random = new Random();
		id = random.nextInt();
		setTicketId("GA-" + id);
		
	}

	/**
	 * Boolean version of getter for main floor.
	 * @return
	 */
	public boolean isMainFloor()
	{
		
		return mainFloor;
	}
	

	/**
	 * Setter for main floor.
	 * @return
	 */
	public void setMainFloor(boolean mainFloor)
	{
		
		this.mainFloor = mainFloor;
	}
	

	/**
	 * Getter for item cost.
	 * @return
	 */
	@Override
	public double getItemCost()
	{
		
		double total = getTicketPrice();
		 
		if (vipMarkUp) //if vipMarkUp is true, add the additional cost for the VIP markup.
		{
			
			total = total + BACKSTAGE_PASS; 
			mainFloor = true;
			
		}
		
		else if (mainFloor) 
		{
			
			total += MAINFLOOR_TICKET_PRICE;
			
		}
		
		return total;
		
	}

	/**
	 * Getter for item ID.
	 * @return
	 */
	@Override
	public int getItemId()
	{
		
		return id;
		
	}

	/**
	 * Getter for main floor ticket price.
	 * @return
	 */
	public static double getMainfloorTicketPrice()
	{
		
		return MAINFLOOR_TICKET_PRICE;
		
	}

	/**
	 * Boolean version of a getter for VIP markup.
	 * @return
	 */
	public boolean isVipMarkUp()
	{
		
		return vipMarkUp;
		
	}

	/**
	 * Getter for backstage pass.
	 * @return
	 */
	public static int getBackstagePass()
	{
		
		return BACKSTAGE_PASS;
		
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
	public String toString()
	{
		
		return "GeneralAdmission [mainFloor=" + mainFloor + ", vipMarkUp=" + vipMarkUp + ", id=" + id + "]";
		
	}

	/**
	 * Getter for item name.
	 * @return
	 */
	@Override
	public String getItemName()
	{
		
		return "General Admission Ticket";
		
	}
	
	

}
