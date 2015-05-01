
package hmrc;

import strategies.ApplePriceStrategyStandard;
import strategies.OrangePriceStrategyStandard;
import strategies.PriceStrategy;

/*
 * Step 2
 */


public class Apple extends Item implements CartItem
{

	static PriceStrategy	strategy;


	static
	{
		strategy = new ApplePriceStrategyStandard();
	}




	public Apple()
	{
		price = 0.60;

	}




	public Apple(double price)
	{
		setPrice(price);
	}




	public String getDescription()
	{
		return "Apple";
	}




	public double myPrice()
	{
		System.out.println(String.format("The Apple  price is %g", price));
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