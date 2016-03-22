/* takes in a year from the command line and determines if it is a leap
 * year*/

public class prob3{
	   public static void main( String[] args)
		{
			String strYear = args[0];
			String outPut = "";
			int intYear = Integer.parseInt(strYear);
			if ( ( intYear % 4 ) == 0 )
			{
				if ( ( intYear % 100 ) == 0 )
				{
					if ( ( intYear % 400 ) == 0 )
					{ outPut = "leap year!"; }
					else
					{ outPut = "not a leap year!"; }
				}
				else
				{ outPut = "leap year!"; }
			}
			else
			{ outPut = "not a leap year!"; }
			System.out.println(outPut);
		}
}
