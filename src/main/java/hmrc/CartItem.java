
package hmrc;

import strategies.PriceStrategy;


public interface CartItem
{

	double myPrice();			//Step 1




	String getDescription();		//Step 1




	void setStrategy(PriceStrategy s);	//Step 2




	PriceStrategy getStrategy();		//Step 2
}
