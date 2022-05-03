package venue;

/**
 * The Sales interface works with tickets, beverages, and merchandise of the venue.
 * Each item for sale has a cost, ID, and a name.
 * @author craig
 *
 */
public interface Sales
{
	
	public double getItemCost();
	public int getItemId();
	public String getItemName();
	
}
