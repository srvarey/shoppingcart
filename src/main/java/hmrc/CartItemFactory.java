
package hmrc;


public class CartItemFactory
{

	public static Item getItem(String item)
	{
		if (item.equals("Apple"))
			return new Apple();

		else if (item.equals("Orange"))
			return new Orange();

		else
			return null;


	}
}
