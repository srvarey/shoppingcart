
package hmrc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import hmrc.ReadCSV;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;


public class CartTest
{

	@BeforeClass
	public static void setUpClass()
	{
		System.out.println("TestCase1 setup");
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
