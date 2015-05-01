
package strategies;

import hmrc.Item;

import java.util.List;

/*
 * Step 2
 */

public class ApplePriceStrategyBuyOneGetOneFree implements PriceStrategy
{

	@Override
	/*
	 * 
	 * TODO
	 * No time now but should be checking that list contains even number of apples and log or warn or call some some system function
	 * 
	 */
	public double applyPriceStrategy(List<Item> items)
	{

		double total = 0.0;

		int appleItems = items.size();

		int pairs = appleItems / 2;




		double unitprice = items.get(0).getPrice();

		total = pairs * unitprice;

		if (appleItems % 2 == 1)
		{
			total +=unitprice;
		}



		return total;
	}

}
