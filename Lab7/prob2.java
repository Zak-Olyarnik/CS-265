/* takes in a number from the command line and determines whether even or
 * odd */

public class prob2{
	public static void main( String[] args)
	{
		String strNum = args[0];
		String outPut = "";
		int intNum = Integer.parseInt(strNum);
		if ( ( intNum % 2 ) == 0 ) // test for odd or even
		{
			outPut = "even";
		}
		else
		{
			outPut = "odd";
		}
		System.out.println(outPut);
	}
}

