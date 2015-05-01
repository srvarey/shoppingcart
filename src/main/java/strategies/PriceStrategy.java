
package strategies;

import hmrc.Item;

import java.util.List;

/*
 * Step 2
 */

public interface PriceStrategy
{

	double applyPriceStrategy(List<Item> items);
}
