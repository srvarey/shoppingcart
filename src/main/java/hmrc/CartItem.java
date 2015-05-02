
package hmrc;

import strategies.PriceStrategy;

/*
 * Step 2
 */

public interface CartItem
{

	double myPrice();




	String getDescription();




	void setStrategy(PriceStrategy s);




	PriceStrategy getStrategy();
}
