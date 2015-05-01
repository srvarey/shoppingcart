
package hmrc;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import strategies.ApplePriceStrategyBuyOneGetOneFree;
import strategies.OrangePriceStrategy3for2;


public class CartTest
{

	@BeforeClass
	public static void setUpClass()
	{
		System.out.println("TestCase1 setup");
	}


	public static double round2DecimalPlaces(double value,int decimalPlaces)
	{
	    int s = value<0?-1:1;
	    double p = 1;
	    for (int i = 0; i < decimalPlaces; i++) {
	        p*=10;
	    }

	    double n = (long) value;
	    double d = ((value*10*p)-(n*10*p));
	    d +=s*5;
	    d /= 10;
	    d = (long)d;
	    d /= p;
	    return d+n;
	}

	@Test
	public void testApplePriceStrategy()
	{

		int sz = 2;
		List<Item> l = new ArrayList();

		for (int i = 0; i < sz; i++)
		{
			l.add(new Apple());
		}


		ApplePriceStrategyBuyOneGetOneFree strat = new ApplePriceStrategyBuyOneGetOneFree();

		double total = strat.applyPriceStrategy(l);
		// 2 apples
		assertTrue(total == .6);

		l.add(new Apple());
		total = strat.applyPriceStrategy(l);
		// 3 apples
		assertTrue(total == 1.2);

		l.add(new Apple());
		total = strat.applyPriceStrategy(l);
		// 4 apples
		assertTrue(total == 1.2);

		l.add(new Apple());
		total = strat.applyPriceStrategy(l);
		// 5 apples
		assertTrue(round2DecimalPlaces(total, 2) == 1.8);

		l.add(new Apple());
		total = strat.applyPriceStrategy(l);
		// 6 apples
		assertTrue(round2DecimalPlaces(total, 2) == 1.8);

	}




	@Test
	public void testOrangePriceStrategy()
	{

		int sz = 3;
		List<Item> l = new ArrayList();

		for (int i = 0; i < sz; i++)
		{
			l.add(new Orange());
		}


		OrangePriceStrategy3for2 strat = new OrangePriceStrategy3for2();

		double total = strat.applyPriceStrategy(l);
		assertTrue(total == .5);

		sz = 4;
		l.add(new Orange());
		total = strat.applyPriceStrategy(l);
		assertTrue(total == .75);

		sz = 5;
		l.add(new Orange());
		total = strat.applyPriceStrategy(l);
		assertTrue(total == 1.0);

		sz = 6;
		l.add(new Orange());
		total = strat.applyPriceStrategy(l);
		assertTrue(total == 1.0);

		sz = 7;
		l.add(new Orange());
		total = strat.applyPriceStrategy(l);
		assertTrue(total == 1.25);

	}




	@Test
	public void testGoodFile()
	{
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("cartinput.txt").getFile());

		List<String> cartinput = new ArrayList();

		ReadCSV reader = new ReadCSV();


		assertTrue(reader.readCartItemInputFile(file.getAbsolutePath(), cartinput));

	}




	@Test
	public void testRunme()
	{
		assertTrue("This will succeed.", true);
	}

}
