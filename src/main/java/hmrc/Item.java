package hmrc;

/*
 * Step 1
 */

abstract public class Item
{

	double price;

	abstract String getDescription();
	
	public double getPrice()
	{
		return price;
	}

	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	
}
