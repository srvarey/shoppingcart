
package hmrc;


import java.util.ArrayList;
import java.util.List;

import strategies.ApplePriceStrategyBuyOneGetOneFree;
import strategies.OrangePriceStrategy3for2;
import strategies.PriceStrategy;

/*
Step 1
*/

public class Cart
{

	enum validcode
	{
		ok(0), colErr(1), rowErr(2), boxErr(3), filestructErr(4), numErr(5);

		private final int	value;




		private validcode(int value)
		{
			this.value = value;
		}




		public int getValue()
		{
			return value;
		}
	};




	public Cart()
	{
		// TODO Auto-generated constructor stub
	}




	boolean	debuggingP	= true;




	public List<Item> getItems(String filename) throws Exception
	{
		List<String> itemlist = new ArrayList();
		List<Item> items = new ArrayList();


		ReadCSV reader = new ReadCSV();


		boolean filereadOK = reader.readCartItemInputFile(filename, itemlist);

		if (!filereadOK)
		{
			throw new Exception("INVALID : File format error");
		}




		for (String s : itemlist)
		{
			Item item = CartItemFactory.getItem(s);
			if (item != null)
			{
				items.add(item);
			}

		}


		int count = 0;


		System.out.println();

		for (Item item : items)
		{
			count++;
			System.out.println(String.format("Item %3d is an %6s and priced at %4.2g", count, item.getDescription(), item.getPrice()));
		}

		System.out.println();


		return items;

	}




	//Step 1
	public double getTotalPrice_original(List<Item> items)
	{
		double total = 0.0;

		for (Item item : items)
		{
			total += item.getPrice();
		}

		return total;
	}



	//Step 2
	public double getTotalPrice(List<Item> items)
	{
		double total = 0.0;
		List<Item> orangeList = new ArrayList();
		List<Item> appleList = new ArrayList();

		PriceStrategy orangeStrat = new OrangePriceStrategy3for2();
		PriceStrategy appleStrat = new ApplePriceStrategyBuyOneGetOneFree();


		for (Item item : items)
		{
			if (item instanceof Orange)
			{
				orangeList.add(item);
			}
			else if (item instanceof Apple)
			{
				appleList.add(item);
			}
		}

		double orangePriceTotal = 0.0;
		if (orangeList.size() > 0)
		{
			Item proto = orangeList.get(0);
			proto.setStrategy(orangeStrat);
			total += proto.getStrategy().applyPriceStrategy(orangeList);
		}

		double applePriceTotal = 0.0;
		if (appleList.size() > 0)
		{
			Item proto = appleList.get(0);
			proto.setStrategy(appleStrat);
			total += proto.getStrategy().applyPriceStrategy(appleList);
		}

		return total;
	}




}
