
package hmrc;

import strategies.PriceStrategy;


/*
 * Step 2
 */

abstract public class Item
{

	double	price;




	abstract String getDescription();




	abstract void setStrategy(PriceStrategy s);




	abstract PriceStrategy getStrategy();




	public double getPrice()
	{
		return price;
	}




	public void setPrice(double price)
	{
		this.price = price;
	}




}
