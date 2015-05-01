
package hmrc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Step 1
 */

public class ReadCSV
{

	public static void main(String[] args)
	{

		ReadCSV obj = new ReadCSV();
		List<String> cartinput = new ArrayList();

		String csvFile = "cartinput.txt";

		obj.readCartItemInputFile(csvFile, cartinput);

	}


	boolean	debuggingP	= false;




	public boolean readCartItemInputFile(String csvFile, List<String> cartinput)
	{

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try
		{

			br = new BufferedReader(new FileReader(csvFile));
			int row = 0;
			while ((line = br.readLine()) != null)
			{

				// use comma as separator
				String[] items = line.split(cvsSplitBy);
				for (String s : items)
					cartinput.add(s);

				row++;
			}

		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
					return false;

				}
			}
		}

		return true;
	}
}