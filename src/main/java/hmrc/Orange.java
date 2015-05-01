
package hmrc;

import strategies.ApplePriceStrategyStandard;
import strategies.OrangePriceStrategyStandard;
import strategies.PriceStrategy;


/*
 * Step 2
 */


public class Orange extends Item implements CartItem
{



	static PriceStrategy	strategy;


	static
	{
		strategy = new OrangePriceStrategyStandard();
	}




	public Orange()
	{
		price = 0.25;

	}




	public Orange(double price)
	{
		setPrice(price);
	}




	public String getDescription()
	{
		return "Orange";
	}




	public double myPrice()
	{
		System.out.println(String.format("The Orange price is %g", price));
		return getPrice();
	}




	@Override
	public void setStrategy(PriceStrategy s)
	{
		strategy = s;

	}




	@Override
	public PriceStrategy getStrategy()
	{
		return strategy;
	}

}