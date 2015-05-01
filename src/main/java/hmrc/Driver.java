
package hmrc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class Driver
{

	void doMain(String filename) throws Exception
	{
		Cart c = new Cart();

		
		double total  = c.getTotalPrice(c.getItems(filename));
		
		System.out.println(String.format("Total price = %.2g", total));
		
		
		
		

	}




	public static void main(String[] args) throws Exception
	{

		if (args.length != 1)
		{

			System.out.println("Usage : java -jar <cart input file>");
			return;
		}


		new Driver().doMain(args[0]);

	}




}
