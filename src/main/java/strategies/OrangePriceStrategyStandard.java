package strategies;

import hmrc.Item;

import java.util.List;
/*
 * Step 2
 */


public class OrangePriceStrategyStandard implements PriceStrategy
{

	@Override
	public double applyPriceStrategy(List<Item> items)
	{

		double total = 0.0;
		
		for (Item item : items) {
			total+=item.getPrice();
		}
		return total;
	}

}
