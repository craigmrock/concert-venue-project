package venue;

import java.util.Random;

/**
 * The Merchandise class implements the Sales interface.
 * The class is designed to handle items for sale by the bands, like shirts or caps.
 * @author craig
 *
 */
public class Merchandise implements Sales
{
	
	/**
	 * String variable merchandise for the name of each item for sale.
	 * Variable for item base cost.
	 * Variable for item markup.
	 * Variable for discount in case an item goes on sale.
	 * Static final variable for the maximum discount allowed.
	 * Variable for item ID.
	 */
	private String merchandise;
	private double baseCost;
	private double markUp;
	private double discount;
	private static final double MAX_DISCOUNT = .5;  
	private int id;

	/**
	 * Constructor for Merchandise class.
	 * @param merchandise name of the merchandise
	 * @param baseCost 
	 * @param markUp
	 */
	public Merchandise(String merchandise, double baseCost, double markUp)
	{
		
		super();
		this.merchandise = merchandise;
		this.baseCost = baseCost;
		this.markUp = markUp;
		discount = 0;
		Random random = new Random();
		id = random.nextInt();
		
	}

	/**
	 * Getter for item cost.
	 */
	@Override
	public double getItemCost()
	{
		
		double total = 0;
		total = baseCost * (markUp + 1);
		
		if (discount > 0) //if the discount is greater than zero, the calculate the total by subtracting the discounted amount.
		{
			
			double discountedAmount = total * discount;
			total = total - discountedAmount;
			
		}
		
		return total;
	}

	/**
	 * Getter for item ID.
	 */
	@Override
	public int getItemId()
	{
		
		return id;
		
	}

	/**
	 * Getter for merchandise name.
	 * @return
	 */
	public String getMerchandise()
	{
		
		return merchandise;
		
	}

	/**
	 * Getter for base cost.
	 * @return
	 */
	public double getBaseCost()
	{
		
		return baseCost;
		
	}

	/**
	 * Getter for markup.
	 * @return
	 */
	public double getMarkUp()
	{
		
		return markUp;
		
	}
	
	/**
	 * Getter for discount.
	 * @return
	 */
	public double getDiscount()
	{
		
		return discount;
		
	}
	
	/**
	 * Setter for discount.
	 * @return
	 */
	public void setDiscount(double discount)
	{
		
		if (discount < 0) //if statement to keep discount from going less than zero.
		{
			
			this.discount = 0;
			
		}
		
		else if (discount > MAX_DISCOUNT) //if statement to keep discount from going over the set maximum discount.
		{
			
			this.discount = MAX_DISCOUNT;
			
		}
		
		else
		{
			
			this.discount = discount; 
			
		}
		
	}
	
	

	@Override
	public int hashCode()
	{
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((merchandise == null) ? 0 : merchandise.hashCode());
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
		Merchandise other = (Merchandise) obj;
		if (merchandise == null)
		{
			if (other.merchandise != null)
				return false;
		}
		else if (!merchandise.equals(other.merchandise))
			return false;
		return true;
		
	}

	@Override
	public String toString()
	{
		return "Merchandise [merchandise=" + merchandise + ", getItemCost()=" + getItemCost() + "]";
	}

	/**
	 * Getter for item name.
	 * @return
	 */
	@Override
	public String getItemName()
	{
		
		return merchandise;
		
	}
	
	
	

}
