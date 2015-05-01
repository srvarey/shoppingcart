
package hmrc;

import strategies.PriceStrategy;

/*
 * Step 2
 */

public interface CartItem
{

	double myPrice();




	String getDescription();




	public void setStrategy(PriceStrategy s);




	public PriceStrategy getStrategy();
}
