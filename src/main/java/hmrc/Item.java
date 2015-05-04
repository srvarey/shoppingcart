
package hmrc;

import strategies.PriceStrategy;



abstract public class Item
{

	double	price;					// Step 1




	abstract String getDescription();		// Step 1




	abstract void setStrategy(PriceStrategy s);	// Step 2




	abstract PriceStrategy getStrategy();		// Step 2




	public double getPrice()
	{
		return price;
	}




	public void setPrice(double price)
	{
		this.price = price;
	}




}
