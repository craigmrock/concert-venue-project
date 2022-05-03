package venue;

/**
 * The Beverage class is designed to handle beverage sales at the venue.
 * There is a non-alcohol option and an alcohol option.
 * @author craig
 *
 */
public class Beverage implements Sales
{

	/**
	 * String variable for the drink name.
	 * Variable for the drink cost.
	 * Boolean variable for alcohol markup. The drink either has alcohol, or does not.
	 * Variable for a drink ID.
	 */
	public String drinkName;
	public double drinkCost = 6;
	public boolean alcoholMarkUp;
	private int id;
	

	/**
	 * Constructor for Beverage class.
	 * Each beverage has a name.
	 * Each beverage either contains alcohol and has a markup, or does not contain alcohol and has no markup.
	 * @param drinkName
	 * @param alcoholMarkUp
	 */
	public Beverage(String drinkName, boolean alcoholMarkUp)
	{
		
		super();
		this.drinkName = drinkName;
		this.alcoholMarkUp = alcoholMarkUp;
		
	}

	/**
	 * Getter for drink name.
	 * @return
	 */
	public String getDrinkName()
	{
		
		return drinkName;
		
	}

	/**
	 * Getter for item cost.
	 * @return
	 */
	@Override
	public double getItemCost()
	{
		double total = drinkCost;
		if (alcoholMarkUp) //if alcohol markup is true, add $6 to the cost of a drink.
		{
			total += 6;
			
		}
		return total;
	}

	/**
	 * Getter for item ID.
	 */
	@Override
	public int getItemId()
	{
		
		// TODO Auto-generated method stub
		return id;
		
	}

	/**
	 * Getter for item name.
	 */
	@Override
	public String getItemName()
	{
		
		// TODO Auto-generated method stub
		return drinkName;
		
	}
	
	/**
	 * Boolean version of getter for alcohol markup.
	 * @return
	 */
	public boolean isAlcoholMarkUp()
	{
		
		return alcoholMarkUp;
		
	}

	/**
	 * Setter for alcohol markup.
	 * @param alcoholMarkUp
	 */
	public void setAlcoholMarkUp(boolean alcoholMarkUp)
	{
		
		this.alcoholMarkUp = alcoholMarkUp;
		
	}
	
	
	
}
