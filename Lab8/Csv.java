import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Csv
{
	public static void main(String[] args)
	{
		String file = "test.csv";
		BufferedReader fileReader = null;

		try
		{
			String line = "";
			fileReader = new BufferedReader(new FileReader(file));

			while((line = fileReader.readLine()) != null)
			{
				int nfield = 0;
				
				// reg exp splits at commas or even numbers of quotes
				String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				for(String fld : tokens)
				{
					// trims string,removes escaped quotes, removes quotes around
					// fields
					//fld = fld.trim();
					//fld = fld.replace("\"\"","\"");
					//if (fld.charAt(0) == '\"' && fld.charAt(fld.length()-1) == '\"')
					//		fld = fld.substring(1,fld.length()-1);
					
					nfield = nfield+1;
					//System.out.println(fld);
				}
				System.out.println(nfield);
			}
		}
		catch(Exception e){e.printStackTrace();}
		finally
		{
			try{fileReader.close();}
			catch(IOException e){e.printStackTrace();}
		}
	}
}
