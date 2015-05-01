
package strategies;

import hmrc.Item;
import hmrc.Orange;

import java.util.ArrayList;
import java.util.List;

/*
 * Step 2
 */

public class OrangePriceStrategy3for2 implements PriceStrategy
{

	@Override
	public double applyPriceStrategy(List<Item> items)
	{

		double total = 0.0;

		int orangeItems = items.size();

		int oddOnes = 0;
		int threes = orangeItems / 3;




		if (orangeItems % 3 == 1)
		{
			oddOnes = 1;
		}
		else if (orangeItems % 3 == 2)
		{
			oddOnes = 2;
		}

		double unitprice = items.get(0).getPrice();

		total = threes * 2 * unitprice;

		if (oddOnes == 1)
			total += unitprice;

		else if (oddOnes == 2)
			total += 2 * unitprice;


		return total;
	}




	void test()
	{

		int sz = 3;
		List<Item> l = new ArrayList();

		for (int i = 0; i < sz; i++)
		{
			l.add(new Orange());
		}


		double total = applyPriceStrategy(l);
		System.out.println(String.format("Unit price %.2g", l.get(0).getPrice()));
		System.out.println();
		System.out.println(String.format("List price %4.2g for %d oranges", total, sz));
		System.out.println();
		
		sz = 4;
		l.add(new Orange());

		total = applyPriceStrategy(l);
		System.out.println(String.format("List price %4.2g for %d oranges", total, sz));
		System.out.println();
		
		sz = 5;
		l.add(new Orange());

		total = applyPriceStrategy(l);
		System.out.println(String.format("List price %4.3g for %d oranges", total, sz));
		System.out.println();

		sz = 6;
		l.add(new Orange());

		total = applyPriceStrategy(l);
		System.out.println(String.format("List price %4.3g for %d oranges", total, sz));
		System.out.println();

		sz = 7;
		l.add(new Orange());

		total = applyPriceStrategy(l);
		System.out.println(String.format("List price %4.3g for %d oranges", total, sz));

	}




	public static void main(String args[])
	{

		new OrangePriceStrategy3for2().test();
	}
}
