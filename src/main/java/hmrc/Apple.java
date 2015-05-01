
package hmrc;


public class Apple extends Item implements CartItem
{


	Apple()
	{
		price = 0.60;
	}




	Apple(double price)
	{
		setPrice(price);
	}


	public String getDescription() {
		return "Apple";
	}

	public double myPrice()
	{
		System.out.println(String.format("The Apple  price is %g", price));
		return getPrice();
	}
}