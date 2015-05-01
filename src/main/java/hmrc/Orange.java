package hmrc;




public class Orange extends Item implements CartItem
{


	Orange()
	{
		price = 0.25;
	}




	Orange(double price)
	{
		setPrice(price);
	}


	public String getDescription() {
		return "Orange";
	}


	public double myPrice()
	{
		System.out.println(String.format("The Orange price is %g", price));
		return getPrice();
	}
}